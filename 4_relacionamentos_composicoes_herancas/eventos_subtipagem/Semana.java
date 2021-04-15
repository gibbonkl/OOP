public class Semana extends Evento{

	public Semana(String evnome, String cidade) {
		super(evnome, cidade);
		this.evnome = evnome;
		this.cidade = cidade;
		this.atividades = new List();
		this.eventossatelites = new List();
	}

	@Override
	public String getTipo() {
		return "Semana";
	}
}
