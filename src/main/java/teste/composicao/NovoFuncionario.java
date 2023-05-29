package teste.composicao;

import infra.DAO;
import modelo.composicao.Endereco;
import modelo.composicao.Fornecedor;
import modelo.composicao.Funcionario;

public class NovoFuncionario {
    public static void main(String[] args) {
        DAO<Funcionario> daoFuncionario = new DAO<>(Funcionario.class);

        Endereco end2 = new Endereco("rua Carlos Souza, 437", "casa B");
        Funcionario funcionario1 = new Funcionario("Marlon", end2);
        Funcionario funcionario2 = new Funcionario("Ana", end2);

        daoFuncionario.incluirAll(funcionario1);
        daoFuncionario.incluirAll(funcionario2);

        daoFuncionario.fechar();

    }
}
