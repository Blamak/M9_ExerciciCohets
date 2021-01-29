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
	public int identificador;
	private static int contador;

	public JPanel panelContenedor = new JPanel(new FlowLayout(FlowLayout.LEFT));
	public JPanel panelPropulsor = new JPanel(new FlowLayout(FlowLayout.LEFT));

	public Propulsor(int potenciaMax) {
		this.potenciaMax = potenciaMax;
		this.identificador = ++contador;

		this.panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.PAGE_AXIS));
		this.panelContenedor.setPreferredSize(new Dimension(500, 40));

		panelPropulsor.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelPropulsor.setPreferredSize(new Dimension(350, 50));
		panelPropulsor.setMaximumSize(new Dimension(350, 50));

		JLabel label = new JLabel();
		label.setBorder(BorderFactory.createTitledBorder("Propulsor " + (this.identificador)));
		label.setText(" Potencia máxima: " + Integer.toString(this.getPotenciaMax()) + "     Potencia actual: "
				+ this.getPotenciaActual() + " ");
		this.panelPropulsor.add(label);
		this.panelContenedor.add(panelPropulsor);
	}

	public void refreshPanel() {
		this.panelPropulsor.removeAll();
		JLabel label = new JLabel();
		label.setBorder(BorderFactory.createTitledBorder("Propulsor " + (this.identificador)));
		label.setText(" Potencia máxima: " + Integer.toString(this.potenciaMax) + "     Potencia actual: "
				+ this.potenciaActual + " ");
		this.panelPropulsor.add(label);
		this.panelContenedor.validate();
		this.panelContenedor.repaint();

	}

	public void aumentar() throws InterruptedException {
		Cohete.potenciaActualCohete++;
		this.potenciaActual++;
		refreshPanel();
	}

	public void disminuir() throws InterruptedException {
		Cohete.potenciaActualCohete--;
		this.potenciaActual--;

		refreshPanel();
	}

	public JPanel getPanel() {
		return this.panelContenedor;

	}

	public int getPotenciaActual() {
		return this.potenciaActual;
	}

	public int getPotenciaMax() {
		return this.potenciaMax;
	}

}
