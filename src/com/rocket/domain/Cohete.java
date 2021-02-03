package com.rocket.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase para crear el cohete
 * 
 * Sus atributos privados son: 
 * - un c�digo identificativo 
 * - una lista con la potencia de cada uno de sus propulsores,
 *   que emplea en el m�todo createPropulsores() para llamar al constuctor de la
 *   la clase Propulsor y crear cada uno de los propulsores
 * - el n�mero de propulsores de los que dispone, utilizado para
 * 
 * Contiene los m�todos acelerar() y frenar() que activan un hilo de la clase
 * CoheteHilos cada vez que se pulsa uno de los botones de la ventana
 * 
 */
public class Cohete {

	private String codigo;
	private List<Integer> potenciaPropulsores;
	private List<Propulsor> propulsores = new ArrayList<>();

	/**
	 * Constructor de la clase, identificado por la cadena del c�digo del cohete, y
	 * la lista con la potencia de cada uno de sus propulsores
	 * 
	 * Ejecuta el m�todo createPropulsores() para crear los propulsores y le asigna
	 * su valor num�rico al atributo numPropulsores, que contiene la cantidad de
	 * propulsores creados
	 * 
	 * @param c�digo,              String que identifica al cohete
	 * @param potenciaPropulsores, lista con la potencia de los propulsores
	 * @throws Exception,          si el c�digo no consta de ocho caracteres o no se ha
	 *                             especificado ninguna potencia para los propulsores
	 *                             
	 */
	public Cohete(String codigo, List<Integer> potenciaPropulsores) throws Exception {
		if (codigo.length() != 8)
			throw new Exception();

		if (potenciaPropulsores.size() == 0)
			throw new Exception();

		this.codigo = codigo;
		this.potenciaPropulsores = potenciaPropulsores;

		createPropulsores();
	}

	public String getCodigo() {
		return this.codigo;
	}

	/**
	 * Crea los propulsores del cohete recorriendo la lista de potencias y los va
	 * a�adiendo a la lista de propulsores
	 * 
	 * Establece la potencia m�xima del cohete
	 * 
	 */
	private void createPropulsores() {
		for (Integer potencia : this.potenciaPropulsores) {
			Propulsor newPropulsor = new Propulsor(potencia);
			this.propulsores.add(newPropulsor);
		}

	}

	public List<Propulsor> getPropulsores() {
		return this.propulsores;
	}

	/**
	 * Activa un hilo de aceleraci�n tras comprobar que el cohete no ha alcanzado su
	 * velocidad m�xima
	 */
	public void acelerar() {
		Runnable r = new CoheteHilos(this.propulsores, 1);
		Thread t = new Thread(r);
		t.start();
	}

	/**
	 * Activa un hilo de frenado tras comprobar que la potencia del cohete no es
	 * cero
	 */
	public void frenar() {
		Runnable r = new CoheteHilos(this.propulsores, -1);
		Thread t = new Thread(r);
		t.start();
	}
}
