package windows;

import java.util.Arrays;
import javax.swing.*;

import Rocket.Cohete;

public class MainApp {

	public static void main(String[] args) throws Exception {

		Cohete rocket = new Cohete("LDSFJA32", Arrays.asList(50,80,30, 40, 50, 50, 30, 10));

		JFrame marco = new Marco(rocket);

		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		marco.setVisible(true);
	}

}


