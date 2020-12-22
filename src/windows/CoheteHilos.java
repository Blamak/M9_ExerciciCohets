package windows;

import java.util.List;

import Rocket.Cohete;
import Rocket.Propulsor;

public class CoheteHilos extends Thread {

	List<Propulsor> propulsores;
	int numPropulsores;
	int suma_o_resta;

	public CoheteHilos(List<Propulsor> propulsores, int numPropulsores, int suma_o_resta) {
		this.propulsores = propulsores;
		this.numPropulsores = numPropulsores;
		this.suma_o_resta = suma_o_resta;

	}

	public void run() {

		try {

			Propulsor propulsorHilo;
			int indicePropulsor;
			int propulsorPotenciaActual = 0;
			int propulsorPotenciaMaxima;

			for (int i = 0; i < 10; i++) {
				
				if ( (Cohete.potenciaActualCohete == 0 && this.suma_o_resta == -1) || Cohete.potenciaActualCohete == Cohete.potenciaMaximaCohete) {
					break;
				}

				indicePropulsor = (int) ((numPropulsores) * Math.random());
				propulsorHilo = this.propulsores.get(indicePropulsor);
				propulsorPotenciaActual = propulsorHilo.getPotenciaActual();
				propulsorPotenciaMaxima = propulsorHilo.getPotenciaMax();

				switch (this.suma_o_resta) {
				case 1:
					if (propulsorPotenciaActual == propulsorPotenciaMaxima) {
						i--;
						break;
					} else {
						propulsorHilo.aumentar();
						break;
					}
				case -1:
					if (propulsorPotenciaActual == 0) {
						i--;
						break;
					} else {
						propulsorHilo.disminuir();
						break;
					}
				}

				Thread.sleep(100);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
