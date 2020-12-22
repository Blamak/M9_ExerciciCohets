package windows;

import java.util.List;

import Rocket.Cohete;
import Rocket.Propulsor;

public class CoheteHilos implements Runnable {

	private List<Propulsor> propulsores;
	private int variacionPotencia;

	public CoheteHilos(List<Propulsor> propulsores, int variacionPotencia) {
		this.propulsores = propulsores;
		this.variacionPotencia = variacionPotencia;
	}

	public void run() {
		int numPropulsores = this.propulsores.size();
		int factorVariacion = Math.abs(variacionPotencia);
		int factorIndex = factorVariacion;

		int diferencia = factorVariacion - numPropulsores;
		int factorMovimiento = variacionPotencia / factorVariacion;
		int propulsorIndex;
		Propulsor propulsor;

		while (factorVariacion > 0) {

			if (Cohete.potenciaActualCohete >= Cohete.potenciaMaximaCohete) {
				break;
			}

			System.out.println(factorIndex);
			if (factorIndex > diferencia) {
				propulsorIndex = Math.abs(Math.abs(factorIndex) - (numPropulsores + diferencia));
				propulsor = this.propulsores.get(propulsorIndex);
			} else {
				propulsorIndex = Math.abs(Math.abs(factorIndex) - diferencia);
				propulsor = this.propulsores.get(propulsorIndex);

			}

			if (((propulsor.getPotenciaActual()) < propulsor.getPotenciaMax())
					&& ((propulsor.getPotenciaActual() + factorMovimiento) >= 0)) {
//				System.out.println("2nd con: " + (propulsor.getPotenciaActual() + factorMovimiento));
				propulsor.setPotenciaActual(propulsor.getPotenciaActual() + factorMovimiento);
				Cohete.potenciaActualCohete += factorMovimiento;
				System.out.println(Cohete.potenciaActualCohete);
				propulsor.refrehPanel();
				factorVariacion -= 1;
				factorIndex -= 1;

				if (factorIndex == 0) {
					factorIndex = 10;
				}

			} else {

//				this.propulsores.remove(propulsor);
				numPropulsores -= 1;

//				factorIndex -= 2;
				if (factorIndex == 0) {
					factorIndex = 10;
				}
			}

			try {
				Thread.sleep(100);

			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

}

//		int aumento = 10;
//		while (variacion != 0) {
//			for (Propulsor propulsor : this.propulsores) {
//
//				// condiciones para romper la iteracion:
//				if (variacion == 0) {
//					break;
//				}
//
//				if (Cohete.potenciaActualCohete + (Math.abs(variacion) - Math.abs(variacion - 1)) < 0) {
//					System.out.println("negata");
//					variacion = 0;
//					break;
//				}
//
//				if ( 
//						!((propulsor.getPotenciaActual() >= propulsor.getPotenciaMax()) && variacion > 0)
//						
//						&& !((propulsor.getPotenciaActual() <= 0) && variacion < 0)
//					)
//				{
//		propulsor.setPotenciaActual(propulsor.getPotenciaActual() + (Math.abs(variacion) - Math.abs(variacion - 1)));
//		Cohete.potenciaActualCohete += Math.abs(variacion) - Math.abs(variacion - 1);

//		variacion -= Math.abs(variacion) - Math.abs(variacion - 1);