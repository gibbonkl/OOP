package cobaia;

public class Main {
  public static void main(String[] args) {
    
    RetornoDialogoCPF printaEsseCPFae = new RetornoDialogoCPF();
    DialogoEntradaDadoNumericoCPF dialogoCPF = new DialogoEntradaDadoNumericoCPF();
    dialogoCPF.quandoOk(printaEsseCPFae);
    dialogoCPF.mostra();
    
    RetornoDialogoCEP printaOCEPaeRapaz = new RetornoDialogoCEP();
    DialogoEntradaDadoNumericoCEP dialogoCEP = new DialogoEntradaDadoNumericoCEP();
    dialogoCEP.quandoOk(printaOCEPaeRapaz);
    dialogoCEP.mostra();
    /*
    RetornoDialogoTituloEleitor prinTE = new RetornoDialogoTituloEleitor();
    DialogoEntradaDadoNumericoTituloEleitor dialogoTE = new DialogoEntradaDadoNumericoTituloEleitor();
    dialogoTE.quandoOk(prinTE);
    dialogoTE.mostra();
    
    Desafios:
    * diálogo e retorno para qualquer dado numérico
    * diálogo e retorno para qualquer dado de qualquer tipo
    */
  }
}
