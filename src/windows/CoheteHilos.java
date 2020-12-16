package windows;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import Rocket.Cohete;
import Rocket.Propulsor;

public class CoheteHilos implements Runnable {

	private List<Propulsor> propulsores = new ArrayList<>();
//	int potenciaActualCohete;
	int aumento;
	Marco marco;
	JPanel laminaPropulsores;
	int potenciaMaximaCohete;

	public CoheteHilos(List<Propulsor> propulsores, int potenciaMaximaCohete, int aumento) {
		this.propulsores = propulsores;
//		this.potenciaActualCohete = potenciaActualCohete;
		this.aumento = aumento;
//		this.marco = marco;
//		this.laminaPropulsores = laminaPropulsores;
		this.potenciaMaximaCohete = potenciaMaximaCohete;
	}

//	public CoheteHilos(List<Propulsor> propulsores, int potenciaActualCohete, Marco marco, JPanel laminaPropulsores) {
//
//	}

	public void run() {
//		int aumento = 10;
//		while (aumento != 0) {
//			if (potenciaActualCohete >= this.potenciaMaximaCohete) {
//				System.out.println("thas pasao bacalao");
//				break;
//			}
		
		System.out.println("in run");
		for (Propulsor propulsor : this.propulsores) {
			// un punto por cada propulsor

//			this.panel = propulsor.getPanel();
			
			
			if (propulsor.getPotenciaActual() != propulsor.getPotenciaMax() && aumento > 0) {
				propulsor.setPotenciaActual(propulsor.getPotenciaActual() + 1);
				Cohete.potenciaActualCohete++;
				propulsor.setEstadoPropulsor(1);
				this.aumento--;

//				this.marco.ponerPropulsores2(this.laminaPropulsores);
//				this.laminaPropulsores.validate();
//				this.laminaPropulsores.repaint();
//				
				System.out.println("in forloop run:" + Cohete.potenciaActualCohete);
//				
				
				
				
//				propulsor.refreshPanel();
//				this.marco.remove(panelPropulsores);

//				this.marco.ponerPropulsores();
//				this.laminaPropulsores = new LaminaPropulsores(propulsores);
			}
//			if (propulsor.getPotenciaActual() == propulsor.getPotenciaMax() || aumento == 10) {
//				propulsor.setEstadoPropulsor(0);
//			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
				// do nothing
			}
		}
	}
}
//}