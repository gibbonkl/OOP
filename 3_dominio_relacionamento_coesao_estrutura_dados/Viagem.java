
public class Viagem {
	
	private int vendidas;
	private Passagem [] passagens;
	private int codigoviagem;
	private String origem;
	private String destino;
	private Date data;
	private Time hora;
	private Onibus onibus;

	public Viagem(int codigoviagem,String origem,String destino, Date data, Time hora, Onibus onibus) {
		this.codigoviagem = codigoviagem;
		this.origem = origem;
		this.destino = destino;
		this.data = data;
		this.hora = hora;
		this.onibus = onibus;
		
		this.passagens = new Passagem[onibus.getAssentos()];
		
		for (int i = 0; i < onibus.getAssentos(); i++) {
			this.passagens[i] = new Passagem(i+1, this);
		}
	}
	
	public int getCodigo() {
		return codigoviagem;
	}

	public Object getOrigem() {
		return this.origem;
	}

	public Object getDestino() {
		return this.destino;
	}

	public Date getData() {
		return data;
	}

	public Time getHora() {
		return hora;
	}

	public int getTotalPassagens() {
		return this.onibus.getAssentos();
	}

	public int getTotalPassagensDisponiveis() {
		return getTotalPassagens() - this.vendidas;
	}

	public Passagem comprarPassagem(int assento) throws AssentoIndisponivelException, AssentoInexistenteException {
		//ver
		if (assento < 1 || assento > passagens.length) 
			throw new AssentoInexistenteException();
		
		Passagem p = passagens[assento-1];
		
		if (!p.isDisponivel()) {
			throw new AssentoIndisponivelException();		
		}
		
		p.comprar();
		this.vendidas++;
		p.setBilhete(vendidas);
				return p;
	}

	public Passagem[] getPassagens() {
		return passagens;
	}	

}
