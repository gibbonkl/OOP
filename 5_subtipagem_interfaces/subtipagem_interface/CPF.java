package subtipagem_interface;

public class CPF extends Doc {

	@Override
	public String getTipo() {
		return "CPF";
	}

	@Override
	public int getTamanho() {
		return 11;
	}

	@Override
	public String toString() {
		return this.valor.substring(0, 3) + "." + this.valor.substring(3, 6) + "." + this.valor.substring(6, 9) + "-"
				+ this.valor.substring(9, 11);
	}

}
