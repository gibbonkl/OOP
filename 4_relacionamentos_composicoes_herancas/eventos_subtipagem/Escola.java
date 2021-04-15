public class Escola extends Evento {

	public Escola(String nome, String cidade) {
		super(nome, cidade);
		this.evnome = evnome;
		this.cidade = cidade;		
	}

	@Override
	public String getTipo() {
		return "Escola";
	}

}
