public abstract class Evento {

	public List atividades;
	protected List eventossatelites;
	protected String evnome;
	protected String cidade;

	public Evento(String evnome, String cidade) {
		this.evnome = evnome;
		this.cidade = cidade;
		this.atividades = new List();
		this.eventossatelites = new List();	
	}
	
	public void  novoEventoSatelite(EventoSatelite e) {		
		this.eventossatelites.append(e);
	}
	
	public void  novaAtividade(Atividade a) {		
		this.atividades.append(a);
	}
	
	public abstract String getTipo();
	
	public String getNome() {
		return this.evnome;
	}

	public String getCidade() {
		return this.cidade;
	}

	public Atividade[] getAtividades() {
		
		Atividade[] atividades = new Atividade[this.atividades.count()];
		for(int i=0; i<atividades.length; i++) {
			atividades[i] = (Atividade)this.atividades.get(i);
		}
		return atividades;
	}

	public EventoSatelite[] getEventosSatelites() {
		
		EventoSatelite[] es = new EventoSatelite[this.eventossatelites.count()];
		
		for(int j=0; j<es.length; j++) {
			es[j] = (EventoSatelite)this.eventossatelites.get(j);
		}	
		return es;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atividades == null) ? 0 : atividades.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((evnome == null) ? 0 : evnome.hashCode());
		result = prime * result + ((eventossatelites == null) ? 0 : eventossatelites.hashCode());
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
		Evento other = (Evento) obj;
		if (atividades == null) {
			if (other.atividades != null)
				return false;
		} else if (!atividades.equals(other.atividades))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (evnome == null) {
			if (other.evnome != null)
				return false;
		} else if (!evnome.equals(other.evnome))
			return false;
		if (eventossatelites == null) {
			if (other.eventossatelites != null)
				return false;
		} else if (!eventossatelites.equals(other.eventossatelites))
			return false;
		return true;
	}


}
