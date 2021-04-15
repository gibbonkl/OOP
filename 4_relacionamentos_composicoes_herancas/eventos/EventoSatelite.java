public class EventoSatelite {
	
	public List inscritos;
	private Evento evento;
	private String nome;
	private Evento.Tipo tipo;

	public EventoSatelite(Evento evento, String nome, Evento.Tipo tipo) {
		this.evento = evento;
		this.nome = nome;
		this.tipo = tipo;
		this.inscritos = new List();
	}

	public Object getCidade() {
		return this.evento.getCidade();
	}

	public Object getEventoCentral() {
		return this.evento;
	}
//
	public void inscrever(String n) {
		Inscrito i = new Inscrito(this, n, new Chave());
		this.inscritos.append(i);
	}

	public int getQuantidadeInscritos() {
		return this.inscritos.count();
	}

	public Inscrito[] getInscritos() {
		
		Inscrito[] inscritos = new Inscrito[this.inscritos.count()];
		
		for(int j=0; j<inscritos.length; j++) {
			inscritos[j] = (Inscrito) this.inscritos.get(j);
		}
		
		return inscritos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((evento == null) ? 0 : evento.hashCode());
		result = prime * result + ((inscritos == null) ? 0 : inscritos.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		EventoSatelite other = (EventoSatelite) obj;
		if (evento == null) {
			if (other.evento != null)
				return false;
		} else if (!evento.equals(other.evento))
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
		if (tipo != other.tipo)
			return false;
		return true;
	}

}
