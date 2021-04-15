package Carbnb;

public class Veiculo {
	
	private Usuario anunciante;
	private String marca;
	private String modelo;
	private int ano;
	private String cidade;
	private String descricao;
	private double valor;

	public Veiculo (Usuario anunciante, String marca, String modelo,
				int ano, String descricao, String cidade, double valor) {
		this.anunciante = anunciante;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.descricao = descricao;
		this.cidade = cidade;
		this.valor = valor;
	}

	public Usuario getAnunciante() {
		return anunciante;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public int getAno() {
		return ano;
	}

	public String getCidade() {
		return cidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getValor() {
		return valor;
	}
	
}
