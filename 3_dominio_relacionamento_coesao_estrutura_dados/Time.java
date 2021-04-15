
public class Time {

	private int hora;
	private int minuto;

	public Time(int h) {
		if (h <0 || h > 24) return;
		this.hora = h;
	}

	public Time(int h, int m) {
		if (h < 0 || h > 24 || minuto < 0 || minuto > 59) return;
		this.hora = h;
		this.minuto = m;
	}

	@Override
	public String toString() {
		String aux = "";
		if (hora < 10) {
			aux = aux + "0" + hora;
		} else aux = aux + "" + hora;
		
		if (minuto < 10) {
			aux = aux + ":0" + minuto;
		} else aux = aux + ":" + minuto;
		
		aux = aux + ":00";
			
		return aux;
	}
	
	

}
