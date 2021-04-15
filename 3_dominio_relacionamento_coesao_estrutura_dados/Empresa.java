
public class Empresa {

	private final String nome;
	private Frota frota;

	public Empresa(String nome) {
		this.nome = nome;
		this.frota = new Frota();
	}
	
	public void novoOnibus(int numonibus, int assentos) {
		if (this.frota.getOnibus(numonibus) != null) return;
		this.frota.addOnibus(new Onibus(numonibus, assentos));		
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public Frota getFrota() {
		return frota;
	}

	@Override
	public String toString() {
		return (String) getNome();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	
}
