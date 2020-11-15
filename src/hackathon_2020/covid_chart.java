package hackathon_2020;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class covid_chart extends ApplicationFrame {

	private static String title;
	data_processing data_set;
	int index;

	// public Graph_window(String t, data_storage data) {
	public covid_chart(String t, data_processing i, int in) {
		super(t);
		title = t;
		data_set = i;
		index = in;
		// System.out.println(index);
		// create_line_graph(data);
		create_line_graph();
	}

	// private DefaultCategoryDataset createDataset(data_storage data){
	private DefaultCategoryDataset createDataset() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		String cases = "cases";
		// y = case
		// x = date
		Vector<age_data> data = data_set.getCondensed_covid_data_points().get(index).age_date_data;

		int mounths[] = new int[12];
		mounths[0] = 0;
		mounths[1] = 0;
		mounths[3] = 0;
		mounths[4] = 0;
		mounths[5] = 0;
		mounths[6] = 0;
		mounths[7] = 0;
		mounths[8] = 0;
		mounths[9] = 0;
		mounths[10] = 0;
		mounths[11] = 0;

		for (int i = 0; i < data.size(); i++) {
			// dataset.addValue(data.get(i).case_count, cases, data.get(i).date);
			// System.out.println(data.get(i).case_count + " " + data.get(i).date);
			String temp[] = data.get(i).date.split("/");
			int mon = Integer.parseInt(temp[0]);
			mounths[mon-1] += data.get(i).case_count;
			// mounths[mon] = mounths[mon] + data.get(i).case_count;
		}

		dataset.addValue(mounths[0], cases, "Jan");//uary");
		dataset.addValue(mounths[1], cases, "Feb");//ruary");
		dataset.addValue(mounths[2], cases, "Mar");//ch");
		dataset.addValue(mounths[3], cases, "Apr");//il");
		dataset.addValue(mounths[4], cases, "May");
		dataset.addValue(mounths[5], cases, "Jun");//e");
		dataset.addValue(mounths[6], cases, "Jul");//y");
		dataset.addValue(mounths[7], cases, "Aug");//ust ");
		dataset.addValue(mounths[8], cases, "Sep");//tember");
		dataset.addValue(mounths[9], cases, "Oct");//ober");
		dataset.addValue(mounths[10], cases, "Nov");//ember");
		//dataset.addValue(mounths[11], cases, "December");

		return dataset;
	}

	// public JPanel create_line_graph(data_storage data) {
	public JPanel create_line_graph() {
		JFreeChart lineChart = ChartFactory.createLineChart(title, "date", "cases",
				// createDataset(data),
				createDataset(), PlotOrientation.VERTICAL, true, true, false);

		ChartPanel chartPanel = new ChartPanel(lineChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
		setContentPane(chartPanel);

		return chartPanel;
	}

}
