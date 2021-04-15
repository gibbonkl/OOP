class ValorAbsoluto{

  static double modulo(double num){
    if (num == 0) return 0;
    if (num < 0) return num*(-1);
    return num;
  }

  public static void main(String[] args) {
    System.out.println(modulo(-1234) == 1234);
    System.out.println(modulo(-0.536) == 0.536);
    System.out.println(modulo(0) == 0);
    System.out.println((-2/5) == (2/5));
    System.out.println(modulo(500) == 500);
  }
}
