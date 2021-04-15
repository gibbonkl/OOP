package modelo;

public class Professor extends Pessoa {

	public enum NiveldeGraduacao {
		graduado, mestre, doutor;
	}

	protected NiveldeGraduacao niveldeGraduacao;

	public NiveldeGraduacao getNiveldeGraduacao() {
		return niveldeGraduacao;
	}

	public void setNiveldeGraduacao(NiveldeGraduacao nivel) {
		this.niveldeGraduacao = nivel;
	}

	@Override
	public String toString() {

		return "Professor [id=" + id + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", estadoCivil="
				+ estadoCivil + ", genero=" + genero + ", niveldeGraduacao=" + niveldeGraduacao + "]";
	}

}
