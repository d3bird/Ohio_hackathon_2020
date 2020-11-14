package hackathon_2020;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class data_importing {

	public data_importing() throws IOException {
		covid_data_points = new Vector<covid_data_point>();
		get_covid_data();
		get_population_data();
	}

	private void get_covid_data() throws IOException {

		BufferedReader csvReader = new BufferedReader(new FileReader(
				"C:\\Users\\dogbi\\eclipse-workspace\\hackathon_2020\\src\\hackathon_2020\\COVIDSummaryData.csv"));
		String row;
		int count = 0;
		covid_data_point temp;
		boolean first = true;
		while ((row = csvReader.readLine()) != null) {
			String[] data = row.split(",");
			/*System.out.println(row);
			// System.out.println(data.toString());

			for (int i = 0; i < data.length; i++) {
				if (data[i].equals("")) {
					System.out.print("- ");
				} else {
					System.out.print(data[i] + " ");
				}
			}
			System.out.println(data.length + " :length");
*/
			if (first) {
				first = false;
			} else {
				temp = new covid_data_point();

				if (data[0].equals("")) {
					temp.county = "-1";
				} else {
					temp.county = data[0];
				}
				if (data[1].equals("")) {
					temp.gender = "-1";
				} else {
					temp.gender = data[1];
				}
				if (data[2].equals("")) {
					temp.age_range = "-1";
				} else {
					temp.age_range = data[2];
				}

				if (data[3].equals("")) {
					temp.onset_date = "-1";
				} else {
					temp.onset_date = data[4];
				}
				if (data[4].equals("")) {
					temp.death_date = "-1";
				} else {
					temp.death_date = data[5];
				}
				if (data[5].equals("")) {
					temp.admin_date = "-1";
				} else {
					temp.admin_date = data[6];
				}
				try {
					if (data[6].equals("")) {
						temp.case_count = -1;
					} else {
						temp.case_count = Integer.parseInt(data[6]);
					}
				} catch (Exception e) {
					System.out.println(e);
				}
				try {
					if (data[7].equals("")) {
						temp.death_count = -1;
					} else {
						temp.death_count = Integer.parseInt(data[7]);
					}
				} catch (Exception e) {
					System.out.println(e);
				}

				try {
					if (data[8].equals("")) {
						temp.hospital_count = -1;
					} else {
						temp.hospital_count = Integer.parseInt(data[8]);
					}
				} catch (Exception e) {
					System.out.println(e);
				}

				//temp.print();
				//System.out.println();
				covid_data_points.add(temp);
				count++;
			}
		}
		csvReader.close();
		System.out.println(count);

	}

	private void get_population_data() throws IOException {

	}

	private Vector<covid_data_point> covid_data_points;

	public Vector<covid_data_point> getCovid_data_points() {
		return covid_data_points;
	}

}
