
public class Passagem {
	
	private int assento;
	private Viagem viagem;
	private boolean disponivel = true;
	private int bilhete;

	public Passagem (int assento, Viagem codigoviagem) {
		this.assento = assento;
		this.viagem = codigoviagem;
	}
	
	public void comprar() {
		this.disponivel = !this.disponivel;
	}
	
	//ver
	public void setBilhete(int bilhete) {
		this.bilhete = bilhete;
	}
	
	public int getBilhete() {
		return this.bilhete;
	}

	public boolean isDisponivel() {
		return this.disponivel;
	}

	public int getAssento() {
		return this.assento;
	}

	public String getCodigo() {
		String aux = "00000" + viagem.getCodigo() + ".00000" + this.getBilhete() + ".";
		if (this.assento < 10) {
			aux = aux + "0" + this.assento;
		} else aux = aux + "" + this.assento;		
		return aux;
	}

}
