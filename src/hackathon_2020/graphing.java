package hackathon_2020;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import org.jfree.ui.RefineryUtilities;

public class graphing {

	data_processing data;
	private static String title;

	covid_chart covid_chart1;
	boolean covid_chart1_c;

	covid_chart covid_chart2;
	boolean covid_chart2_c;

	age_chart age_chart1;
	boolean age_chart1_c;

	age_chart age_chart2;
	boolean age_chart2_c;

	age_chart group_chart1;
	boolean group_chart1_c;

	age_chart group_chart2;
	boolean group_chart2_c;

	public graphing(String t, data_processing i) {
		data = i;
		title = t;
		covid_chart1_c = false;
		covid_chart2_c = false;

	}

	public void create_covid_graph(int index, int selcection) {
		String title = "covid cases for " + data.getCondensed_covid_data_points().get(index).county + " county";

		if (selcection == 1) {
			if (covid_chart1_c) {
				covid_chart1.dispose();
				covid_chart1 = new covid_chart(title, data, index);
				covid_chart1.setSize(400, 400);
				RefineryUtilities.centerFrameOnScreen(covid_chart1);
				covid_chart1.setVisible(true);
				covid_chart1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				covid_chart1_c = true;
			} else {
				covid_chart1 = new covid_chart(title, data, selcection);
				covid_chart1.setSize(400, 400);
				RefineryUtilities.centerFrameOnScreen(covid_chart1);
				covid_chart1.setVisible(true);
				covid_chart1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				covid_chart1_c = true;
			}
		} else {
			if (covid_chart2_c) {
				covid_chart2.dispose();
				covid_chart2 = new covid_chart(title, data, index);
				covid_chart2.setSize(400, 400);
				RefineryUtilities.centerFrameOnScreen(covid_chart2);
				covid_chart2.setVisible(true);
				covid_chart2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				covid_chart2_c = true;
			} else {
				covid_chart2 = new covid_chart(title, data, index);
				covid_chart2.setSize(400, 400);
				RefineryUtilities.centerFrameOnScreen(covid_chart2);
				covid_chart2.setVisible(true);
				covid_chart2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				covid_chart2_c = true;
			}
		}
	}

	public void create_pie_chart(int index, int selcection, boolean ages) {
		String title = "ages of people infected " + data.getCondensed_covid_data_points().get(index).county + " county";

		if (ages) {
			if (selcection == 1) {
				if (age_chart1_c) {
					age_chart1.dispose();
					age_chart1 = new age_chart(title, data, index, ages);
					age_chart1.setSize(400, 400);
					RefineryUtilities.centerFrameOnScreen(age_chart1);
					age_chart1.setVisible(true);
					age_chart1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					age_chart1_c = true;
				} else {
					age_chart1 = new age_chart(title, data, selcection, ages);
					age_chart1.setSize(400, 400);
					RefineryUtilities.centerFrameOnScreen(age_chart1);
					age_chart1.setVisible(true);
					age_chart1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					age_chart1_c = true;
				}
			} else {
				if (age_chart2_c) {
					age_chart2.dispose();
					age_chart2 = new age_chart(title, data, index, ages);
					age_chart2.setSize(400, 400);
					RefineryUtilities.centerFrameOnScreen(age_chart2);
					age_chart2.setVisible(true);
					age_chart2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					age_chart2_c = true;
				} else {
					age_chart2 = new age_chart(title, data, index, ages);
					age_chart2.setSize(400, 400);
					RefineryUtilities.centerFrameOnScreen(age_chart2);
					age_chart2.setVisible(true);
					age_chart2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					age_chart2_c = true;
				}
			}
		} else {
			if (selcection == 1) {
				if (group_chart1_c) {
					group_chart1.dispose();
					group_chart1 = new age_chart(title, data, index, ages);
					group_chart1.setSize(400, 400);
					RefineryUtilities.centerFrameOnScreen(group_chart1);
					group_chart1.setVisible(true);
					group_chart1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					group_chart1_c = true;
				} else {
					group_chart1 = new age_chart(title, data, selcection, ages);
					group_chart1.setSize(400, 400);
					RefineryUtilities.centerFrameOnScreen(group_chart1);
					group_chart1.setVisible(true);
					group_chart1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					group_chart1_c = true;
				}
			} else {
				if (group_chart2_c) {
					group_chart2.dispose();
					group_chart2 = new age_chart(title, data, index, ages);
					group_chart2.setSize(400, 400);
					RefineryUtilities.centerFrameOnScreen(group_chart2);
					group_chart2.setVisible(true);
					group_chart2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					group_chart2_c = true;
				} else {
					group_chart2 = new age_chart(title, data, index, ages);
					group_chart2.setSize(400, 400);
					RefineryUtilities.centerFrameOnScreen(group_chart2);
					group_chart2.setVisible(true);
					group_chart2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					group_chart2_c = true;
				}
			}

		}
	}

}
