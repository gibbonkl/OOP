class MMC{

  static int mmc(int num1,int num2){
    //(a-((a/b)*b)) == a%b
    int mmc = 1;
    //deixando os numeros em módulo
    if (num1 < 0) num1 = num1*(-1);
    if (num2 < 0) num2 = num2*(-1);

    int maior = 0;
    int menor = 0;

    if (num1 > num2) {
      maior = num1;
      menor = num2;
    } else {
      maior = num2;
      menor = num1;
    }
//caso um deles seja um
    if (num1==1 || num2==1) return num1*num2;

//minimos entre os dois
    for (int i=2; i<=menor; i++) {
      while ((maior-((maior/i)*i))==0 && (menor-((menor/i)*i))==0){
        mmc = mmc*i;
        maior=maior/i;
        menor=menor/i;
      }
    }
//minimo individual
    for (int i=2; i<=menor; i++) {
      while ((menor-((menor/i)*i))==0){
        mmc = mmc*i;
        menor=menor/i;
      }
    }
    for (int i=2; i<=maior; i++) {
      while ((maior-((maior/i)*i))==0){
        mmc = mmc*i;
        maior=maior/i;
      }
    }

    return mmc;
  }

  static int mmc(int num1,int num2,int num3){
    return mmc(mmc(num1,num2),num3);
  }
  static int mmc(int num1,int num2,int num3,int num4){
    return mmc(mmc(num1,num2,num3),num4);
  }

  public static void main(String[] args) {
    //nao pode usar %
    int num1 = 5;
    int num2 = 2;
    int resp = mmc(num1, num2);

    System.out.println(resp); // imprime 10
    System.out.println(resp == 10); // imprime true

    // Casos de Teste:
    System.out.println(mmc(10, 4) == 20);
    System.out.println(mmc(29, 11) == 319);
    // Excepcionais
    System.out.println(mmc(-2, 9) == 18);
    System.out.println(mmc(-2, -9) == 18);
    System.out.println(mmc(-8823, 9982) == 88071186);
    // Compostos
    System.out.println(mmc(mmc(2, 9), 11) == 198);
    System.out.println(mmc(mmc(mmc(2, 9), 11), 17) == 3366);
    // Sobrecarga para até quatro parâmetros/argumentos
    System.out.println(mmc(5, 8, 91) == 3640);
    System.out.println(mmc(5, 8, 91, 101) == 367640);
    // Adicione mais 2 Casos de Teste:
System.out.println(mmc(-1, 1, -1, 1) == 1);
System.out.println(mmc(-2, 1, 9, 8) == 72);
  }
}
