public class Minicurso  extends Atividade{

	public Minicurso(Evento evento, String descricao, int vagas, int horas) {
		super(evento, descricao,"", vagas, horas);
		this.evento = evento;
		this.descricao = descricao;
		this.vagas = vagas;
		this.horas = horas;	
	}

	@Override
	public String getTipo() {
		return "Minicurso";
	}

}
