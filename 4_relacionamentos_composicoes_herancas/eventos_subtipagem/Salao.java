public class Salao  extends Evento {

	public Salao(String evnome, String cidade) {
		super(evnome, cidade);
		this.evnome = evnome;
		this.cidade = cidade;
	}

	@Override
	public String getTipo() {
		return "Salao";
	}

}
