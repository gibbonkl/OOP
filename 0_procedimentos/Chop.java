class Chop{

  public static void main(String[] args) {

    //Implementar o método chop, em classe separada Text,
    //que toma uma String de entrada e devolve outra sem o último caractere.
    String s1 = "seven of nine";
    String s2 = Text.chop(s1);
    System.out.println(s1); // seven of nine
    System.out.println(s2); // seven of nin
    System.out.println(s2.equals("seven of nin") == true); // true
    String s3 = Text.chop(s2);
    System.out.println(s3); // seven of ni
    System.out.println(s3.equals("seven of ni") == true); // true
    System.out.println(Text.chop("spock").equals("spoc") == true);
    // Casos Especiais
    System.out.println(Text.chop("Q").equals("") == true);
    System.out.println(Text.chop("").equals("") == true);
    System.out.println(Text.chop(Text.chop(Text.chop("abc"))).equals("") == true);
    // Adicione mais 2 Casos de Teste:
    System.out.println(Text.chop(Text.chop(Text.chop(Text.chop("abc")))).equals("") == true);
    System.out.println(Text.chop(Text.chop(Text.chop(Text.chop("Last")))).equals("") == true);
  }
}
