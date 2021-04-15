package subtipagem_interface;

public class Data implements IDoc {

	private String valor;

	@Override
	public String getTipo() {
		return "Data";
	}

	@Override
	public int getTamanho() {
		return 8;
	}

	@Override
	public String getTexto() {
		return this.toString();
	}

	@Override
	public long getNumero() {
		return Long.parseLong(this.valor);
	}

	@Override
	public String toString() {
		return this.valor.substring(0, 2) + "/" + this.valor.substring(2, 4) + "/" + this.valor.substring(4, 8);
	}

	@Override
	public void setValor(String valor) {
		this.valor = valor;
	}

}
