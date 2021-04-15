public class Atividade {

	public List atividades;
	public List inscritos;
	public Tipo tipo;
	private int horas;
	private Evento nome;
	private String descricao;
	private int vagas;
	private String ministrante;
	private Evento evento;
	public int count;
	
	public enum Tipo {
		Seminario, Minicurso, Oficina, Palestra
	}
	
	public Atividade(Evento evento, String descricao, int vagas, Tipo tipo) {
		this.evento = evento;
		this.descricao =descricao;
		this.vagas = vagas;
		this.tipo = tipo;
		this.inscritos = new List(); 
	}

	public Atividade(Evento evento, String descricao, int vagas, int horas, Tipo tipo) {
		this.evento = evento;
		this.descricao =descricao;
		this.vagas = vagas;
		this.horas = horas;
		this.tipo = tipo;
		this.inscritos = new List(); 
	}

	public Atividade(Evento evento, String descricao, String ministrante, int vagas, int horas, Tipo tipo) {
		this.evento = evento;
		this.descricao =descricao;
		this.ministrante = ministrante;
		this.vagas = vagas;
		this.horas = horas;
		this.tipo = tipo;
		this.inscritos = new List(); 
	}

	public Atividade(Evento evento, String descricao, String ministrante, Tipo tipo) {
		this.evento = evento;
		this.descricao =descricao;
		this.ministrante = ministrante;
		this.tipo = tipo;
		this.inscritos = new List(); 
	}

	//public List getInscritos() {
		//return inscritos;
	//}
	
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
		// TODO Auto-generated method stub
		return this.descricao;
	}

	public List getAtividades() {
		return atividades;
	}

	public Evento getNome() {
		return this.nome;
	}

	public int getVagas() {
		// TODO Auto-generated method stub
		return this.vagas;
	}

	public Tipo getTipo() {
		return this.tipo;
	}

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
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		if (tipo != other.tipo)
			return false;
		if (vagas != other.vagas)
			return false;
		return true;
	}

	
	

}
