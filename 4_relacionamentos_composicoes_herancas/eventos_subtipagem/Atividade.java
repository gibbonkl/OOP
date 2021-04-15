public abstract class Atividade extends EventoSatelite{

	protected List atividades;
	protected List inscritos;
	protected String ministrante;
	protected Evento evento;
	protected int count;
	protected int horas;
	protected int vagas;
	protected String descricao;

	public Atividade(Evento evento, String descricao, String ministrante, int vagas, int horas) {
		super(evento, cidade);
		this.evento = evento;
		this.cidade = cidade;
		
		this.descricao =descricao;
		this.ministrante = ministrante;
		this.vagas = vagas;
		this.horas = horas;
		this.inscritos = new List(); 
		this.evento.novaAtividade(this);
	}
	
	public Inscrito inscrever(String n) throws NaoHaVagaException {
		
		if (this.getVagasRemanescentes()<1 && this.vagas != 0) {
			throw new NaoHaVagaException();
		} else {
		Inscrito i = new Inscrito(this, n, new Chave());
		this.inscritos.append(i);
		this.count++;
		
		return i;
		}
	}
	
	public Object getDescricao() {
		return this.descricao;
	}

	public int getVagas() {
		return this.vagas;
	}

	public abstract String getTipo();

	public int getHoras() {
		return this.horas;
	}

	public Evento getEvento() {
		return this.evento;
	}

	public String getMinistrante() {
		return this.ministrante;
	}

	public int getVagasRemanescentes() {
	
		return this.getVagas()-this.count;
	}

	public int getQuantidadeInscritos() {
		return this.inscritos.count();
	}

	public Inscrito[] getInscritos() {
		
		Inscrito[] inscritos = new Inscrito[this.inscritos.count()];
		
		for (int j = 0; j < inscritos.length; j++) {
			
			inscritos[j] = (Inscrito)this.inscritos.get(j);
		}
		
		return inscritos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atividades == null) ? 0 : atividades.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + horas;
		result = prime * result + ((inscritos == null) ? 0 : inscritos.hashCode());
		result = prime * result + ((ministrante == null) ? 0 : ministrante.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + vagas;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atividade other = (Atividade) obj;
		if (atividades == null) {
			if (other.atividades != null)
				return false;
		} else if (!atividades.equals(other.atividades))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (horas != other.horas)
			return false;
		if (inscritos == null) {
			if (other.inscritos != null)
				return false;
		} else if (!inscritos.equals(other.inscritos))
			return false;
		if (ministrante == null) {
			if (other.ministrante != null)
				return false;
		} else if (!ministrante.equals(other.ministrante))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;

		if (vagas != other.vagas)
			return false;
		return true;
	}

	
	

}
