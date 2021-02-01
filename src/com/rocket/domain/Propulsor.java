package com.rocket.domain;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Clase para la creación de propulsores
 * 
 * Consta de: 
 *   - potencia máxima y actual, numéricos
 *   - contador para llevar la cuenta del número de propulsores creados, 
 *     atributo de clase de tipo numérico
 *   - número indentificador del propulsor 
 *   - dos atributos de tipo JPanel, una lámina que muestra el propulsor, con sus potencias 
 *     máxima y actual, y otro para alojarla y poder incrustarla dentro del panel
 *     que contiene todos los propulsores (clase Marco, laminaPropulsores) 
 *
 */
public class Propulsor extends Thread {

	private int potenciaMax;
	private int potenciaActual;
	private int identificador;
	private static int contador;

	public JPanel panelContenedor = new JPanel(new FlowLayout(FlowLayout.LEFT));
	public JPanel panelPropulsor = new JPanel(new FlowLayout(FlowLayout.LEFT));

	/**
	 * Constructor, establece la potencia máxima del propulsor, su identificador,
	 * y actualiza el contador de propulsores
	 * 
	 * Ejecuta el método init() para la construcción de las láminas para la vista
	 * 
	 * @param potenciaMax, potencia que el propulsor no puede rebasar
	 */
	public Propulsor(int potenciaMax) {
		this.potenciaMax = potenciaMax;
		this.identificador = ++contador;
		init();
	}
	
	/**
	 * Mediante los atributos de la clase construye la jerarquía de láminas que 
	 * formarán la vista del propulsor
	 *
	 */
	private void init() { 
		this.panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.PAGE_AXIS));
		this.panelContenedor.setPreferredSize(new Dimension(500, 40));
		this.panelPropulsor.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.panelPropulsor.setPreferredSize(new Dimension(350, 50));
		this.panelPropulsor.setMaximumSize(new Dimension(350, 50));
		
		createPanelPropulsor(this.panelContenedor);
		this.panelContenedor.add(this.panelPropulsor);
	}
	
	/**
	 * Elimina y vuelve a construir la lámina del propulsor tras modificarse su potencia actual
	 * 
	 */
	private void refreshPanel() {
		this.panelPropulsor.removeAll();
		createPanelPropulsor(this.panelContenedor);
		this.panelContenedor.validate();
		this.panelContenedor.repaint();
	}
	
	/**
	 * Método para evitar duplicidad de código en los métodos init() y refreshPanel()
	 * 
	 * @param panelContainer, contenedor al que insertar la etiqueta con el identificador
	 * del propulsor y sus potencias actual y máxima
	 */
	private void createPanelPropulsor(JPanel panelContainer) {
		JLabel label = new JLabel();
		label.setBorder(BorderFactory.createTitledBorder("Propulsor " + (this.identificador)));
		label.setText(" Potencia máxima: " + Integer.toString(this.potenciaMax) + "     Potencia actual: "
				+ this.potenciaActual + " ");
		this.panelPropulsor.add(label);
	}


	/**
	 * Incrementa en una unidad la potencia actual del propulsor y reconstruye el panel
	 * 
	 * @throws InterruptedException, en CoheteHilos - método run()
	 */
	public void aumentar() throws InterruptedException {
		if ( !(this.potenciaActual >= this.potenciaMax) ) {
			this.potenciaActual++;
			refreshPanel();
		}
	}

	/**
	 * Reduce en una unidad la potencia actual del propulsor y reconstruye el panel
	 * 
	 * @throws InterruptedException, en CoheteHilos, método run()
	 */
	public void disminuir() throws InterruptedException {
		if ( !(this.potenciaActual <= 0) ) {
			this.potenciaActual--;
			refreshPanel();
		}
	}

	/**
	 * @return la lámina completa preparada para ser insertada en otro panel
	 */
	public JPanel getPanel() {
		return this.panelContenedor;

	}
}
