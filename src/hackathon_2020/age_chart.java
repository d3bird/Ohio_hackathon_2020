package hackathon_2020;

import java.util.Vector;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;

public class age_chart extends ApplicationFrame {

	private static String title;
	data_processing data_set;
	int index;

	// public Graph_window(String t, data_storage data) {
	public age_chart(String t, data_processing i, int in) {
		super(t);
		title = t;
		data_set = i;
		index = in;
		System.out.println(index);
		// create_line_graph(data);
		create_line_graph();
	}

	// private DefaultCategoryDataset createDataset(data_storage data){
	private DefaultCategoryDataset createDataseta() {
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
			mounths[mon] += data.get(i).case_count;
			// mounths[mon] = mounths[mon] + data.get(i).case_count;
		}

		dataset.addValue(mounths[0], cases, "jan");
		dataset.addValue(mounths[1], cases, "1980");
		dataset.addValue(mounths[2], cases, "1990");
		dataset.addValue(mounths[3], cases, "2000");
		dataset.addValue(mounths[4], cases, "2010");
		dataset.addValue(mounths[5], cases, "2014");
		dataset.addValue(mounths[6], cases, "2014");
		dataset.addValue(mounths[7], cases, "2014");
		dataset.addValue(mounths[8], cases, "2014");
		dataset.addValue(mounths[9], cases, "2014");
		dataset.addValue(mounths[10], cases, "2014");
		dataset.addValue(mounths[11], cases, "2014");

		return dataset;
	}

	private  PieDataset createDataset() {


		Vector<pie_data> pie_data_points = new Vector<pie_data>();
		Vector<age_data> data = data_set.getCondensed_covid_data_points().get(index).age_date_data;
		String last_name ="";
		pie_data data_add;
		for(int i =0 ; i <data.size();i++) {
			if(!last_name.equals(data.get(i).age_range)){
				data_add = new pie_data();
				last_name = data.get(i).age_range;
				data_add.age = last_name;
				data_add.num =1;
				pie_data_points.add(data_add);
			}else {
				pie_data_points.get(pie_data_points.size()-1).num +=1;
			}
			
		}

		DefaultPieDataset dataset = new DefaultPieDataset();
		
		for(int i=0;i<pie_data_points.size();i++) {
			dataset.setValue(pie_data_points.get(i).age, pie_data_points.get(i).num);
		}
		

		return dataset;
	}

	// public JPanel create_line_graph(data_storage data) {
	public JPanel create_line_graph() {
		JFreeChart lineChart = ChartFactory.createPieChart("", // chart title
				createDataset(), // data
				true, // include legend
				true, false);

		ChartPanel chartPanel = new ChartPanel(lineChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
		setContentPane(chartPanel);

		return chartPanel;
	}

}
