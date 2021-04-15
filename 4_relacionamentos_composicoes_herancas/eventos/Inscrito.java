public class Inscrito {
	
	public List inscritos;
	private EventoSatelite eventosatelite;
	private String nome;
	private Chave chave;
	private boolean presente;
	private Atividade atividade;
	

	public Inscrito(EventoSatelite eventoSatelite, String nome, Chave chave) {
		this.eventosatelite = eventoSatelite;
		this.nome = nome;
		this.chave = chave;
		
	}

	public Inscrito(Atividade atividade, String nome, Chave chave) {
		this.atividade = atividade;
		this.nome = nome;
		this.chave = chave;
		
	}

	public Object getNome() {
		return this.nome;
	}

	public Chave getChave() {
		return this.chave;
	}

	public List getInscritos() {
		return inscritos;
	}

	public EventoSatelite getEventosatelite() {
		return eventosatelite;
	}

	public boolean isPresente() {
		return this.presente;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public boolean isConcluido() {
		return isPresente();
	}

	public void confirmarPresenca() {
		this.presente=true;
	}

	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atividade == null) ? 0 : atividade.hashCode());
		result = prime * result + ((chave == null) ? 0 : chave.hashCode());
		result = prime * result + ((eventosatelite == null) ? 0 : eventosatelite.hashCode());
		result = prime * result + ((inscritos == null) ? 0 : inscritos.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + (presente ? 1231 : 1237);
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
		Inscrito other = (Inscrito) obj;
		if (atividade == null) {
			if (other.atividade != null)
				return false;
		} else if (!atividade.equals(other.atividade))
			return false;
		if (chave == null) {
			if (other.chave != null)
				return false;
		} else if (!chave.equals(other.chave))
			return false;
		if (eventosatelite == null) {
			if (other.eventosatelite != null)
				return false;
		} else if (!eventosatelite.equals(other.eventosatelite))
			return false;
		if (inscritos == null) {
			if (other.inscritos != null)
				return false;
		} else if (!inscritos.equals(other.inscritos))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (presente != other.presente)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return (String) getNome();
	}

}
