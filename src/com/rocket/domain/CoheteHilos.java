package com.rocket.domain;

import java.util.List;

/**
 * Clase que hereda de la Thread y sobreescribe su m�todo run()
 * para la creaci�n de cada hilo de ejecuci�n al pulsar los botones
 * de acelerar o frenar
 * 
 * Contiene una lista con todos los propulsores del cohete,
 * un atributo de tipo Integer para saber si se est� acelerando o frenando,
 * 
 * y otro atributo num�rico que indica el �ndice, dentro de la lista de propulsores,
 * del propulsor sobre el que aplicar uno de los dos metodos que modifican su potencia
 * actual en una unidad, aumentar() o disminuir(),
 *
 */
public class CoheteHilos extends Thread {

	private List<Propulsor> propulsores;
	private int acelera_o_frena; // 1 acelera, -1 frena
	private int indicePropulsor = -1;

	/**
	 * Constructor
	 * 
	 * @param propulsores, todos los propulsores del cohete
	 * @param numPropulsores, cantidad de propulsores que tiene el cohete
	 * @param acelera_o_frena, valor 1 para acelerar, -1 para frenar
	 */
	public CoheteHilos(List<Propulsor> propulsores, int numPropulsores, int acelera_o_frena) {
		this.propulsores = propulsores;
		this.acelera_o_frena = acelera_o_frena;
	}

	/**
	 * Anulaci�n de m�todo de la clase Thread
	 * 
	 * Declara un propulsor antes de iniciar un bucle for de diez iteraciones;
	 * para cada interaci�n se instancia un propulsor, seg�n el �ndice en la lista
	 * de propulsores
	 * 
	 * El atributo acelera_o_frena, proporcionado por el constructor, 
	 * define si el propulsor aumenta (=1) o disminuye (=-1) en una unidad
	 * su potencia actual
	 *
	 */
	public void run() {
		try {
			Propulsor propulsorHilo;

			for (int i = 0; i < 10; i++) {
				// Si �ltimo �ndice de la lista de propulsores, volver al primero
				if ( indicePropulsor >= this.propulsores.size() - 1) {
					indicePropulsor = 0;
				} else {
					indicePropulsor++;
				}
				
				propulsorHilo = this.propulsores.get(indicePropulsor); /* Puede provocar una IndexOutOfBoundException,
																	   *  que se captura en uno de los catch */
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
