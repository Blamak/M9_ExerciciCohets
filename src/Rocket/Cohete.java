package Rocket;

import java.util.ArrayList;
import java.util.List;

import windows.CoheteHilos;
import windows.Marco;

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
			potenciaMaximaCohete += potencia;
			System.out.println("MAX: "+potenciaMaximaCohete);
		}

		createPropulsores();

	}

	public String getCode() {
		
		return this.code;
		
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

		Runnable r = new CoheteHilos(this.propulsores, 10);
		Thread t = new Thread(r);
		t.start();
		
	}

	public void frenar() {

		Runnable r = new CoheteHilos(this.propulsores, -10);
		Thread t = new Thread(r);
		t.start();

	}
}

//		
//		while (decremento != 0) {
//			if (potenciaActualCohete <= 0) {
//				System.out.println("thas colao bacalao");
//				break;
//			}
//			for (Propulsor propulsor : this.propulsores) {
//				// un punto por cada propulsor
//				if (propulsor.getPotenciaActual() != 0 && decremento > 0) {
//					propulsor.setPotenciaActual(propulsor.getPotenciaActual() - 1);
//					potenciaActualCohete--;
//					propulsor.setEstadoPropulsor(-1);
//					decremento--;
//				}
//				if (propulsor.getPotenciaActual() == 0 || decremento == 10) {
//					propulsor.setEstadoPropulsor(0);
//				}
//
//			}
//			System.out.println(potenciaActualCohete);

//		}
