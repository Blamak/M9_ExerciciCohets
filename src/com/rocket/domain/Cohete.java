package com.rocket.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase para crear el cohete
 * 
 * Sus atributos privados son:
 *  - la potencia máxima y actual,
 *  - un código identificativo,
 *  - una lista con la potencia de cada uno de sus propulsores,
 *    que utiliza en el método createPropulsores()
 *    para llamar al constuctor de la la clase Propulsor,
 *    creando los propulsores,
 *  - y el número de propulsores de los que dispone 
 *  
 *  Contiene los métodos acelerar() y frenar() que activan un hilo
 *  de la clase CoheteHilos cada vez que se pulsa uno de los botones
 *  de la ventana
 * 
 */
public class Cohete {

	private int potenciaActualCohete = 0;
	private int potenciaMaximaCohete;
	private String codigo;
	private List<Integer> potenciaPropulsores;
	private List<Propulsor> propulsores = new ArrayList<>();
	private int numPropulsores;

	/**
	 * Constructor de la clase, identificado por la cadena del código del cohete,
	 * y la lista con la potencia de cada uno de sus propulsores
	 * 
	 * Ejecuta el método createPropulsores() para crear los propulsores
	 * y le asigna su valor numérico al atributo numPropulsores, que contiene
	 * la cantidad de propulsores creados
	 * 
	 * @param código, String que contiene el código que identifica al cohete
	 * @param potenciaPropulsores, lista con la potencia de los propulsores
	 * @throws Exception, si el códgo no consta de ocho caracteres o no se
	 * 					  ha especificado ninguna potencia para propulsores
	 */
	public Cohete(String codigo, List<Integer> potenciaPropulsores) throws Exception {
		if (codigo.length() != 8)
			throw new Exception();

		if (potenciaPropulsores.size() == 0)
			throw new Exception();

		this.codigo = codigo;
		this.potenciaPropulsores = potenciaPropulsores;

		createPropulsores();
		this.numPropulsores = this.propulsores.size();
	}

	public String getCodigo() {
		return this.codigo;
	}

	/**
	 * Crea los propulsores del cohete recorriendo la lista de
	 * potencias y los va añadiendo a la lista de propulsores
	 * 
	 * Establece la potencia máxima del cohete
	 * 
	 */
	private void createPropulsores() {
		for (Integer potencia : this.potenciaPropulsores) {
			this.potenciaMaximaCohete += potencia;
			Propulsor newPropulsor = new Propulsor(potencia);
			this.propulsores.add(newPropulsor);
		}

	}

	public List<Propulsor> getPropulsores() {
		return this.propulsores;
	}

	/**
	 * Activa un hilo de aceleración tras comprobar que
	 * el cohete no ha alcanzado su velocidad máxima
	 */
	public void acelerar() {
		
		if ( !(this.potenciaActualCohete >= this.potenciaMaximaCohete) ) {
			this.potenciaActualCohete++;
			Runnable r = new CoheteHilos(this.propulsores, this.numPropulsores, 1);
			Thread t = new Thread(r);
			t.start();
		}
	}

	/**
	 * Activa un hilo de frenado tras comprobar que
	 * la potencia del cohete no es cero
	 */
	public void frenar() {
		if ( !(this.potenciaActualCohete <= 0) ) {
			this.potenciaActualCohete--;
			Runnable r = new CoheteHilos(this.propulsores, this.numPropulsores, -1);
			Thread t = new Thread(r);
			t.start();
		}
	}
}
