package subtipagem_interface;

public class Placa implements IDoc {

	private String valor;

	@Override
	public String getTipo() {
		return "Placa";
	}

	@Override
	public int getTamanho() {
		return 7;
	}

	@Override
	public String getTexto() {
		return this.valor.toUpperCase();
	}

	@Override
	public long getNumero() {
		return Long.parseLong(this.valor.substring(3, 7));
	}

	@Override
	public void setValor(String valor) {
		this.valor = valor;
	}

}
