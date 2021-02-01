package com.rocket.domain;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Propulsor extends Thread {

	private int potenciaMax;
	private int potenciaActual;
	private int identificador;
	private static int contador;

	public JPanel panelContenedor = new JPanel(new FlowLayout(FlowLayout.LEFT));
	public JPanel panelPropulsor = new JPanel(new FlowLayout(FlowLayout.LEFT));

	public Propulsor(int potenciaMax) {
		this.potenciaMax = potenciaMax;
		this.identificador = ++contador;
		init();
	}
	
	private void init() { 
		this.panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.PAGE_AXIS));
		this.panelContenedor.setPreferredSize(new Dimension(500, 40));
		this.panelPropulsor.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.panelPropulsor.setPreferredSize(new Dimension(350, 50));
		this.panelPropulsor.setMaximumSize(new Dimension(350, 50));
		
		createPanelPropulsor(this.panelContenedor);
		this.panelContenedor.add(this.panelPropulsor);
	}
	
	private void createPanelPropulsor(JPanel panelContainer) {
		JLabel label = new JLabel();
		label.setBorder(BorderFactory.createTitledBorder("Propulsor " + (this.identificador)));
		label.setText(" Potencia máxima: " + Integer.toString(this.potenciaMax) + "     Potencia actual: "
				+ this.potenciaActual + " ");
		this.panelPropulsor.add(label);
	}

	private void refreshPanel() {
		this.panelPropulsor.removeAll();
		createPanelPropulsor(this.panelContenedor);
		this.panelContenedor.validate();
		this.panelContenedor.repaint();

	}

	public void aumentar() throws InterruptedException {
		if ( !(this.potenciaActual >= this.potenciaMax) ) {
			this.potenciaActual++;
			refreshPanel();
		}
	}

	public void disminuir() throws InterruptedException {
		if ( !(this.potenciaActual <= 0) ) {
			this.potenciaActual--;
			refreshPanel();
		}
	}

	public JPanel getPanel() {
		return this.panelContenedor;

	}
}
