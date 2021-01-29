package view;

import java.util.Arrays;
import javax.swing.JFrame;

import com.rocket.domain.Cohete;

public class MainApp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {

		Cohete rocket = new Cohete("LDSFJA32", Arrays.asList(10, 5, 15, 20, 10));
		
		Marco marco = Marco.getInstance(rocket);

	}

}

