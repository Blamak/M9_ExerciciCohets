package com.rocket.domain;

import java.util.ArrayList;
import java.util.List;

import view.CoheteHilos;

public class Cohete {

	private int potenciaActualCohete = 0;
	private int potenciaMaximaCohete;
	private String codigo;
	private List<Integer> potenciaPropulsores;
	private List<Propulsor> propulsores = new ArrayList<>();
	private int numPropulsores;

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

	public void acelerar() {
		
		if ( !(this.potenciaActualCohete >= this.potenciaMaximaCohete) ) {
			this.potenciaActualCohete++;
			Runnable r = new CoheteHilos(this.propulsores, this.numPropulsores, 1);
			Thread t = new Thread(r);
			t.start();
		}
	}

	public void frenar() {
		if ( !(this.potenciaActualCohete <= 0) ) {
			this.potenciaActualCohete--;
			Runnable r = new CoheteHilos(this.propulsores, this.numPropulsores, -1);
			Thread t = new Thread(r);
			t.start();
		}
	}
}
