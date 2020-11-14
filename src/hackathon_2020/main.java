package hackathon_2020;

import java.io.IOException;

public class main {

	public static void main(String[] args) {
		System.out.println("hello");
		data_importing data;
		try {
			data = new data_importing();
			data_processing proccessed_data = new data_processing(data);
			proccessed_data.process_data();
			 java.awt.EventQueue.invokeLater(new Runnable() {
		            public void run() {
		                new GUI(proccessed_data).setVisible(true);
		            }
		        });
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("there was a problem opening a file");
			e.printStackTrace();
		}
	
	}
}
