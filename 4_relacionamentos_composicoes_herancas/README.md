# Relacionamentos: composições e heranças

_Classroom link:_ <https://classroom.github.com/a/QNsSA3v3>

## Modelar e implementar respeitando os princípios de Orientação a Objetos

#### Assuntos

- composições de objetos (tem, pertence a)
- herança, super e subtipagem (é um, é uma)

#### Prazo: 2018-11-04 Peso: 1.0 pt

**Regras**

* Não podem ser usadas as bibliotecas do Java, por exemplo, a classe `Math`, `Scanner`, etc, inclusive os métodos de Integer, como `parseInt` ou métodos de String, EXCETO `length`, `charAt` e `equals`;
* Os Casos de Teste podem ser corrigidos, mas a especificação não pode ser alterada;
* É recomendado o uso da IDE Eclipse, mas não obrigatório. Caso utilizada, apenas o conteúdo da pasta `src` deve ser _upado_, não enviar o projeto ou _workspace_ inteiro;
* Podem ser usadas as classes feitas nos trabalhos anteriores ou em aula, como `Bag`, `List`, etc;
* Prazo até 04 de novembro, domingo, com _permission granted to **burn the midnight oil**_.



### Implementar Sistema de Cadastro de Eventos/Atividades  (0.5 pts)

Implementar conforme os Casos de Teste.

```java
// Eventos tem um nome, cidade e tipo
Evento ev1 = new Evento("Semana Acadêmica IFRS", "Rio Grande", Evento.Tipo.Semana);

// atividades tem vagas e carga horária opcionais
Atividade atv1 = ev1.novaAtividade("Seminário TCCs TADS", 40, Atividade.Tipo.Seminario);
Atividade atv2 = ev1.novaAtividade("Minicurso ECMA6", 20, 8, Atividade.Tipo.Minicurso);

// dados do evento
System.out.println(ev1.getNome().equals("Semana Acadêmica IFRS"));
System.out.println(ev1.getTipo() == Evento.Tipo.Semana);
System.out.println(ev1.getCidade().equals("Rio Grande"));

// evento tem atividades
Atividade[] atvs = ev1.getAtividades();
System.out.println(atvs.length == 2);
System.out.println(atvs[0] == atv1);
System.out.println(atvs[1] == atv2);

// dados das atividades
System.out.println(atv1.getDescricao().equals("Seminário TCCs TADS"));
System.out.println(atv1.getVagas() == 40);
System.out.println(atv1.getTipo() == Atividade.Tipo.Seminario);

// o minicurso tem carga horária
System.out.println(atv2.getDescricao().equals("Minicurso ECMA6"));
System.out.println(atv2.getVagas() == 20);
System.out.println(atv2.getHoras() == 8);
System.out.println(atv2.getTipo() == Atividade.Tipo.Minicurso);

// atividades pertencem a um evento
System.out.println(atv1.getEvento() == ev1);
System.out.println(atv2.getEvento() == ev1);

// outros tipo de eventos e atividades
Evento ev2 = new Evento("Escola Regional de Banco de Dados", "Bagé", Evento.Tipo.Escola);
Atividade atv3 = ev2.novaAtividade("BigData com Apache Hadoop", "Paulo Silva", 20, 4, Atividade.Tipo.Oficina);
Atividade atv4 = ev2.novaAtividade("Data Science: uma introdução", "Maria Santos", Atividade.Tipo.Palestra);

// dados da atividade:
System.out.println(atv3.getDescricao().equals("BigData com Apache Hadoop"));
System.out.println(atv3.getMinistrante().equals("Paulo Silva"));
System.out.println(atv3.getVagas() == 20);
System.out.println(atv3.getHoras() == 4);
System.out.println(atv3.getTipo() == Atividade.Tipo.Oficina);

// um evento que abriga (tem) outros eventos:
Evento ev3 = new Evento("3º Salão de Pesquisa, Extensão e Ensino do IFRS", "Bento Gonçalves", Evento.Tipo.Salao);
EventoSatelite sat1 = ev3.novoEventoSatelite("7º Seminário de Iniciação Científica e Tecnológica (SICT)", Evento.Tipo.Seminario);
EventoSatelite sat2 = ev3.novoEventoSatelite("5º Seminário de Educação Profissional e Tecnológica (SEMEPT)", Evento.Tipo.Seminario);
EventoSatelite sat3 = ev3.novoEventoSatelite("Mostra de Arte e Cultura", Evento.Tipo.Mostra);

// eventos satélite são da mesma cidade do evento central
System.out.println(ev3.getCidade().equals("Bento Gonçalves"));
System.out.println(sat1.getCidade().equals(ev3.getCidade()));
System.out.println(sat1.getCidade().equals("Bento Gonçalves"));

// eventos satélites pertencem a um evento central
System.out.println(sat1.getEventoCentral() == ev3);
System.out.println(sat1.getEventoCentral().equals(ev3));

// satelites
System.out.println(ev3.getEventosSatelites().length == 3);
System.out.println(ev3.getEventosSatelites()[0] == sat1);
System.out.println(ev3.getEventosSatelites()[1] == sat2);
System.out.println(ev3.getEventosSatelites()[2] == sat3);

// inscrição nas atividades:
System.out.println(atv1.getVagas() == 40);
System.out.println(atv1.getVagasRemanescentes() == 40);

Inscrito insc1 = atv1.inscrever("Jean-Luc Picard");
Inscrito insc2 = atv1.inscrever("Worf");

// inscritos tem nome
System.out.println(insc1.getNome().equals("Jean-Luc Picard"));
System.out.println(insc2.toString().equals("Worf"));

// as vagas decrescem
System.out.println(atv1.getVagasRemanescentes() == 38);

// a inscrição tem uma chave no formato AAAAAAAAAAAAAAAA até ZZZZZZZZZZZZZZZZ
// aleatória, como: AGGASCFFEERERRER (use o Randomizer)
Chave insc1chave = insc1.getChave();
System.out.println(insc1.getChave().toString().length() == 16);
System.out.println(insc1.getChave().equals(insc2.getChave()) == false);

// verificando se a chave está segundo as regras:
for (int i = 0; i < insc1chave.toString().length; i++) {
  char c = insc1.getChave().toString().charAt(i);
  System.out.println(c >= 65 && c <= 90); // A~Z
}

// as chaves não podem ser as mesmas, cada inscrito deve ter uma chave única
System.out.println(insc1.getChave().equals(insc2.getChave()) == false);

// por padrão cada inscrito não concluiu a atividade
System.out.println(insc1.isConcluido() == false); // foi ao evento/atividade?

// a atvidade tem inscritos
Inscrito[] inscritos = atv1.getInscritos();
System.out.println(inscritos[0] == insc1);
System.out.println(inscritos[1] == insc2);
System.out.println(atv1.getInscritos()[1].isConcluido() == false);

// que confirmam presença (chamada)
insc1.confirmarPresenca(); // marcar como concluído
System.out.println(insc1.isConcluido() == true);

// inscrevendo 38 klingons
for (int i = 0; i < 38; i++) atv1.inscrever("Klingon #" + i);

// atividade sem vagas abertas
System.out.println(atv1.getVagasRemanescentes() == 0);

// não é possível inscrever-se
try {
  atv1.inscrever("Data");
  System.out.println(false);
} catch (NaoHaVagaException e) {
  System.err.println(true + " " + e);
}

// eventos satélite permitem inscrição
sat1.inscrever("Geordi Laforge");

// eles não tem limite de inscritos
// e tem todas as propriedades que um inscrito em atividade
System.out.println(sat1.getInscritos()[0].getNome().equals("Geordi Laforge"));
Inscrito insc3 = sat1.getInscritos()[0];
Chave chave3 = insc3.getChave();
System.out.println(insc3 != null);
System.out.println(chave3 != null);
System.out.println(sat1.getQuantidadeInscritos() == 1);
// esta atividade não tem limite de vagas nem carga horária
System.out.println(atv4.getVagas() == 0);
System.out.println(atv4.getHoras() == 0);
System.out.println(atv4.getVagasRemanescentes() == 0);
System.out.println(atv4.getTipo() == Atividade.Tipo.Palestra);
// então não há limite de inscrições
atv4.inscrever("Beverly Crusher");
atv4.inscrever("Deanna Troi");
System.out.println(atv4.getInscritos().length == 2);
System.out.println(atv4.getQuantidadeInscritos() == 2);
```



### Substituir os enumerados de `Tipo` evento/atividade por subtipagem (0.5 pts)

Com base na atividade anterior, refatorar para eliminar os `enum`s de tipo usando subclassificação adequando os Casos de Teste.

* * *

> A good programmer looks both ways before crossing a one-way street.
>
> -- Unknown
