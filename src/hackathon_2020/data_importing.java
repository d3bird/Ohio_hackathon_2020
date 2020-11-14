package hackathon_2020;

import java.util.Vector;

public class data_importing {

	public data_importing() {
		
	
	}
  
	public void import_data() {
		
	}
	
	
	private Vector<Integer> county;
	private Vector<Integer> gender;
	private Vector<Integer> age_range;
	private Vector<String> date;
	private Vector<String> onset_date;
	private Vector<String> death_date;
	private Vector<String> admin_date;
	private Vector<Integer> case_count;
	private Vector<Integer> death_count;
	private Vector<Integer> hospital_count;
	
	public Vector<Integer> getCounty() {
		return county;
	}
	public Vector<Integer> getGender() {
		return gender;
	}
	public Vector<Integer> getAge_range() {
		return age_range;
	}
	public Vector<String> getDate() {
		return date;
	}
	public Vector<String> getOnset_date() {
		return onset_date;
	}
	public Vector<String> getDeath_date() {
		return death_date;
	}
	public Vector<String> getAdmin_date() {
		return admin_date;
	}
	public Vector<Integer> getCase_count() {
		return case_count;
	}
	public Vector<Integer> getDeath_count() {
		return death_count;
	}
	public Vector<Integer> getHospital_count() {
		return hospital_count;
	}
	
}
