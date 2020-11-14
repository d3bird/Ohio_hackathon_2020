package hackathon_2020;

import java.util.Vector;

public class condensed_covid_data {

	condensed_covid_data(){
		age_date_data = new Vector<age_data>();
	}
	
	public String county;
	Vector<age_data> age_date_data;
	
	public int case_count = -1;
	public int death_count = -1;
	public int hospital_count = -1;
}
