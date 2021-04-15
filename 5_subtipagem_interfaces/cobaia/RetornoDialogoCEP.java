package cobaia;

public class RetornoDialogoCEP {
  public void recebe(CEP cep) {
    System.out.println("CEP recebido, valor: " + cep.getTexto());
    System.out.println("Número: " + cep.getNumero());
  }
}
