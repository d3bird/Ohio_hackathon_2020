package hackathon_2020;

import java.util.Comparator;
import java.util.Vector;

public class condensed_covid_data {

	condensed_covid_data(){
		age_date_data = new Vector<age_data>();
	}
	
	county_info info;
	
	public String county;
	public int county_pop =-1;
	Vector<age_data> age_date_data;
	
	public int case_count = -1;
	public int death_count = -1;
	public int hospital_count = -1;
	
	public double money_for_food =-1;
	public int affected_people=-1;
	
}

class covid_case_com implements Comparator<condensed_covid_data>{
    public int compare(condensed_covid_data c1, condensed_covid_data c2) {
        return c2.case_count - c1.case_count;
    }
}

class population_com implements Comparator<condensed_covid_data>{
    public int compare(condensed_covid_data c1, condensed_covid_data c2) {
        return (c2.info.population - c1.info.population);
    }
}

class minorities_com implements Comparator<condensed_covid_data>{
    public int compare(condensed_covid_data c1, condensed_covid_data c2) {
        return (int)(c1.info.per_white - c2.info.per_white);
    }
}

class health_com implements Comparator<condensed_covid_data>{
    public int compare(condensed_covid_data c1, condensed_covid_data c2) {
    	//return Double.compare(c2.info.health_score, c1.info.health_score);
        //return (int)(c2.info.health_score - c1.info.health_score);
    	//System.out.println("as");
    	double delta= c2.info.health_score - c1.info.health_score;
        if(delta > 0) return 1;
        if(delta < 0) return -1;
        return 0;
    	
    }
}

class health_com_in implements Comparator<condensed_covid_data>{
    public int compare(condensed_covid_data c1, condensed_covid_data c2) {
    	//return Double.compare(c2.info.health_score, c1.info.health_score);
        //return (int)(c2.info.health_score - c1.info.health_score);
    	//System.out.println("as");
    	double delta= c1.info.health_score - c2.info.health_score;
        if(delta > 0) return 1;
        if(delta < 0) return -1;
        return 0;
    	
    }
}
