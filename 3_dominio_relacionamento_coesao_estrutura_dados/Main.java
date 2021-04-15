
public class Main {
public static void main(String[] args) throws AssentoIndisponivelException, DataInvalidaException, AssentoInexistenteException {
	
	System.out.println("__________");
	System.out.println("LISTA");
	
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

	System.out.println("__________");
	System.out.println("RODOVIARIA");
	
	Rodoviaria rod = new Rodoviaria("Rio Grande");
	System.out.println(rod.getLocalidade().equals("Rio Grande"));
	System.out.println(rod.toString().equals("Rio Grande"));
	// empresa
	Empresa embaixador = new Empresa("Expresso embaixador");
	System.out.println(embaixador.getNome().equals("Expresso embaixador"));
	Frota frotaEmbaixador = embaixador.getFrota();
	System.out.println(frotaEmbaixador != null);
	System.out.println(frotaEmbaixador.getQuantidade() == 0);
	// nro onibus, assentos
	Onibus oni1 = frotaEmbaixador.novoOnibus(1104, 44);
	System.out.println(frotaEmbaixador.getQuantidade() == 1);
	System.out.println(embaixador.getFrota().getQuantidade() == 1);
	// viagem
	Viagem vi1 = rod.criarViagem("Pelotas", new Date(13, 10, 2018), new Time(14), oni1);
	System.out.println(vi1.getCodigo() == 1);
	System.out.println(vi1.getOrigem().equals("Rio Grande"));
	System.out.println(vi1.getDestino().equals("Pelotas"));
	System.out.println(vi1.getData().toString().equals("13/10/2018"));
	System.out.println(vi1.getHora().toString().equals("14:00:00"));
	// qtd assentos onibus
	System.out.println(vi1.getTotalPassagens() == 44);
	// qtd assentos disp
	System.out.println(vi1.getTotalPassagensDisponiveis() == 44);
	// comprando uma passagem a partir da viagem
	Passagem pas1 = vi1.comprarPassagem(13); // nro assento
	// codigo viagem 1 + nro pass 1 + assento 13
	System.out.println(pas1.getCodigo().equals("000001.000001.13"));
	System.out.println(pas1.isDisponivel() == false);
	System.out.println(pas1.getAssento() == 13);
	// obtendo as passagens
	Passagem[] todasPassagens = vi1.getPassagens();
	System.out.println(todasPassagens.length == 44); // não-nulas
	System.out.println(todasPassagens[0].getAssento() == 1); // assento - 1 = indice
	System.out.println(todasPassagens[0].isDisponivel() == true);
	todasPassagens[0].comprar();
	System.out.println(todasPassagens[0].getAssento() == 1);
	System.out.println(todasPassagens[0].isDisponivel() == false);
	//System.out.println(todasPassagens[0].getCodigo().equals("000001.000002.01"));
	//System.out.println(vi1.getTotalPassagensDisponiveis() == 42); // qtd assentos disp
	// adicionando um onibus à frota a partir da empresa
	embaixador.novoOnibus(1205, 48);


	// nova rodoviária / zerar os códigos de viagem
	Rodoviaria rod2 = new Rodoviaria("Bagé");
	System.out.println(rod2.getLocalidade().equals("Bagé"));
	rod2.criarViagem("Jaguarão", new Date(14, 10, 2018), new Time(8, 30),
	                 embaixador.getFrota().getOnibus(1205));
	System.out.println(rod2.getViagem(1).getDestino().equals("Jaguarão"));
	System.out.println(rod2.getViagem(1).getOrigem().equals("Bagé"));
	System.out.println(rod2.getViagem(1).comprarPassagem(9).getCodigo().equals("000001.000001.09"));
	// comprar passagem
	Passagem pas2 = rod2.comprarPassagem(1, 10); // comprar passagem viagem 1 assento 10
	System.out.println(pas2.getCodigo().equals("000001.000002.10"));
	Viagem vi2 = rod2.getViagem(1);
	System.out.println(vi2.getCodigo() == 1);
	try {
	  vi2.comprarPassagem(10);
	} catch (AssentoIndisponivelException e) {
	  System.err.println(e);
	}
	// passagens remanescentes
	System.out.println(vi2.getTotalPassagens() == 48); // qtd assentos onibus
	System.out.println(vi2.getTotalPassagensDisponiveis() == 46); // qtd assentos disp

	// ADICIONAR CASOS DE TESTE PARA PELO MENOS 2 SITUAÇÕES EXCEPCIONAIS
	
	try {
		rod2.criarViagem("Cidade", new Date(14, 10, 1990), new Time(8, 30),
	            embaixador.getFrota().getOnibus(1200));
		} catch (DataInvalidaException e) {
		  System.err.println(e);
		}
	
	try {
		  vi2.comprarPassagem(50);
		} catch (AssentoInexistenteException e) {
		  System.err.println(e);
		}	
	
	System.out.println("__________");
	
}
}
