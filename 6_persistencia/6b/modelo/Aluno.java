package modelo;

public class Aluno extends Pessoa {

	@Override
	public String toString() {

		return "Aluno [id=" + id + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", estadoCivil="
				+ estadoCivil + ", genero=" + genero + "]";
	}

}