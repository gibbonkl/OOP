# Domínio, relacionamento entre objetos, coesão e estrutura de dados

_Classroom link:_ <https://classroom.github.com/a/dkmD6RWV>

## Modelar e implementar respeitando os princípios de Orientação a Objetos

[Sendo que seus braços me pertencem agora ...](http://youtu.be/JOCe0isg_1E)

#### Assuntos

- domínio, [lógica de negócio](https://www.google.com/search?q=business+logic)
- relacionamentos, agregação e composição de objetos
- coesão
- estrutura de dados (lista)

#### Prazo: 2018-10-14 Peso: 1.7 pt

**Regras**

* Não podem ser usadas as bibliotecas do Java, por exemplo, a classe `Math`, `Scanner`, etc, inclusive os métodos de Integer, como `parseInt` ou métodos de String, EXCETO `length`, `charAt` e `equals`;
* Os Casos de Teste podem ser corrigidos, mas a especificação não pode ser alterada;
* É recomendado o uso da IDE Eclipse, mas não obrigatório. Caso utilizada, apenas o conteúdo da pasta `src` deve ser _upado_, não enviar o projeto ou _workspace_ inteiro;
* Prazo até 14 de outubro, domingo, com _permission granted to **burn the midnight oil**_.

### Implementar lista dinâmica (0.5 pts)

Esta atividade serve para implementar uma estrutura necessária para facilitar as agregações e composições.

Como os _arrays_ (vetores) têm tamanho fixo, precisamos de outra estrutura da dados, uma que aceite um número variável de elementos, neste caso, uma **Lista**.

Existem [várias formas de implementar uma Lista](http://en.wikipedia.org/wiki/List_of_data_structures#Lists), por exemplo, as listas com nós conectados (conhecidas como _linked lists_), mas para esta atividade utilizaremos uma **lista baseada em vetores** (também conhecidas como _array list_).

Então, o objetivo é construir uma **Lista** que guarde seu estado (elementos, por exemplo) em um **vetor** (_array_), que aceite **qualquer tipo de objeto** (parâmetros do tipo `Object`), sejam eles _strings_, inteiros, etc.

**Importante:** o vetor interno deve começar pequeno, isto é, com poucas posições, e então crescer sempre que ficar _"cheio"_, deixando algumas posições vazias no fim (sugere-se dobrar de tamanho). Tu podes fazer isso manualmente, criando um novo vetor maior e copiando os elementos para ele, ou usando um método da API de _arrays_ do Java, **permitido para esta atividade** (ver: _arrays copy_ ou _system array copy_).

A seguir os Casos de Teste:
```java
// Main.java, main method
List lista = new List();
// lista vazia
System.out.println(lista.count() == 0);
System.out.println(lista.isEmpty() == true);
System.out.println(lista.get(0) == null);
// adicionando elemento no fim
lista.append("a");
// lista tem um elemento
System.out.println(lista.isEmpty() == false);
System.out.println(lista.count() == 1);
System.out.println(lista.get(0).equals("a"));
// adicionando mais 4 elementos
lista.append(2);
lista.append("c");
lista.append("d");
lista.append("e");
// lista tem 5 elementos
System.out.println(lista.count() == 5);
// descobrindo o índice
System.out.println(lista.indexOf("a") == 0);
System.out.println(lista.indexOf(2) == 1);
System.out.println(lista.indexOf("e") == 4);
System.out.println(lista.indexOf("f") == -1);
System.out.println(lista.indexOf(3) == -1);
// índices
System.out.println(lista.get(1).equals(2));
System.out.println(lista.get(2).equals("c"));
// índice fora do tamanho retorna null
System.out.println(lista.get(5) == null);
// perguntando se há um elemento
System.out.println(lista.has("a") == true);
System.out.println(lista.has(3) == false);
System.out.println(lista.has("f") == false);
System.out.println(lista.has(2) == true);
// consultas não fazem alteração
System.out.println(lista.count() == 5);
// nulos não podem ser adicionados
lista.append(null);
System.out.println(lista.count() == 5);
// se um elemento for eliminado com sucesso: true, senão: false
// delete é por índice
System.out.println(lista.delete(1) == true); // eliminando o item 1
System.out.println(lista.delete(9) == false);
// agora a lista tem 4 elementos
System.out.println(lista.count() == 4);
// que são estes
System.out.println(lista.get(0).equals("a"));
System.out.println(lista.get(1).equals("c"));
System.out.println(lista.get(2).equals("d"));
System.out.println(lista.get(3).equals("e"));
// eliminando mais um
System.out.println(lista.delete(2) == true);
// agora são 3
System.out.println(lista.count() == 3);
// pode ser usado o remover que recebe um objeto
// remove é por objeto
System.out.println(lista.remove("c") == true); // se encontrado, e removido, true
// agora tem 2
System.out.println(lista.count() == 2);
System.out.println(lista.get(0).equals("a"));
System.out.println(lista.get(1).equals("e"));
// reset reinicia a lista (zera tudo)
lista.reset();
// tudo zerado
System.out.println(lista.count() == 0);
System.out.println(lista.isEmpty() == true);
System.out.println(lista.get(0) == null);
// adicionando 2
lista.append("Chell");
lista.append("Alucard");
// tem 2
System.out.println(lista.count() == 2);
System.out.println(lista.isEmpty() == false);
System.out.println(lista.get(0).equals("Chell"));
System.out.println(lista.get(1).equals("Alucard"));
// prepend adiciona no começo da lista
lista.prepend("Sagat");
// tem 3
System.out.println(lista.count() == 3);
System.out.println(lista.get(0).equals("Sagat"));
System.out.println(lista.get(1).equals("Chell"));
System.out.println(lista.get(2).equals("Alucard"));
// insert coloca numa posição específica
lista.insert("Claire Redfield", 1); // índice 1
// tem 4
System.out.println(lista.count() == 4);
// Claire é o índice 1
System.out.println(lista.get(0).equals("Sagat"));
System.out.println(lista.get(1).equals("Claire Redfield"));
System.out.println(lista.get(2).equals("Chell"));
System.out.println(lista.get(3).equals("Alucard"));
// não pode inserir em índices não existentes
lista.insert("Zelda", -1);
lista.insert("Zelda", 5);
// foram negados
System.out.println(lista.count() == 4);
// mas inserir no fim pode!
lista.insert("Zelda", 4);
// final, 5 elementos, Zelda é o quinto
System.out.println(lista.count() == 5);
System.out.println(lista.get(0).equals("Sagat"));
System.out.println(lista.get(1).equals("Claire Redfield"));
System.out.println(lista.get(2).equals("Chell"));
System.out.println(lista.get(3).equals("Alucard"));
System.out.println(lista.get(4).equals("Zelda"));
```

### Implementar o modelo planejado para compras de passagens intermunicipais (0.4)

Implementar conforme os Casos de Teste.

```java
Rodoviaria rod = new Rodoviaria("Rio Grande");
// empresa
Empresa embaixador = new Empresa("Expresso embaixador");
Frota frotaEmbaixador = embaixador.getFrota();
System.out.println(frotaEmbaixador.getQuantidade() == 0);
Onibus oni1 frotaEmbaixador.novoOnibus(1104, 44); // nro onibus, assentos
// direto
System.out.println(frotaEmbaixador.getQuantidade() == 1);
// ou indireto
System.out.println(embaixador.getFrota().getQuantidade() == 1);
// viagem
Viagem vi1 = rod.criarViagem("Pelotas", new Date(13, 10, 2018), new Time(14), oni1);
System.out.println(vi1.getCodigo() == 1);
System.out.println(vi1.getOrigem().equals("Rio Grande"));
System.out.println(vi1.getDestino().equals("Pelotas"));
System.out.println(vi1.getData().toString().equals("13/10/2018"));
System.out.println(vi1.getHora().toString().equals("14:00:00"));
System.out.println(vi1.getTotalPassagens() == 44); // qtd assentos onibus
System.out.println(vi1.getTotalPassagensDisponiveis() == 44); // qtd assentos disp
// comprando uma passagem a partir da viagem
Passagem pas1 = vi1.comprarPassagem(13); // nro assento
// codigo viagem 1 + nro pass 1 + assento 13
System.out.println(pas1.getCodigo().equals("000001.000001.13"));
System.out.println(pas1.isDisponivel() == false);
System.out.println(pas1.getAssento() == 13);
// obtendo as passagens
Passagem[] pass = vi1.getPassagens();
System.out.println(pass[0].getAssento() == 1);
System.out.println(pass[0].isDisponivel() == true);
pass[0].comprar();
System.out.println(pass[0].getAssento() == 1);
System.out.println(pass[0].isDisponivel() == false);
System.out.println(pass[0].getCodigo().equals("000001.000002.01"));
System.out.println(vi1.getTotalPassagensDisponiveis() == 42); // qtd assentos disp
// adicionando um onibus à frota a partir da empresa
embaixador.novoOnibus(1205, 48);
// nova rodoviária
Rodoviaria rod2 = new Rodoviaria("Bagé");
rod2.criarViagem("Jaguarão", new Date(14, 10, 2018), new Time(8, 30),
                 embaixador.getFrota().getOnibus(1205));
System.out.println(rod2.getViagem(2).getDestino().equals("Jaguarão"));
System.out.println(rod2.getViagem(2).comprarPassagem(9).getCodigo().equals("000002.000001.09"));
// comprar passagem
Passagem pas2 = rod2.comprarPassagem(2, 10); // comprar passagem viagem 2 assento 10
System.out.println(pas2.getCodigo().equals("000002.000002.10"));
Viagem vi2 = rod2.getViagem();
try {
  vi2.comprarPassagem(10);
} catch (AssentoIndisponivelException e) {
  System.err.println(e);
}
// passagens remanescentes
System.out.println(vi2.getTotalPassagens() == 48); // qtd assentos onibus
System.out.println(vi2.getTotalPassagensDisponiveis() == 46); // qtd assentos disp

// ADICIONAR CASOS DE TESTE PARA PELO MENOS 2 SITUAÇÕES EXCEPCIONAISS
```

### Atividade Teórica: Information expert (Especialista na informação) (0.3 pts)

Entre os princípios GRASP (General Reponsibility Assignment Principles) está o _Information Expert_, usado nas decisões a respeito da distribuição das funcionalidades (métodos) entre as classes. Obter o livro na biblioteca ou fazê-lo como consulta local, ler sobre o tópico e escrever uma resenha, junto com um exemplo que viola esse principío e um que respeita. Não são necessários casos de teste ou um exemplo totalmente funcional.

Obs.: esta pesquisa pode ser feita em dupla.

### Analisar, projetar e implementar o domínio de um sistema para aluguel de veículos (0.5 pts)

Deve funcionar como o Airbnb: o cidadão disponibiliza seu veículo para aluguel. Ver o funcionamento do [Airbnb](https://www.airbnb.com.br/) como referência, mas introduza regras específicas para veículos conforme as lojas de _rent a car_. Deve ser pensado como um aplicativo internacional.

Criar um diagrama de classes simples, escrever casos de teste e realizar a implementação.

Projetar e implementar observando a **coesão** e os princípios **creator** e **information expert** (ver GRASP).

Obs.: esta parte é sugerida que seja feita em dupla, chegando uma solução conjunta, depois cada um sobe no seu repositório a solução.

* * *

> Every great developer you know
> got there by solving problems
> they were unqualified to solve
> until they actually did it.
>
> -- Patrick McKenzie
