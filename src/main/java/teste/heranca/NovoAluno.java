package teste.heranca;

import infra.DAO;
import modelo.heranca.Aluno;
import modelo.heranca.AlunoBolsista;

public class NovoAluno {
    public static void main(String[] args) {
        DAO<Aluno> daoAluno = new DAO<>();

        Aluno alunoN = new Aluno(123L, "Joao");
        AlunoBolsista alunoB = new AlunoBolsista(456L, "Marcos", 700);

        daoAluno.incluirAll(alunoB);
        daoAluno.incluirAll(alunoN);

        daoAluno.fechar();
    }
}
