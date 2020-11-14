package hackathon_2020;

import java.util.Vector;

public class data_processing {

	data_importing data;

	public data_processing(data_importing i) {
		data = i;
		get_data();
	}

	public void process_data() {
		int death = 0;
		int cases = 0;
		int hospital = 0;

		if (covid_data_points.get(1).death_count != -1) {
			death += covid_data_points.get(1).death_count;
		}
		if (covid_data_points.get(1).case_count != -1) {
			cases += covid_data_points.get(1).case_count;
		}
		if (covid_data_points.get(1).hospital_count != -1) {
			hospital += covid_data_points.get(1).hospital_count;
		}
		Vector<county_info> county_data = data.getCounty_data();

		condensed_covid_data temp_c;
		age_data temp_a;
		temp_a = new age_data();
		temp_c = new condensed_covid_data();
		temp_c.age_date_data = new Vector<age_data>();
		String l_county = covid_data_points.get(1).county;
		String l_date = covid_data_points.get(1).onset_date;
		String l_age = covid_data_points.get(1).age_range;
		temp_c.county = l_county;
		temp_a.age_range = l_age;
		temp_a.date = l_date;
		temp_a.case_count = cases;
		temp_a.death_count = death;
		temp_a.hospital_count = hospital;
		temp_c.age_date_data.add(temp_a);
		temp_c.case_count = cases;
		temp_c.death_count = death;
		temp_c.hospital_count = hospital;

		for (int i = 2; i < covid_data_points.size() - 1; i++) {
			// covid_data_points.get(i).print();

			if (covid_data_points.get(i).death_count != -1) {
				death += covid_data_points.get(i).death_count;
			}
			if (covid_data_points.get(i).case_count != -1) {
				cases += covid_data_points.get(i).case_count;
			}
			if (covid_data_points.get(i).hospital_count != -1) {
				hospital += covid_data_points.get(i).hospital_count;
			}

			int death_t = 0;
			int cases_t = 0;
			int hospital_t = 0;
			if (covid_data_points.get(i).death_count != -1) {
				death_t = covid_data_points.get(i).death_count;
			}
			if (covid_data_points.get(i).case_count != -1) {
				cases_t = covid_data_points.get(i).case_count;
			}
			if (covid_data_points.get(i).hospital_count != -1) {
				hospital_t = covid_data_points.get(i).hospital_count;
			}
			// System.out.println(covid_data_points.get(i).onset_date);
			if (l_county.equals(covid_data_points.get(i).county)) {
				temp_c.age_date_data.add(temp_a);
				temp_a = new age_data();
				temp_a.age_range = covid_data_points.get(i).age_range;
				temp_a.date = covid_data_points.get(i).onset_date;
				temp_a.case_count = cases_t;
				temp_a.death_count = death_t;
				temp_a.hospital_count = hospital_t;

				temp_c.case_count += cases_t;
				temp_c.death_count += death_t;
				temp_c.hospital_count += hospital_t;

			} else {
				temp_c.age_date_data.add(temp_a);
				condensed_covid_data_points.add(temp_c);
				temp_c = new condensed_covid_data();
				temp_a = new age_data();

				l_county = covid_data_points.get(i).county;
				l_date = covid_data_points.get(i).onset_date;
				l_age = covid_data_points.get(i).age_range;
				temp_c.county = l_county;
				temp_a.age_range = l_age;
				temp_a.date = l_date;
				temp_a.case_count = covid_data_points.get(i).case_count;
				temp_a.death_count = covid_data_points.get(i).death_count;
				temp_a.hospital_count = covid_data_points.get(i).hospital_count;
				temp_c.age_date_data.add(temp_a);
				temp_c.case_count = covid_data_points.get(i).case_count;
				temp_c.death_count = covid_data_points.get(i).death_count;
				temp_c.hospital_count = covid_data_points.get(i).hospital_count;
			}

		}
		System.out.println("death: " + death);
		System.out.println("cases: " + cases);
		System.out.println("hospital: " + hospital);
		System.out.println("county num: " + condensed_covid_data_points.size());
		System.out.println();

		int death_t = 0;
		int cases_t = 0;
		int hospital_t = 0;
		for (int i = 0; i < condensed_covid_data_points.size(); i++) {
			death_t += condensed_covid_data_points.get(i).death_count;
			cases_t += condensed_covid_data_points.get(i).case_count;
			hospital_t += condensed_covid_data_points.get(i).hospital_count;
			/*
			 * System.out.println(condensed_covid_data_points.get(i).county+" "+
			 * condensed_covid_data_points.get(i).death_count+" "+
			 * condensed_covid_data_points.get(i).case_count+" "+
			 * condensed_covid_data_points.get(i).hospital_count);
			 */
		}

		System.out.println("death: " + death_t);
		System.out.println("cases: " + cases_t);
		System.out.println("hospital: " + hospital_t);

		boolean found = false;
		for (int i = 0; i < condensed_covid_data_points.size(); i++) {
			found = false;
			for (int q = 0; q < county_data.size(); q++) {
				if (condensed_covid_data_points.get(i).county.equals(county_data.get(q).county)) {
					condensed_covid_data_points.get(i).info = county_data.get(q);
					found = true;
					break;
				}
			}
			if(!found) {
				System.out.println("could not match " + condensed_covid_data_points.get(i).county 
						+ " to county info");
			}
		}

	}

	private void get_data() {
		covid_data_points = data.getCovid_data_points();
		condensed_covid_data_points = new Vector<condensed_covid_data>();
	}

	private Vector<covid_data_point> covid_data_points;
	private Vector<condensed_covid_data> condensed_covid_data_points;

	public Vector<covid_data_point> getCovid_data_points() {
		return covid_data_points;
	}

	public Vector<condensed_covid_data> getCondensed_covid_data_points() {
		return condensed_covid_data_points;
	}

}
