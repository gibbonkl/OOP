public class Palestra  extends Atividade{

	public Palestra(Evento evento, String descricao, String ministrante) {
		super(evento, descricao, ministrante,0,0);
		this.evento = evento;
		this.descricao = descricao;
		this.ministrante = ministrante;
	}

	@Override
	public String getTipo() {
		return "Palestra";
	}

}
