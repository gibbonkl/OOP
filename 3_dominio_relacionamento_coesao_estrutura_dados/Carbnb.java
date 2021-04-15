package Carbnb;

public class Carbnb {

	private Usuario locador;
	private Veiculo veiculo;
	private Veiculo [] veiculos;
	private Usuario [] usuarios;
	private Contrato [] contratos;

	public Carbnb(Usuario usuario, Veiculo veiculo) {
		this.locador = usuario;
		this.veiculo = veiculo;
	}

	public Usuario criarUsuario(String nome, String email, String cpf, String telefone) {
		Usuario u = new Usuario(nome, email, cpf, telefone);
		return u;
	}
	
	public Contrato criarContrato(Carbnb anuncio, Date inicio,int diarias, Usuario locatario) {
		Contrato c = new Contrato(anuncio, inicio, diarias, locatario);
		return c;
		
	}

	public Usuario getLocador() {
		return locador;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public Veiculo[] getVeiculos() {
		return veiculos;
	}

	public Usuario[] getUsuarios() {
		return usuarios;
	}

	public Contrato[] getContratos() {
		return contratos;
	}
		
	
}
