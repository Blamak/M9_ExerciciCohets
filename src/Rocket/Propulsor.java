package Rocket;

public class Propulsor {
	
	private int potenciaActual = 0;
	private int potenciaMax;
	private int estadoPropulsor = 0;
	
	public Propulsor(int potenciaMax) {
		this.potenciaMax = potenciaMax;
	}

	public int getPotenciaActual() {
		return this.potenciaActual;
	}

	public void setPotenciaActual(int potenciaActual) {
		this.potenciaActual = potenciaActual;
	}

	public int getPotenciaMax() {
		return this.potenciaMax;
	}

	public void setPotenciaMax(int potenciaMax) {
		this.potenciaMax = potenciaMax;
	}

	public int getEstadoPropulsor() {
		return this.estadoPropulsor;
	}

	public void setEstadoPropulsor(int estadoPropulsor) {
		this.estadoPropulsor = estadoPropulsor;
	}
		

}
