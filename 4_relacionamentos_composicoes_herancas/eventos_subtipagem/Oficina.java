public class Oficina  extends Atividade{

	public Oficina(Evento evento, String descricao, String ministrante, int vagas, int horas) {
		super(evento, descricao, ministrante, vagas, horas);
		this.evento = evento;
		this.descricao = descricao;
		this.ministrante = ministrante;
		this.vagas = vagas;
		this.horas = horas;
	}

	@Override
	public String getTipo() {
		return "Oficina";
	}
	
}
