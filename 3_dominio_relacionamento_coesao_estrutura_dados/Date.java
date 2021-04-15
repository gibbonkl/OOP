package Carbnb;

public class Date {

	private int dia;
	private int mes;
	private int ano;

	public Date(int d, int m, int a) {
		if(d < 1 || d > 31 || m < 1 || m > 12 || a < 2018) return;
		this.dia = d;
		this.mes = m;
		this.ano = a;
	}

	@Override
	public String toString() {
		String aux = "";		
		if (dia < 10) {
			aux = aux + "0" + dia;
		} else aux = aux + "" + dia;
				
		if (mes < 10) {
			aux = aux + "/0" + mes;
		} else aux = aux + "/" + mes;
		
		aux = aux + "/" + ano;
		
		return aux;
	}
}
