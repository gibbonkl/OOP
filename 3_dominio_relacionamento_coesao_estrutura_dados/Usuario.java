package Carbnb;

public class Usuario {
	private String nome;
	private String email;
	private String cpf;
	private String telefone;

	public Usuario (String nome, String email, String cpf, String telefone) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.telefone = telefone;	
	}
	
	public void adicionarVeiculo (String marca, String modelo,
			int ano, String descricao, String cidade, double valor) {
		Veiculo v = new Veiculo(this, marca, modelo, ano, descricao, cidade, valor);
		
	}
	public void anunciarVeiculo (Usuario this, Veiculo veiculo) {
		Carbnb c = new Carbnb(this, veiculo);
		
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}

	public String getTelefone() {
		return telefone;
	}
	
	
}
