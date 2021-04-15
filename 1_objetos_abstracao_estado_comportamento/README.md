# Abstração, Estado e Comportamento

Classroom assignment <https://classroom.github.com/a/27jQ2W6Y>

## Modelar e implementar respeitando os princípios básicos de Orientação a Objetos

#### Assuntos

- classes (abstrações)
- [objetos](http://youtu.be/c9NaVWIRT0A?t=93)
- construtores
- sobrecarga
- validade
- exceções
- atributos (estado)
- mutabilidade
- métodos comando e consulta (comportamento)
- especificações

#### Prazo: 2018-09-02 Peso: 0.8 pts

**Restrição: não podem ser usadas as bibliotecas do Java, por exemplo, a classe `Math`, `Scanner`, etc, inclusive os métodos de Integer, como `parseInt` ou métodos de String, EXCETO `length`, `charAt` e `equals`; Os Casos de Teste podem ser corrigidos, mas a especificação não pode ser alterada.**

### Implementar Máquina D'água (0.2 pts)

Considere um máquina de água sofisticada. Ela é abastecida com uma Bombona de _20L_ e sempre que isso é feito um botão _abastecer água_ é pressionado, efetuando o _reset_ do contador para _20L_ (ou _20000mL_) disponíveis. A máquina também armazena internamente os copos descartáveis, de _200mL_ e _300mL_, com um repositório de 100 unidades para cada. Feito os abastecimentos, os usuários servem-se de água pressionando os botões que servem _200mL_ ou _300mL_. A máquina automaticamente saca um copo e o enche de água. A máquina mostra no painel a quantidade de água e copos disponíveis. Quando um botão _servir_ é pressionado e não há água ou copo, naturalmente o pedido não é atendido.

Dada esta especificação nosso analista projetou a seguinte interação conforme os Casos de Teste a seguir:
```java

MaquinaAgua maq = new MaquinaAgua();
System.out.println(maq.agua() == 0); // mL
System.out.println(maq.copos200() == 0);
System.out.println(maq.copos300() == 0);

maq.servirCopo200(); // não efetua

System.out.println(maq.agua() == 0); // mL
System.out.println(maq.copos200() == 0);
System.out.println(maq.copos300() == 0);

maq.abastecerAgua(); // inicializa 20000mL
System.out.println(maq.agua() == 20000); // mL

maq.abastecerAgua(); // mantém consistente
System.out.println(maq.agua() == 20000); // mL

maq.servirCopo200(); // não efetua, sem copo
System.out.println(maq.agua() == 20000); // mL

maq.abastecerCopo200(); // agora a máquina possui 100 copos de 200
System.out.println(maq.copos200() == 100);

// correção (A.K.A. PATCH!) =====================================
maq.servirCopo200();
maq.servirCopo200();
maq.servirCopo200();
maq.servirCopo200();
maq.servirCopo200(); // -1000ml e 5 copos de 200

System.out.println(maq.agua() == 19000);
System.out.println(maq.copos200() == 95);
System.out.println(maq.copos300() == 0);

maq.abastecerCopo200(); // agora a máquina possui 100 copos de 200 novamente
System.out.println(maq.copos200() == 100);

maq.servirCopo200(); // -200ml e 1 copo de 200
// fim correção =====================================

System.out.println(maq.agua() == 18800);
System.out.println(maq.copos200() == 99);
System.out.println(maq.copos300() == 0);

maq.abastecerCopo300(); // agora a máquina possui 100 copos de 300
System.out.println(maq.copos300() == 100);

maq.servirCopo300();
System.out.println(maq.agua() == 18500);
System.out.println(maq.copos200() == 99);
System.out.println(maq.copos300() == 99);

// servir 50 copos de 300 = 15000ml
for (int i = 0; i < 50; i++) maq.servirCopo300();

System.out.println(maq.agua() == 3500);
System.out.println(maq.copos200() == 99);
System.out.println(maq.copos300() == 49);

// servir 17 copos de 200 = 3400ml
for (int i = 0; i < 17; i++) maq.servirCopo200();

System.out.println(maq.agua() == 100);
System.out.println(maq.copos200() == 82);
System.out.println(maq.copos300() == 49);

// não há água para atender o pedido
maq.servirCopo300();

System.out.println(maq.agua() == 100);
System.out.println(maq.copos200() == 82);
System.out.println(maq.copos300() == 49);

// não há água para atender o pedido
maq.servirCopo200();

System.out.println(maq.agua() == 100);
System.out.println(maq.copos200() == 82);
System.out.println(maq.copos300() == 49);

maq.abastecerAgua(); // inicializa 20000mL

System.out.println(maq.agua() == 20000);
System.out.println(maq.copos200() == 82);
System.out.println(maq.copos300() == 49);

// servir os 49 copos de 300 restantes = 14700ml
while (maq.copos300() > 0) maq.servirCopo300();

System.out.println(maq.agua() == 5300);
System.out.println(maq.copos200() == 82);
System.out.println(maq.copos300() == 0);

// não há copo para atender o pedido
maq.servirCopo300();

System.out.println(maq.agua() == 5300);
System.out.println(maq.copos200() == 82);
System.out.println(maq.copos300() == 0);

maq.servirCopo200(); // de 200 ok
maq.servirCopo200(); // de 200 ok

System.out.println(maq.agua() == 4900);
System.out.println(maq.copos200() == 80);
System.out.println(maq.copos300() == 0);

maq.abastecerCopo300(); // 100 copos de 300

System.out.println(maq.agua() == 4900);
System.out.println(maq.copos200() == 80);
System.out.println(maq.copos300() == 100);

// 3 copos de 300
maq.servirCopo300(); maq.servirCopo300(); maq.servirCopo300();

System.out.println(maq.agua() == 4000);
System.out.println(maq.copos200() == 80);
System.out.println(maq.copos300() == 97);
```

### Implementar Fração (0.2)

Implemente o objeto `Fracao` conforme especificação.

Casos de Teste:
```java
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
Fracao f6 = new Fracao(2, 0); // deve quebrar aqui
System.out.println(f6.denominador == 0); // não deve chegar aqui
// comente as linhas após fazer quebrar

// Operações não suportadas
// não lidaremos com frações negativas
// deve lançar UnsupportedOperationException
Fracao f7 = new Fracao(2, -5);
Fracao f8 = new Fracao(-2, 5);
Fracao f9 = new Fracao(-2, -5);
// comente as linhas após fazer quebrar

// desafio: especificar e implementar as outras operações (opcional)
```

Sessão _remember_ <http://cdn.tristro.net/catalog/878/full/t38124-oper-fractions-16p.jpg>.

O que são frações? <https://pt.khanacademy.org/math/pre-algebra/fractions-pre-alg>

Como Oráculo considere usar o Wolfram Alpha em <https://www.wolframalpha.com/>. Use entradas como, por exemplo, `3/5 + 1/5` <https://www.wolframalpha.com/input/?i=3%2F5+%2B+1%2F5>


### Modelar e implementar TV (0.2 pts)

Considere um aparelho de televisão. Cada uma têm um fabricante, modelo, tamanho e resolução. Além disso, a operação da TV é bem simples, permitir aumentar e baixar o volume, numa escala de 0 a 100%, e mudar o canal, suportando as faixas VHF e UHF indo, então, de 2 a 69.

Dada essa especificação, modele, projete e implemente uma classe `TV`, que guarde as características mencionadas, respeitando a imutabilidade e os métodos comandos e consultas que representem as operações descritas. Escreva pelo menos 20 Casos de Teste, para situações comuns e excepcionais.

Desafio: implementar o _mudo_, _ir para canal_ e _voltar canal_ (não obrigatório).


### Especificar um Objeto (0.2 pts)

Escreva uma especificação textual descrevendo as características e operações de um objeto. Pode ser físico, tangível, como a TV e Caneta, ou não, como a Conta Corrente, Fração. Após, faça a especificação operacional escrevendo os casos de teste.

**Não é para implementar, só especificar.**

Espera-se alguns (mais de um) atributos e métodos comando e consulta. Escreva quantos testes forem necessários para cobrir o caminho feliz e as situações excepcionais, quebrando ou não, escolha sua.


* * *

> _"First, solve the problem.
> Then, write the code."_
>
> -- **John Johnson**
