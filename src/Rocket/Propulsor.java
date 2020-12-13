package Rocket;

import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Propulsor {
	
	private int potenciaMax;
	
	private int potenciaActual;
	private int estadoPropulsor = 0;
	private static int contador;
	private int identificador;
	
	private JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	
	
	
	public Propulsor(int potenciaMax) {
		this.potenciaMax = potenciaMax;
		this.identificador = ++contador;
		
		this.panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		JLabel label = new JLabel();
		
		label.setBorder(BorderFactory.createTitledBorder("Propulsor " + (identificador)));
		label.setText("Potencia máxima: " + Integer.toString(this.getPotenciaMax()) + "  Potencia actual: " + this.getPotenciaActual());
//		System.out.println(identificador + " " + this.getPotenciaActual());
		this.panel.add(label);
	}
	
	
	public JPanel getPanel() {
		return this.panel;
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
