package subtipagem_interface;

public class Hora implements IDoc {

	private String valor;

	@Override
	public String getTipo() {
		return "Hora";
	}

	@Override
	public int getTamanho() {
		return 4;
	}

	@Override
	public String getTexto() {
		return this.toString();
	}

	@Override
	public long getNumero() {
		return Long.parseLong(this.valor.replaceAll("^0+", ""));
	}
	
	@Override
	public String toString() {
		return this.valor.substring(0,2) + ":" + this.valor.substring(2,4);
	}
	
	@Override
	public void setValor(String valor) {		
		this.valor = valor;
	}

}
