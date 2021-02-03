package com.rocket.domain;

import java.util.List;

/**
 * Clase que hereda de la superclase Thread y sobreescribe su método run()
 * para la creación de cada hilo de ejecución al pulsar los botones
 * de acelerar o frenar
 * 
 * Contiene una lista con todos los propulsores del cohete,
 * y un atributo de tipo Integer para saber si se está acelerando o frenando,
 *
 */
public class CoheteHilos extends Thread {

	private List<Propulsor> propulsores;
	private int acelera_o_frena;

	/**
	 * Constructor
	 * 
	 * @param propulsores,     todos los propulsores del cohete
	 * @param acelera_o_frena, valor 1 para acelerar, -1 para frenar
	 */
	public CoheteHilos(List<Propulsor> propulsores, int acelera_o_frena) {
		this.propulsores = propulsores;
		this.acelera_o_frena = acelera_o_frena;
	}

	/**
	 * Anulación de método de la clase Thread
	 * 
	 * Declara un propulsor antes de iniciar un bucle for de diez iteraciones;
	 * para cada interación se instancia un propulsor, según su índice en la lista
	 * de propulsores establecido por la variable indicePropulsor
	 * 
	 * El atributo acelera_o_frena, proporcionado por el constructor, 
	 * define si el propulsor aumenta (=1) o disminuye (=-1) en una unidad
	 * su potencia actual
	 *
	 */
	public void run() {
		Propulsor propulsorHilo;
		int indicePropulsor = -1; // Cubre la posibilidad de un solo propulsor
		
		try {

			for (int i = 0; i < 10; i++) {
				if ( indicePropulsor >= this.propulsores.size() - 1) {
					// Si el propulsor de la iteración anterior era el último de la lista, volver al primero
					indicePropulsor = 0;
				} else {
					indicePropulsor++;
				}
				
				propulsorHilo = this.propulsores.get(indicePropulsor); /* Puede provocar una IndexOutOfBoundException,
																	   *  que se captura en uno de los catch e interrumpe el hilo */
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
