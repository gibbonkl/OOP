package subtipagem_interface;

public abstract class Doc implements IDoc {

	protected String valor;

	public void setValor(String valor) {

		if (valor.length() != getTamanho())
			throw new IllegalArgumentException(getTipo() + " inválido");
		for (char c : valor.toCharArray())
			if (c < 48 || c > 57)
				throw new IllegalArgumentException("Somente números");

		this.valor = valor;
	}

	@Override
	public String toString() {
		return this.valor;
	}

	public long getNumero() {
		return Long.parseLong(this.valor.replaceAll("^0+", ""));
	}

	public String getTexto() {
		return this.toString();
	}
}
