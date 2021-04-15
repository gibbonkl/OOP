
public class Rodoviaria {

	private final String cidade;
	private List viagens;
	private int codigoviagem = 0;

	public Rodoviaria(String cidade) {
		this.cidade = cidade;
		this.viagens = new List();
	}
	
	public Viagem criarViagem(String destino, Date data, Time hora, Object onibus) {
		this.codigoviagem++;
		Viagem v = new Viagem(this.codigoviagem, this.getLocalidade(), 
				destino, data, hora, (Onibus) onibus);
		viagens.append(v);
		return v;
	}
	
	public Passagem comprarPassagem(int codigoviagem, int assento) 
			throws AssentoIndisponivelException, AssentoInexistenteException {
		Viagem v = getViagem(codigoviagem);
		return v.comprarPassagem(assento);
	}
	
	public String getLocalidade() {
		return this.cidade;
	}

	public Viagem getViagem(int codviagem) {
		for (int i=0; i<viagens.count(); i++) {
			Viagem v = (Viagem) viagens.get(i);
			if (v.getCodigo() == codviagem) return v;
		}		
		return null;
	}

	@Override
	public String toString() {
		return (String) getLocalidade();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rodoviaria other = (Rodoviaria) obj;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		return true;
	}
	
	

	
}
