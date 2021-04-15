package subtipagem_interface;

public class RetornoDialogo {
	public void recebe(IDoc doc) {
		System.out.println(doc.getTipo() + " recebido, valor: " + doc.getTexto());
		System.out.println("Número: " + doc.getNumero());
	}
}
