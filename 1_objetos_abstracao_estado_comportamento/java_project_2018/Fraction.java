class Fraction {

  public static void main(String[] args) {
    // Caminho Feliz
Fracao f1 = new Fracao(1, 5);
System.out.println(f1.numerador); // 1
System.out.println(f1.numerador == 1);
System.out.println(f1.denominador); // 5
System.out.println(f1.denominador == 5);

Fracao f2 = new Fracao(1, 5);
System.out.println(f2.numerador == 1);
System.out.println(f2.denominador == 5);

f2.mais(2, 5); // +2/5
System.out.println(f2.numerador == 3);
System.out.println(f2.denominador == 5);

f2.mais(f1.numerador, f2.denominador);
System.out.println(f2.numerador == 4);
System.out.println(f2.denominador == 5);

Fracao f3 = new Fracao(3, 7);
System.out.println(f3.numerador == 3);
System.out.println(f3.denominador == 7);

f3.mais(f2.numerador, f2.denominador);
System.out.println(f3.numerador == 43);
System.out.println(f3.denominador == 35);

// Começando com as alternativas
Fracao f4 = new Fracao(6); // denominador padrão 1
System.out.println(f4.numerador == 6);
System.out.println(f4.denominador == 1);

Fracao f5 = new Fracao(); // numerador padrão 0
System.out.println(f5.numerador == 0);
System.out.println(f5.denominador == 1);

// Fração inválida
// denominador 0 deve lançar IllegalArgumentException
//Fracao f6 = new Fracao(2, 0); // deve quebrar aqui
//System.out.println(f6.denominador == 0); // não deve chegar aqui
// comente as linhas após fazer quebrar

// Operações não suportadas
// não lidaremos com frações negativas
// deve lançar UnsupportedOperationException
//Fracao f7 = new Fracao(2, -5);
//Fracao f8 = new Fracao(-2, 5);
//Fracao f9 = new Fracao(-2, -5);
// comente as linhas após fazer quebrar

// desafio: especificar e implementar as outras operações (opcional)

  }
}
