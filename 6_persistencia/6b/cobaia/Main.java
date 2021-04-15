package cobaia;

import java.time.LocalDate;

import modelo.Aluno;
import modelo.Pessoa;
import modelo.Pessoa.EstadoCivil;
import modelo.Pessoa.Genero;
import modelo.Professor;
import modelo.Professor.NiveldeGraduacao;
import persistencia.AlunoDAO;
import persistencia.ProfessorDAO;

@SuppressWarnings("unused")
public class Main {
	public static void main(String[] args) {

		// ('k Gibbon', '1988-08-04', 0, 'f');
		Aluno a = new Aluno();
		a.setNome("k Gibbon");
		a.setDataNascimento(java.time.LocalDate.of(1988, 8, 04));
		a.setEstadoCivil(EstadoCivil.Solteiro);
		a.setGenero(Genero.Feminino);

		AlunoDAO dao1 = new AlunoDAO();
		dao1.insert(a);
		Aluno aluno = dao1.select(a.getId());
		System.out.println(aluno); // 1, k
		dao1.delete(a.getId());
		System.out.println(dao1.select(a.getId()) == null); // null

		// ('Marcio Torres', '1976-10-25', 1, 'm', 1)
		Professor p = new Professor();
		p.setNome("Marcio Torres");
		p.setDataNascimento(LocalDate.of(1976, 10, 25));
		p.setEstadoCivil(EstadoCivil.Casado);
		p.setGenero(Genero.Masculino);
		p.setNiveldeGraduacao(NiveldeGraduacao.mestre);

		ProfessorDAO dao2 = new ProfessorDAO();
		dao2.insert(p);
		Professor prof = dao2.select(p.getId());
		System.out.println(prof); // 1, marcio
		dao2.delete(p.getId());
		System.out.println(dao2.select(p.getId()) == null); // null

	}
}
