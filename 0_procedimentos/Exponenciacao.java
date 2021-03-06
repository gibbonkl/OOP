class Exponenciacao{

  static int potencia(int base,int expoente){
        int resp = 1;
      if (expoente==0) return resp;
      if (expoente>0) {
        while (expoente>0){
          resp = resp * base;
          expoente--;
        }
      }
      if (expoente<0){
        resp = 0;
      }
      return resp;
  }


  public static void main(String[] args) {
    // método potencia que entram dois inteiros e sai um inteiro
// potencia(int,int):int

int base = 3;
int expoente = 4;
int result = potencia(base, expoente);
System.out.println(result); // imprime 81
System.out.println(result == 81); // imprime true

// Casos de Teste:
System.out.print("potencia(3, 2) == 9 "); // 3 ao quadrado
System.out.println(potencia(3, 2) == 9); // 3 ao quadrado
System.out.print("potencia(2, 3) == 8 "); // 2 ao cubo
System.out.println(potencia(2, 3) == 8); // 2 ao cubo
// Números grandes
System.out.print("potencia(23, 6) == 148035889 ");
System.out.println(potencia(23, 6) == 148035889);
System.out.print("potencia(2, 30) == 1073741824 ");
System.out.println(potencia(2, 30) == 1073741824);
// Casos Especiais: bases negativas
System.out.print("potencia(-2, 3) == -8 ");
System.out.println(potencia(-2, 3) == -8);
System.out.print("potencia(-2, 4) == 16 ");
System.out.println(potencia(2, 4) == 16);
// Casos não cobertos: expoente negativo
System.out.print("potencia(2, -3) == 0 ");
System.out.println(potencia(2, -3) == 0);
System.out.print("potencia(7, -2) == 0 ");
System.out.println(potencia(7, -2) == 0);
// Adicione mais 2 Casos de Teste
System.out.print("potencia(10,0) == 1 ");
System.out.println(potencia(10,0) == 1);
System.out.print("potencia(0,2) == 0 ");
System.out.println(potencia(0,2) == 0);
  }
}
