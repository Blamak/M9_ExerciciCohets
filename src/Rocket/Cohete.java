package Rocket;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

import windows.CoheteHilos;
import windows.Marco;

public class Cohete {

	public static int potenciaActualCohete = 0;
	private String code;
	private List<Integer> potenciaPropulsores;
	private List<Propulsor> propulsores = new ArrayList<>();
	private Marco marco;


	protected int potenciaMaximaCohete;

	public Cohete(String code, List<Integer> potenciaPropulsores) throws Exception {
		if (code.length() != 8) {
			throw new Exception();
		}

		if (potenciaPropulsores.size() == 0) {
			throw new Exception();
		}

		this.code = code;
		this.potenciaPropulsores = potenciaPropulsores;
		
		for (Integer potencia : potenciaPropulsores) {
			this.potenciaMaximaCohete += potencia; 	
		}
		

		createPropulsores();

		this.marco = new Marco(this);

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

	// aumentar la potencia total en 10
	public void acelerar() {
		int aumento = 10;
//		while (aumento != 0) {
//			if (potenciaActualCohete >= this.potenciaMaximaCohete) {
//				System.out.println("thas pasao bacalao");
//				break;
//			}

			Runnable r = new CoheteHilos(this.propulsores, this.potenciaMaximaCohete, aumento);
			Thread t = new Thread(r);

			t.start();
//			for (Propulsor propulsor : this.propulsores) {
//				// un punto por cada propulsor
//
//				if (propulsor.getPotenciaActual() != propulsor.getPotenciaMax() && aumento > 0) {
//					propulsor.setPotenciaActual(propulsor.getPotenciaActual() + 1);
//					potenciaActualCohete++;
//					propulsor.setEstadoPropulsor(1);
//					aumento--;
////					System.out.println("yeyeye");
//
//					marco.add(panel);
//					panel.validate();
//					panel.repaint();
////						propulsor.refreshPanel();
////						this.marco.remove(panelPropulsores);
//
////						this.marco.ponerPropulsores();
////						this.laminaPropulsores = new LaminaPropulsores(propulsores);
//				}
//				try {
//					Thread.sleep(800);
//				} catch (InterruptedException ie) {
//					// do nothing
//				}
//				if (propulsor.getPotenciaActual() == propulsor.getPotenciaMax() || aumento == 10) {
//					propulsor.setEstadoPropulsor(0);
//					
//					this.marco.add(this.laminaPropulsores.panelContenedor);

//					this.marco.removeAll();
//					this.marco.ponerPropulsores(this.marco.laminaPropulsores);
//					this.marco.laminaPropulsores.validate();
//					this.marco.laminaPropulsores.repaint();
//					

//			System.out.println(potenciaActualCohete);
		}
//			c.removeAll();
//				this.laminaPropulsores = new LaminaPropulsores(panel, propulsores, this.marco);
//			this.marco.laminaPropulsores.panelContenedor.removeAll();

//	}

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

//	public String showPropulsores() {
//		String textoPotenciaPropulsores = "<html><br>";
//
//		for (int i = 1; i <= this.propulsores.size(); ++i) {
//			String nombrePropulsor = "Propulsor " + i;
//			if (this.propulsores.get(i - 1).getEstadoPropulsor() == 0) {
//				textoPotenciaPropulsores += nombrePropulsor + ": " + this.propulsores.get(i - 1).getPotenciaActual()
//						+ "<br><br>";
//			}
//
//			if (this.propulsores.get(i - 1).getEstadoPropulsor() == 1) {
//				textoPotenciaPropulsores += nombrePropulsor + ": " + this.propulsores.get(i - 1).getPotenciaActual()
//						+ "     ACELERANDO" + "<br><br>";
//			}
//
//			if (this.propulsores.get(i - 1).getEstadoPropulsor() == -1) {
//				textoPotenciaPropulsores += nombrePropulsor + ": " + this.propulsores.get(i - 1).getPotenciaActual()
//						+ "     FRENANDO" + "<br><br>";
//			}
//		}
//
//		textoPotenciaPropulsores += "</html>";
//
//		// Retorna el texto sin la última coma creada en el loop.
//		return textoPotenciaPropulsores;
//	}