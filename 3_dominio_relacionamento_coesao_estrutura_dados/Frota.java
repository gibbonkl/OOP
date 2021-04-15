
public class Frota {
	
	List onibus;
	
	public Frota() {
		this.onibus = new List();
	}

	public Onibus novoOnibus(int numonibus, int assentos) {
		Onibus carro = new Onibus(numonibus, assentos);
		this.onibus.append(carro);
		return carro;
	}
	
	public void addOnibus(Onibus numonibus) {
		this.onibus.append(numonibus);
	}

	public int getQuantidade() {
		return onibus.count();
	}
	
	//verificar
	public Onibus getOnibus(int carro) {
		for(int i = 0; i < this.onibus.count(); i++) {
			Onibus o = (Onibus) this.onibus.get(i);
			if(o.getNumOnibus() == carro)
				return o;
		}
		return null;
	}

}
