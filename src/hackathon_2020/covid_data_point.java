package hackathon_2020;

public class covid_data_point {

	public String county = "-1";
	public String gender = "-1";
	public String age_range = "-1";
	public String onset_date = "-1";
	public String death_date = "-1";
	public String admin_date = "-1";
	public int case_count = -1;
	public int death_count = -1;
	public int hospital_count = -1;

	public covid_data_point() {

	}

	public void print() {
		System.out.println("county: " + county + " gender: " + gender + " age_range: " + age_range + " onset_date: "
				+ onset_date + " death_date: " + death_date + " admin_date: " + admin_date + " case_count: "
				+ case_count + " death_count: " + death_count + " hospital_count: " + hospital_count);

	}
}
