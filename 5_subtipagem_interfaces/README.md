# Subtipagem e Interfaces

_Classroom link:_ <https://classroom.github.com/a/VRJ4i8wI>

![Mindblowing](http://pa1.narvii.com/6570/6a8a49cf81150727244ffc9cdd1110f24ac535d2_00.gif)

## Tornar uma solução concreta e redundante em abstrata e concisa

#### Assuntos

- subtipagem
- abstração
- interfaces
- contratos

#### Prazo: 2018-12-02 Peso: 0.7 pt

**Regras**

* A biblioteca padrão (API) do Java está liberada;
* É recomendado o uso da IDE Eclipse, mas não obrigatório. Caso utilizada, apenas o conteúdo da pasta `src` deve ser _upado_, não enviar o projeto ou _workspace_ inteiro;
* Prazo até 02 de dezembro, domingo, com _permission granted to **burn the midnight oil**_.

### Abstrair a seguinte solução (0.7 pts)

O seguinte programa foi criado para exibir caixas de diálogo onde o usuário pode entrar com dados numéricos. A princípio o objetivo era permitir a informação do CPF. Depois foi necessário o CEP e para realizá-lo foi reproduzido (duplicado) o código de CPF para CEP.

Sabendo que futuramente poderão vir outros dados numéricos, como Título de Eleitor, RG, Matrícula, etc, como criar uma solução abstrata suficiente a ponto de permitir futuras informações numéricas? (NÍVEL 1/Normal/0.7)

Esta atividade deve ser **solucionada obrigatoriamente com interfaces**, podendo ter adicionalmente superclasses abstratas ou não. Os códigos iniciais estão no diretório cobaia, copie-o para o `src` do seu projeto e elabore a solução a partir desses códigos.

A qualidade da solução está em não mencionar os dados concretos nos diálogos ou retornos destes. Assim, a introdução de novos tipos de dados não implicará mudanças nos diálogos.

```java
class Main {
  public static void main(String[] args) {
    RetornoDialogoCPF printaEsseCPFae = new RetornoDialogoCPF();
    DialogoEntradaDadoNumericoCPF dialogoCPF = new DialogoEntradaDadoNumericoCPF();
    dialogoCPF.quandoOk(printaEsseCPFae);
    dialogoCPF.mostra();

    RetornoDialogoCEP printaOCEPaeRapaz = new RetornoDialogoCEP();
    DialogoEntradaDadoNumericoCEP dialogoCEP = new DialogoEntradaDadoNumericoCEP();
    dialogoCEP.quandoOk(printaOCEPaeRapaz);
    dialogoCEP.mostra();
  }
}
```

**Desafio: E se** os dados futuros forem placas, datas e horas? Eles não seriam dados totalmente numéricos, embora respeitem um formato. Então como criar uma solução abstrata para qualquer tipo de dado? (NÍVEL 2/Hard/+0.3 extras)

* * *

Interfaces são _mindblowing_, eu sei, mas ...

> _"The mind, once expanded to the
> dimensions of larger ideas,
> never returns to its original size"_
>
> -- Oliver Wendell Holmes, Sr.
