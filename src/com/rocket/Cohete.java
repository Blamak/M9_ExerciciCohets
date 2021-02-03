package com.rocket;

public class Cohete {

	private String code;
	int numPropulsores;

	public Cohete(String code, int numPropulsores) throws Exception {
		if (code.length() != 8) {
			throw new Exception();
		}

		this.code = code;
		this.numPropulsores = numPropulsores;
	}

	public String getCode() {
		return this.code;
	}

	public int getNumPropulsores() {
		return this.numPropulsores;
	}

	public static void main(String[] args) {
		Cohete rocket1;
		Cohete rocket2;
		try {
			rocket1 = new Cohete("LDSFJA32", 6);
			System.out
					.println("Output: \n" + rocket1.getCode() + ": " + rocket1.getNumPropulsores() + " propulsores");
			
			rocket2 = new Cohete("x", 3);
			System.out
					.println("Output: \n" + rocket2.getCode() + ": " + rocket2.getNumPropulsores() + " propulsores\n");

		} catch (Exception e) {
			System.err.println("Error, código debe tener 8 dígitos.");
		}
	}
}
