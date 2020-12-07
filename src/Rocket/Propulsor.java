package Rocket;

public class Propulsor {
	
	private int potenciaActual = 0;
	private int potenciaMax;
	
	public Propulsor(int potenciaMax) {
//		this.potenciaActual = potenciaActual;
		this.potenciaMax = potenciaMax;
	}

	public int getPotenciaMax() {
		return this.potenciaMax;
	}

	public void setPotenciaMax(int potenciaMax) {
		this.potenciaMax = potenciaMax;
	}
		

}
