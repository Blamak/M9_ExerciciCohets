package windows;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
//El programa
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;

import javax.swing.*;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame marco = new MarcoRebote();

		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		marco.setVisible(true);
	}

}

//Marco con lamina y botones

class MarcoRebote extends JFrame {

	public MarcoRebote() {

		setBounds(600, 300, 400, 350);

		setTitle("Rocket1");
		
		ponerPropulsores();
		
		ponerCohete();

		JPanel laminaBotones = new JPanel();

		ponerBoton(laminaBotones, "Acelera", new ActionListener() {

			public void actionPerformed(ActionEvent evento) {

			}
		});

		ponerBoton(laminaBotones, "Frena", new ActionListener() {

			public void actionPerformed(ActionEvent evento) {

				System.exit(0);
			}
		});
		add(laminaBotones, BorderLayout.SOUTH);

	}
	
// ponemos texto de los propulsores
	public void ponerPropulsores() {
		JLabel prop1 = new JLabel();
		prop1.setText("Propulsor 1: ACELERANDO");
		add(prop1, BorderLayout.NORTH);
	}

// ponemos texto del cohete

	public void ponerCohete() {
		JLabel label1 = new JLabel();
		label1.setText("   ===>");
//		label1.setBounds(0, 0, 0, 0);
		add(label1, BorderLayout.CENTER);
	}

//ponemos botones

	public void ponerBoton(Container c, String titulo, ActionListener oyente) {

		JButton boton = new JButton(titulo);

		c.add(boton);

		boton.addActionListener(oyente);

	}

}
