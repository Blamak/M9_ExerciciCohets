package windows;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.*;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Rocket.Cohete;
import Rocket.Propulsor;

import Rocket.Cohete;

public class MainApp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws Exception {

		Cohete rocket = new Cohete("LDSFJA32", Arrays.asList(50,80,30, 40, 50, 50));
//		Cohete rocket = new Cohete("LDSFJA32", Arrays.asList(50));
		
		
		
		
//		rocket.rocketWindow();
		
//		Marco marco = new Marco(rocket);

		
//		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		marco.setVisible(true);
		
	}

}








/*

setBounds(400, 300, 500, 400);
setPreferredSize(new Dimension(600, 450));
pack();
setTitle("Código Cohete: " + this.getCode());
setLayout(new BorderLayout());
//this.panelPropulsores.setLayout(new BoxLayout(panelPropulsores, BoxLayout.PAGE_AXIS));



//this.laminaPropulsores = new LaminaPropulsores(propulsores);

//this.marco = new Marco(this);
//this.marco.add(panelPropulsores);


for (int i = 0; i < propulsores.size(); i++) {
//	c.remove(i);
//	System.out.println(c.getComponentCount());
//add(this.laminaPropulsores.panelContenedor, BorderLayout.NORTH);
//
//System.out.println(propulsor.getPotenciaActual());

	JPanel panel = propulsores.get(i).getPanel();
	panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
//	c.validate();
//	c.repaint();
//	
	this.panelPropulsores.add(panel);
}


panelPropulsores.setLayout(new BoxLayout(panelPropulsores, BoxLayout.PAGE_AXIS));
add(panelPropulsores);

panelPropulsores.removeAll();

//   BOTONNNN  ---------------------------------


JPanel laminaBotones = new JPanel();
laminaBotones.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

ponerBoton(laminaBotones, "Acelera", new ActionListener() {

	public void actionPerformed(ActionEvent evento) {
		try {
			acelerar();
//			panelPropulsores.removeAll();
//			actualizaPanelPropulsor(laminaPropulsores);
//			ponerPropulsores(laminaPropulsores);
//			laminaPropulsores.validate();
//			laminaPropulsores.repaint();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
});

ponerBoton(laminaBotones, "  Frena  ", new ActionListener() {

	public void actionPerformed(ActionEvent evento) {
		try {
			frenar();
//			actualizaPanelPropulsor(laminaPropulsores);
//			laminaPropulsores.removeAll();
//			ponerPropulsores(laminaPropulsores);
//			laminaPropulsores.validate();
//			laminaPropulsores.repaint();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
});

add(laminaBotones, BorderLayout.SOUTH);


//   BOTONNNN  ---------------------------------




}









//
//LaminaPropulsores laminaProp = new LaminaPropulsores(propulsores);
//
//
//this.laminaPropulsores.setLayout(new BoxLayout(laminaPropulsores, BoxLayout.PAGE_AXIS));
//
//this.marco.add();

//marco.setLayout(new BorderLayout());



public void ponerBoton(Container c, String titulo, ActionListener oyente) {

JButton boton = new JButton(titulo);

c.add(boton);

boton.addActionListener(oyente);

}

*/