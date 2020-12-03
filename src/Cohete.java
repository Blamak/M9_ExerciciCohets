
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

	public static void main(String[] args) throws Exception {
		Cohete rocket1 = new Cohete("xxxxxxxx", 3);
		Cohete rocket2 = new Cohete("LDSFJA32", 6);

		System.out.println(
				"Output: \n" 
				+ rocket1.getCode() + ": " + rocket1.getNumPropulsores() + " propulsores\n"
				+ rocket2.getCode() + ": " + rocket2.getNumPropulsores() + " propulsores"
		);

	}

}
