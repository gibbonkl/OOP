public class Mostra  extends EventoSatelite {

	protected static String cidade;
	protected static String evnome;
	private Evento evento;
	private String descricao;

	public Mostra(Evento evento, String descricao) {
		super(evento,cidade);		
		this.evento = evento;
		this.descricao = descricao;	
	}

	@Override
	public String getTipo() {
		return "Mostra";
	}

}
