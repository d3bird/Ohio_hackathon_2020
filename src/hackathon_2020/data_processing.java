package hackathon_2020;

import java.util.Vector;

public class data_processing {

	data_importing data;
	
	public data_processing(data_importing i) {
		data =i;
		get_data();
	}
	
	public void process_data() {
		int death =0;
		int cases =0;
		int hospital =0;
		for(int i =0; i<covid_data_points.size();i++) {
			//covid_data_points.get(i).print();
			if(covid_data_points.get(i).death_count != -1) {
				death+=covid_data_points.get(i).death_count;
			}
			if(covid_data_points.get(i).case_count != -1) {
				cases+=covid_data_points.get(i).case_count;
			}
			if(covid_data_points.get(i).hospital_count != -1) {
				hospital+=covid_data_points.get(i).hospital_count;
			}
		}
		System.out.println("death: "+death);
		System.out.println("cases: "+cases);
		System.out.println("hospital: "+hospital);
	}
	
	
	private void get_data() {
		covid_data_points = data.getCovid_data_points();
	}
	
	private Vector<covid_data_point> covid_data_points;
	
}
