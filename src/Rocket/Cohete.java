package Rocket;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import windows.LaminaPropulsores;
import windows.Marco;

public class Cohete extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int potenciaActualCohete = 0;
	private String code;
	private List<Integer> potenciaPropulsores;
	private List<Propulsor> propulsores = new ArrayList<>();
	private Marco marco;
	private JPanel panelPropulsores = new JPanel();

	protected int potenciaMaximaCohete;
//	private HashMap<Propulsor, Integer> mapaPropulsorPotencia = new HashMap<>();

	public Cohete(String code, List<Integer> potenciaPropulsores) throws Exception {
		if (code.length() != 8) {
			throw new Exception();
		}

		if (potenciaPropulsores.size() == 0) {
			throw new Exception();
		}
		
		this.code = code;
		this.potenciaPropulsores = potenciaPropulsores;

		createPropulsores();
		
		setBounds(400, 300, 500, 400);
		setPreferredSize(new Dimension(600, 450));
		pack();
		setTitle("Código Cohete: " + this.getCode());
		setLayout(new BorderLayout());
		
		
		LaminaPropulsores laminaPropulsores = new LaminaPropulsores(propulsores);
		
		this.panelPropulsores = laminaPropulsores.panelContenedor;
		
		add(panelPropulsores);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		
//		this.marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.marco.setVisible(true);
		
	
//		this.marco = new Marco(this);
//		
//		LaminaPropulsores laminaProp = new LaminaPropulsores(propulsores);
//		
//		this.laminaPropulsores = laminaProp.panelContenedor;
//		
//		this.laminaPropulsores.setLayout(new BoxLayout(laminaPropulsores, BoxLayout.PAGE_AXIS));
//		
//		this.marco.add();
		
		
		
		
		
//		marco.setLayout(new BorderLayout());
	}

	public String getCode() {
		return this.code;
	}

	public void createPropulsores() {
		for (Integer potencia : this.potenciaPropulsores) {
			this.potenciaMaximaCohete += potencia;
			Propulsor newPropulsor = new Propulsor(potencia);
			this.propulsores.add(newPropulsor);
		}
		
		
	}
	
	public List<Propulsor> getPropulsores() {
		return this.propulsores;
	}

	public String showPropulsores() {
		String textoPotenciaPropulsores = "<html><br>";
		
		for (int i = 1; i <= this.propulsores.size(); ++i) {
			String nombrePropulsor = "Propulsor " + i;
			if (this.propulsores.get(i - 1).getEstadoPropulsor() == 0) {
				textoPotenciaPropulsores += nombrePropulsor + ": " + this.propulsores.get(i - 1).getPotenciaActual()
						+ "<br><br>";				
			}
			
			if (this.propulsores.get(i - 1).getEstadoPropulsor() == 1) {
				textoPotenciaPropulsores += nombrePropulsor + ": " + this.propulsores.get(i - 1).getPotenciaActual()
						+  "     ACELERANDO" + "<br><br>";					
			}

			if (this.propulsores.get(i - 1).getEstadoPropulsor() == -1) {
				textoPotenciaPropulsores += nombrePropulsor + ": " + this.propulsores.get(i - 1).getPotenciaActual()
						+  "     FRENANDO" + "<br><br>";					
			}
		}

		textoPotenciaPropulsores += "</html>";

		// Retorna el texto sin la última coma creada en el loop.
		return textoPotenciaPropulsores;
	}
	
	
	

	// aumentar la potencia total en 10
	public void acelerar() {
		int aumento = 10;
		while (aumento != 0) {
			if (potenciaActualCohete >= this.potenciaMaximaCohete) {
				System.out.println("thas pasao bacalao");
				break;
			}
			for (Propulsor propulsor : this.propulsores) {
				// un punto por cada propulsor
				if (propulsor.getPotenciaActual() != propulsor.getPotenciaMax() && aumento > 0) {
					propulsor.setPotenciaActual(propulsor.getPotenciaActual() + 1);
					potenciaActualCohete++;
					propulsor.setEstadoPropulsor(1);
					aumento--;
					
					
//					this.marco.laminaPropulsores.removeAll();
//					this.marco.ponerPropulsores(this.marco.laminaPropulsores);
//					this.marco.laminaPropulsores.validate();
//					this.marco.laminaPropulsores.repaint();
//					
				} 
				if (propulsor.getPotenciaActual() == propulsor.getPotenciaMax() || aumento == 10) {
					propulsor.setEstadoPropulsor(0);
				}
				
					
			}
			System.out.println(potenciaActualCohete);

		}
	}

	public void frenar() {

		int decremento = 10;
		while (decremento != 0) {
			if (potenciaActualCohete <= 0) {
				System.out.println("thas colao bacalao");
				break;
			}
			for (Propulsor propulsor : this.propulsores) {
				// un punto por cada propulsor
				if (propulsor.getPotenciaActual() != 0 && decremento > 0) {
					propulsor.setPotenciaActual(propulsor.getPotenciaActual() - 1);
					potenciaActualCohete--;
					propulsor.setEstadoPropulsor(-1);
					decremento--;
					
//					this.marco.laminaPropulsores.removeAll();
//					this.marco.ponerPropulsores(this.marco.laminaPropulsores);
//					this.marco.laminaPropulsores.validate();
//					this.marco.laminaPropulsores.repaint();
				} 
				if (propulsor.getPotenciaActual() == 0 || decremento == 10) {
					propulsor.setEstadoPropulsor(0);
				}
				
			}
			System.out.println(potenciaActualCohete);
			
		}
	}

}
