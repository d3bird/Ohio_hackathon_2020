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
		county_data = new  Vector<county_info>();
		get_covid_data();
		get_population_data();
		get_demegraphic_data();
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
			/*
			 * System.out.println(row); // System.out.println(data.toString());
			 * 
			 * for (int i = 0; i < data.length; i++) { if (data[i].equals("")) {
			 * System.out.print("- "); } else { System.out.print(data[i] + " "); } }
			 * System.out.println(data.length + " :length");
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
				//System.out.println(data[3]);
				if (data[3].equals("")) {
					temp.onset_date = "-1";
				} else {
					temp.onset_date = data[3];
				}
				if (data[4].equals("")) {
					temp.death_date = "-1";
				} else {
					temp.death_date = data[4];
				}
				if (data[5].equals("")) {
					temp.admin_date = "-1";
				} else {
					temp.admin_date = data[5];
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

				// temp.print();
				// System.out.println();
				covid_data_points.add(temp);
				count++;
			}
		}
		csvReader.close();
		System.out.println(count);

	}

	private void get_population_data() throws IOException {

		BufferedReader csvReader = new BufferedReader(new FileReader(
				"C:\\Users\\dogbi\\eclipse-workspace\\hackathon_2020\\src\\hackathon_2020\\co-est2019-annres.csv"));
		String row;
		int count = 0;
		county_info temp;
		boolean first = true;
		while ((row = csvReader.readLine()) != null) {
			if (first && count < 5) {
				count++;
			} else {
				if (first) {
					first = false;
					count = 0;
				} else {
					count++;
				}
				String[] data = row.split(",");
				//System.out.println(row);
				//System.out.println(data.length);
				temp = new county_info();
				String[] t_name =data[0].split(" "); 
				String name ="";
				boolean first_part = true;
				for(int q =0; q <t_name.length;q++) {
					if(t_name[q].equals("County")) {
						break;
					}else {
						if(first_part) {
						name+=t_name[q];
						first_part =false;
						}else {
							name+=(" "+t_name[q]);
						}
					}
				}
				temp.county = name;
				
				if (data[12].equals("")) {
					temp.population = -1;
				} else {
					temp.population = Integer.parseInt(data[12]);
				}
				//System.out.println(temp.county+" "+temp.population);
				county_data.add(temp);
				if(count >= 87) {
					break;
				}
			}
			// String[] data = row.split(",");
			// System.out.println(row);
			// System.out.println(data.length);
		}
	}

	private void get_demegraphic_data() throws IOException {

		BufferedReader csvReader = new BufferedReader(new FileReader(
				"C:\\Users\\dogbi\\eclipse-workspace\\hackathon_2020\\src\\hackathon_2020\\Health_Opportunity_Index_County.csv"));
		String row;
		int count = 0;
		county_info temp;
		boolean first = true;
		boolean found = false;
		while ((row = csvReader.readLine()) != null) {
			if (first) {
				first = false;
			} else {
				String[] data = row.split(",");
				//System.out.println(row);
				
				for(int i =0; i<county_data.size();i++) {
					if(county_data.get(i).county.equals(data[0])) {
						found = true;
						county_data.get(i).per_white = Double.parseDouble(data[1]);
						county_data.get(i).health_score = Double.parseDouble(data[2]);
						break;
					}
				}
					if(found) {
						found = false;
					}else {
						System.out.println("could not match "+data[0]);
					}
				
			}

		}
	}

	
	
	private Vector<covid_data_point> covid_data_points;
	private Vector<county_info> county_data;

	public Vector<county_info> getCounty_data() {
		return county_data;
	}

	public Vector<covid_data_point> getCovid_data_points() {
		return covid_data_points;
	}

}
