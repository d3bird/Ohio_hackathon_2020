package hackathon_2020;

public class main {

	public static void main(String[] args) {
		System.out.println("hello");
		data_importing data = new data_importing();
		data.import_data();
		
		data_processing proccessed_data = new data_processing(data);
		proccessed_data.process_data();
		
	}

}
