package Rocket;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Cohete {

	private String code;
	private HashMap<Integer, Propulsor> propulsores = new HashMap<Integer, Propulsor>();
	private List<Integer> potenciaPropulsores;

	public Cohete(String code, List<Integer> potenciaPropulsores) throws Exception {
		if (code.length() != 8) {
			throw new Exception();
		}

		this.code = code;
		this.potenciaPropulsores = potenciaPropulsores;

		createPropulsores();
	}

	public String getCode() {
		return this.code;
	}

	public void createPropulsores() {
		int contador = 0;
		for (Integer potencia : this.potenciaPropulsores) {
			Propulsor propulsor = new Propulsor(potencia);
			propulsores.put(++contador, propulsor);
		}
	}

	public String showPropulsores() {
		String textoPotenciaPropulsores = "";
		for (Propulsor propulsor : propulsores.values()) {
			textoPotenciaPropulsores += propulsor.getPotenciaMax() + ",";
		}

		// Retorna el texto sin la última coma creada en el loop.
		return textoPotenciaPropulsores.substring(0, textoPotenciaPropulsores.length() - 1);
	}

	public void acelerar() {

	}

	public void frenar() {

	}

	public static void main(String[] args) throws Exception {

		Cohete rocket1 = new Cohete("32WESSDS", Arrays.asList(10, 30, 80));
		Cohete rocket2 = new Cohete("LDSFJA32", Arrays.asList(30, 40, 50, 50, 30, 10));

		System.out.println("Output: \n" + rocket1.getCode() + ": " + rocket1.showPropulsores() + "\n"
				+ rocket2.getCode() + ": " + rocket2.showPropulsores());

	}

}
