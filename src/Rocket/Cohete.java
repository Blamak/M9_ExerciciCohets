package Rocket;

import java.util.ArrayList;
import java.util.List;

import windows.CoheteHilos;

public class Cohete {

	public static int potenciaActualCohete = 0;
	private String code;
	private List<Integer> potenciaPropulsores;
	private List<Propulsor> propulsores = new ArrayList<>();
	public static int potenciaMaximaCohete;

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
			Cohete.potenciaMaximaCohete += potencia;
		}

		createPropulsores();

	}

	public String getCode() {

		return this.code;

	}

	public void createPropulsores() {

		for (Integer potencia : this.potenciaPropulsores) {
			Cohete.potenciaMaximaCohete += potencia;
			Propulsor newPropulsor = new Propulsor(potencia);
			this.propulsores.add(newPropulsor);
		}

	}

	public List<Propulsor> getPropulsores() {

		return this.propulsores;

	}

	public void acelerar() {
		
			
			int numPropulsores = this.propulsores.size();
			
			Runnable r = new CoheteHilos(this.propulsores, numPropulsores, 1);
			
			Thread t = new Thread(r);
			t.start();

	}

	public void frenar() {
		
			
			int numPropulsores = this.propulsores.size();
			
			Runnable r = new CoheteHilos(this.propulsores, numPropulsores, -1);
			
			Thread t = new Thread(r);
			t.start();
	}
}


