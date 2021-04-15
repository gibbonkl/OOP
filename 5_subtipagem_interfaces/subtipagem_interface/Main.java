package subtipagem_interface;

public class Main {

	public static void main(String[] args) {

		RetornoDialogo printaEsseCPFae = new RetornoDialogo();
		DialogoEntradaDado dialogoCPF = new DialogoEntradaDado(new CPF());
		dialogoCPF.quandoOk(printaEsseCPFae);
		dialogoCPF.mostra();

		RetornoDialogo printaOCEPaeRapaz = new RetornoDialogo();
		DialogoEntradaDado dialogoCEP = new DialogoEntradaDado(new CEP());
		dialogoCEP.quandoOk(printaOCEPaeRapaz);
		dialogoCEP.mostra();

		RetornoDialogo prinTE = new RetornoDialogo();
		DialogoEntradaDado dialogoTE = new DialogoEntradaDado(new TituloEleitor());
		dialogoTE.quandoOk(prinTE);
		dialogoTE.mostra();

		RetornoDialogo prinTPlaca = new RetornoDialogo();
		DialogoEntradaDado dialogoPlaca = new DialogoEntradaDado(new Placa());
		dialogoPlaca.quandoOk(prinTPlaca);
		dialogoPlaca.mostra();

		RetornoDialogo prinTData = new RetornoDialogo();
		DialogoEntradaDado dialogoData = new DialogoEntradaDado(new Data());
		dialogoData.quandoOk(prinTData);
		dialogoData.mostra();

		RetornoDialogo prinTHora = new RetornoDialogo();
		DialogoEntradaDado dialogoHora = new DialogoEntradaDado(new Hora());
		dialogoHora.quandoOk(prinTHora);
		dialogoHora.mostra();
	}
}
