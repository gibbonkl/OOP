package Carbnb;

public class Contrato {
	
	private Carbnb anuncio;
	private Date dataLocacao;
	private int diarias;
	private Usuario locatario;

	public Contrato(Carbnb anuncio, Date inicio,int diarias, Usuario locatario) {
		this.anuncio = anuncio;
		this.dataLocacao = inicio;
		this.diarias = diarias;
		this.locatario = locatario;
	}

	public Carbnb getAnuncio() {
		return anuncio;
	}

	public Date getDataLocacao() {
		return dataLocacao;
	}

	public int getDiarias() {
		return diarias;
	}

	public Usuario getLocatario() {
		return locatario;
	}
	
		
	
}
