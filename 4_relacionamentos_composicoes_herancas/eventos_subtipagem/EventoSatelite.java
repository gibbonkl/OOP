public abstract class EventoSatelite extends Evento{
	
	protected List inscritos;
	protected Evento evento;
	protected String nome;
	protected static String cidade;
	protected static String evnome;

	public EventoSatelite(Evento evento, String nome) {
		super(evnome,cidade);
		this.evento = evento;
		this.nome = nome;
		this.inscritos = new List();
		this.evento.novoEventoSatelite(this);
	}

	public String getCidade() {
		return this.evento.getCidade();
	}

	public Object getEventoCentral() {
		return this.evento;
	}
//
	public Inscrito inscrever(String n) throws NaoHaVagaException {
		Inscrito i = new Inscrito(this, n, new Chave());
		this.inscritos.append(i);
		return i;
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
		
		return true;
	}

	@Override
	public String getTipo() {
		return "Evento Satelite";
	}

}
