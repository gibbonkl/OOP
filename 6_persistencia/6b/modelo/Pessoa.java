package modelo;

import java.time.LocalDate;

import modelo.Pessoa.EstadoCivil;
import modelo.Pessoa.Genero;

public abstract class Pessoa {

	public enum EstadoCivil {
		Solteiro, Casado, Divorciado, Viuvo, Separado;
	}

	public enum Genero {
		Feminino("f"), Masculino("m"), NaoBinario("n");

		public final String LETRA;

		Genero(String l) {
			this.LETRA = l;
		}

		public static Genero fromString(String str) {
			if (str == null)
				return null;
			char c = str.toLowerCase().charAt(0); // f, m, n
			switch (c) {
			case 'f':
				return Genero.Feminino;
			case 'm':
				return Genero.Masculino;
			case 'n':
				return Genero.NaoBinario;
			}
			return null;
		}
	}

	// mapeamento objeto/relacional
	protected Integer id = null; // int
	protected String nome; // varchar
	protected LocalDate dataNascimento;
	protected EstadoCivil estadoCivil;
	protected Genero genero;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	@Override
	public abstract String toString();
}
