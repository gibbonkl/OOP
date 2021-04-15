package cobaia;

public class CEP {
  private String valor;
  
  public CEP(String valor) { // 96201440
    if (valor.length() != 8) throw new IllegalArgumentException("CEP inválido");
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