package cobaia;

public class CPF {
  private String valor;
  
  public CPF(String valor) {
    if (valor.length() != 11) throw new IllegalArgumentException("CPF inválido");
    for (char c : valor.toCharArray())
      if (c < 48 || c > 57) throw new IllegalArgumentException("Somente números");
    
    this.valor = valor;
  }

  @Override
  public String toString() {    
    return this.getTexto();
  }

  public long getNumero() {
    return Long.parseLong(this.valor.replaceAll("^0+", ""));
  }
  
  public String getTexto() {
    return this.valor;
  }
}
