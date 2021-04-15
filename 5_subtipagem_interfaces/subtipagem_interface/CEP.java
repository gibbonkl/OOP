package subtipagem_interface;

public class CEP extends Doc {

	@Override
	public String getTipo() {
		return "CEP";
	}

	@Override
	public int getTamanho() {
		return 8;
	}

	@Override
	public String toString() {
		return this.valor.substring(0, 5) + "-" + this.valor.substring(5, 8);
	}

}
