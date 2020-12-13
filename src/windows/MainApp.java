package windows;

import java.util.Arrays;
import javax.swing.*;

import Rocket.Cohete;

public class MainApp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws Exception {

		Cohete rocket = new Cohete("LDSFJA32", Arrays.asList(50,80,30, 40, 50, 50));
//		Cohete rocket = new Cohete("LDSFJA32", Arrays.asList(50));

		
	}

}


