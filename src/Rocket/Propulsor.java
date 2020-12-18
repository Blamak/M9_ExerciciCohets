package Rocket;

import java.awt.Component;
import java.awt.Dimension;
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
	public int identificador;
	
	public JPanel panelContenedor = new JPanel(new FlowLayout(FlowLayout.LEFT));
	public JPanel panelPropulsor= new JPanel(new FlowLayout(FlowLayout.LEFT));
	
	
	
	public Propulsor(int potenciaMax) {
		this.potenciaMax = potenciaMax;
		this.identificador = ++contador;
		
		this.panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.PAGE_AXIS));
		this.panelContenedor.setPreferredSize(new Dimension(500, 40));
//		this.panelPropulsor.setLayout(new BoxLayout(panelPropulsor, BoxLayout.X_AXIS));
		
		
		panelPropulsor.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPropulsor.setPreferredSize(new Dimension(350, 50));
        panelPropulsor.setMaximumSize(new Dimension(350, 50)); // set max = pref
//		this.panelPropulsor.setPreferredSize(new Dimension(600, 30));
		
//		this.panelPropulsor.setSize(new Dimension(600, 500));
//		this.panelContenedor.setSize(new Dimension(1200, 800));
		JLabel label = new JLabel();
//		label.setPreferredSize(new Dimension(600,30));
		
		label.setBorder(BorderFactory.createTitledBorder("Propulsor " + (identificador)));
		label.setText(" Potencia m�xima: " + Integer.toString(this.getPotenciaMax()) + "     Potencia actual: " + this.getPotenciaActual() + " ");
//		System.out.println(identificador + " " + this.getPotenciaActual());
		this.panelPropulsor.add(label);
		this.panelContenedor.add(panelPropulsor);
	}
	
	public void refrehPanel() {
			
			
//		this.panelPropulsor.setLayout(new BoxLayout(panelPropulsor, BoxLayout.PAGE_AXIS));
			this.panelPropulsor.removeAll();
			JLabel label = new JLabel();
			label.setBorder(BorderFactory.createTitledBorder("Propulsor " + (identificador)));
			label.setText(" Potencia m�xima: " + Integer.toString(this.getPotenciaMax()) + "     Potencia actual: " + this.getPotenciaActual() + " ");
			this.panelPropulsor.add(label);
			this.panelContenedor.validate();
//		this.panelPropulsor.setPreferredSize(new Dimension(1200, 800));
//		label.setPreferredSize(new Dimension(1200,800));
//		
//		System.out.println(identificador + " " + this.getPotenciaActual());
		this.panelContenedor.repaint();
//		this.panelContenedor.add(panelPropulsor);
		
//		
//		this.panelContenedor.add(panelPropulsor);
//		this.panelPropulsor.setLayout(new BoxLayout(panelPropulsor, BoxLayout.PAGE_AXIS));
//		JLabel label = new JLabel();
//		
//		label.setBorder(BorderFactory.createTitledBorder("Propulsor " + (identificador)));
//		label.setText("Potencia m�xima: " + Integer.toString(this.getPotenciaMax()) + "  Potencia actual: " + this.getPotenciaActual());
////		System.out.println(identificador + " " + this.getPotenciaActual());
//		this.panelPropulsor.add(label);
//		this.panelContenedor.add(panelPropulsor);
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
