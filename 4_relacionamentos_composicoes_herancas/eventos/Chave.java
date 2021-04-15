import java.util.Random;
public class Chave {
	
	private String chave = "";

	Chave(){
		
		Random random = new Random();	
		
		for (int i = 0; i < 16; i++) {
			char Char = (char)(90-(random.nextInt(26)));
			this.chave= chave + Char;
			}
		
	}
	
	@Override	
	public String toString() {
		return this.chave;
	}
}
