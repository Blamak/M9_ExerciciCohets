package Rocket;

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
	private int estadoPropulsor = 0;
	private static int contador;
	public int identificador;

	public JPanel panelContenedor = new JPanel(new FlowLayout(FlowLayout.LEFT));
	public JPanel panelPropulsor = new JPanel(new FlowLayout(FlowLayout.LEFT));

	public Propulsor(int potenciaMax) {
		this.potenciaMax = potenciaMax;
		this.identificador = ++contador;

		this.panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.PAGE_AXIS));
		this.panelContenedor.setPreferredSize(new Dimension(500, 40));

		panelPropulsor.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelPropulsor.setPreferredSize(new Dimension(350, 50));
		panelPropulsor.setMaximumSize(new Dimension(350, 50)); // set max = pref

		JLabel label = new JLabel();
		label.setBorder(BorderFactory.createTitledBorder("Propulsor " + (identificador)));
		label.setText(" Potencia máxima: " + Integer.toString(this.getPotenciaMax()) + "     Potencia actual: "
				+ this.getPotenciaActual() + " ");
		this.panelPropulsor.add(label);
		this.panelContenedor.add(panelPropulsor);
	}

	public void refrehPanel() {

		this.panelPropulsor.removeAll();
		JLabel label = new JLabel();
		label.setBorder(BorderFactory.createTitledBorder("Propulsor " + (identificador)));
		label.setText(" Potencia máxima: " + Integer.toString(this.potenciaMax) + "     Potencia actual: "
				+ this.potenciaActual + " ");
		this.panelPropulsor.add(label);
		this.panelContenedor.validate();
		this.panelContenedor.repaint();

	}
	
	public void aumentar() {
		
		
			this.potenciaActual++;
			Cohete.potenciaActualCohete++;
			refrehPanel();
	}
	
	public void disminuir() {
		this.potenciaActual--;
		Cohete.potenciaActualCohete--;
		refrehPanel();
	}

	public JPanel getPanel() {
		return this.panelContenedor;

	}

	public int getPotenciaActual() {
		return this.potenciaActual;
	}

	public void setPotenciaActual(int potenciaActual) {
		this.potenciaActual = potenciaActual;
	}

	public int getPotenciaMax() {
		return this.potenciaMax;
	}

	public void setPotenciaMax(int potenciaMax) {
		this.potenciaMax = potenciaMax;
	}

	public int getEstadoPropulsor() {
		return this.estadoPropulsor;
	}

	public void setEstadoPropulsor(int estadoPropulsor) {
		this.estadoPropulsor = estadoPropulsor;
	}

}
