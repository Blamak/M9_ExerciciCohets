package cohete.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cohete {

	private String code; // Código del cohete

	// Lista de potencias para crear los propulsores
	private List<Integer> potenciaPropulsores;

	// Lista para almacenar cada uno de los propulsores
	private List<Propulsor> propulsores = new ArrayList<>();

	public Cohete(String code, List<Integer> potenciaPropulsores) throws Exception {
		if (code.length() != 8) {
			throw new Exception();
		}

		this.code = code;
		this.potenciaPropulsores = potenciaPropulsores;

		createPropulsores();
	}

	public void createPropulsores() {
		for (Integer potencia : this.potenciaPropulsores) {
			Propulsor propulsor = new Propulsor(potencia);
			propulsores.add(propulsor);
		}
	}

	public String getCode() {
		return this.code;
	}

	public String showPropulsores() {
		String textoPotenciaPropulsores = "";
		for (Propulsor propulsor : propulsores) {
			textoPotenciaPropulsores += propulsor.getPotenciaMax() + ",";
		}

		// Retorna el texto sin la última coma creada en el loop.
		return textoPotenciaPropulsores.substring(0, textoPotenciaPropulsores.length() - 1);
	}

	public static void main(String[] args) throws Exception {

		Cohete rocket1 = new Cohete("32WESSDS", Arrays.asList(10, 30, 80));
		Cohete rocket2 = new Cohete("LDSFJA32", Arrays.asList(30, 40, 50, 50, 30, 10));

		System.out.println("Output: \n" + rocket1.getCode() + ": " + rocket1.showPropulsores() + "\n"
				+ rocket2.getCode() + ": " + rocket2.showPropulsores());

	}

}
