package view;

import java.util.List;

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

			for (int i = 0; i < 10; i++) {
				if (indicePropulsor >= this.propulsores.size() - 1) {
					indicePropulsor = 0;
				} else {
					indicePropulsor++;
				}
				propulsorHilo = this.propulsores.get(indicePropulsor); // puede que IndexOutOfBoundException si se
																		// pulsan los botones muy rapido

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
		} catch (IndexOutOfBoundsException outEx) { // atrapa erro al pulsar botones muy rapido
			indicePropulsor = 0;
			Thread.currentThread().interrupt();
		}
	}

}
