public class Seminario extends Atividade{

	public Seminario(Evento evento, String descricao, String ministrante, int vagas, int horas) {
		super(evento, descricao, ministrante, vagas, horas);
		this.evento = evento;
		this.descricao = descricao;
		this.vagas = vagas;
		this.horas = horas;
	}
	
	public Seminario(Evento evento, String descricao, int vagas) {
		super(evento, descricao, "", vagas, 0);
		this.evento = evento;
		this.descricao = descricao;
		this.vagas = vagas;
	}
	
	public Seminario(Evento evento, String descricao) {
		super(evento, descricao, "", 0, 0);
		this.evento = evento;
		this.descricao = descricao;
	}

	@Override
	public String getTipo() {
		return "Seminario";
	}

}
