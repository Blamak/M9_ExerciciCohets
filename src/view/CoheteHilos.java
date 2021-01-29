package view;

import java.util.List;

import com.rocket.domain.Cohete;
import com.rocket.domain.Propulsor;

public class CoheteHilos extends Thread {
	
	private List<Propulsor> propulsores;
	private int acelera_o_frena; // 1 acelera, -1 frena
	private static int indicePropulsor = 0;

	public CoheteHilos(List<Propulsor> propulsores, int numPropulsores, int acelera_o_frena) {
		this.propulsores = propulsores;
		this.acelera_o_frena = acelera_o_frena;
		
	}

	public void run() {

	
		try {

			Propulsor propulsorHilo;
			int propulsorPotenciaActual;
			int propulsorPotenciaMaxima;

			for (int i = 0; i < 10; i++) {

				if (this.acelera_o_frena == -1 && Cohete.potenciaActualCohete <= 0) {
					Cohete.potenciaActualCohete = 0;
					Thread.currentThread().interrupt();
					break;
				}
				if (this.acelera_o_frena == 1 && Cohete.potenciaActualCohete == Cohete.potenciaMaximaCohete) {
					Cohete.potenciaActualCohete = Cohete.potenciaMaximaCohete;
					Thread.currentThread().interrupt();
					break;
				}
				
				
				propulsorHilo = this.propulsores.get(indicePropulsor);
				
				if (indicePropulsor >= this.propulsores.size() -1) {
					indicePropulsor = 0;
					
				} else {
					indicePropulsor++;
				}
				
				propulsorPotenciaActual = propulsorHilo.getPotenciaActual();
				propulsorPotenciaMaxima = propulsorHilo.getPotenciaMax();

				if (propulsorPotenciaActual >= propulsorPotenciaMaxima && this.acelera_o_frena == 1) {
					i--;
					continue;
				}

				if (propulsorPotenciaActual <= 0 && this.acelera_o_frena == -1) {
					i--;
					continue;
				}

				switch (this.acelera_o_frena) {
				case 1:
					propulsorHilo.aumentar();
					break;
				case -1:
					propulsorHilo.disminuir();
					break;
				}
				
				Thread.sleep(200);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IndexOutOfBoundsException outEx) {
			indicePropulsor = 0;
			Thread.currentThread().interrupt();
		}
	}
	

}
