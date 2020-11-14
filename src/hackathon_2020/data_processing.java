package hackathon_2020;

import java.util.Vector;

public class data_processing {

	data_importing data;
	
	public data_processing(data_importing i) {
		data =i;
		get_data();
	}
	
	public void process_data() {
		
		
	}
	
	
	private void get_data() {
		county = data.getCounty();
		gender = data.getGender();
		age_range = data.getAge_range();
		onset_date = data.getDate();
		death_date = data.getDeath_date();
		admin_date = data.getAdmin_date();
		case_count = data.getCase_count();
		death_count = data.getDeath_count();
		hospital_count = data.getHospital_count();
	}
	
	private Vector<Integer> county;
	private Vector<Integer> gender;
	private Vector<Integer> age_range;
	private Vector<String> onset_date;
	private Vector<String> death_date;
	private Vector<String> admin_date;
	private Vector<Integer> case_count;
	private Vector<Integer> death_count;
	private Vector<Integer> hospital_count;
	
}
