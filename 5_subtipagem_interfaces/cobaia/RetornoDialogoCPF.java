package cobaia;

public class RetornoDialogoCPF {
  public void recebe(CPF cpf) {
    System.out.println("CPF recebido, valor: " + cpf.getTexto());
    System.out.println("Número: " + cpf.getNumero());
  }
}
