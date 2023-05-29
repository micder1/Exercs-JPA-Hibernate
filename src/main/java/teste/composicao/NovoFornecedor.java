package teste.composicao;

import infra.DAO;
import modelo.composicao.Endereco;
import modelo.composicao.Fornecedor;

public class NovoFornecedor {
    public static void main(String[] args) {
        DAO<Fornecedor> daoFornecedor = new DAO<>(Fornecedor.class);

        Endereco end1 = new Endereco("rua Afonso Ferreira Gomes, 110", "ap 102");
        Fornecedor fornecedor1 = new Fornecedor("Joao", end1);
        Fornecedor fornecedor2 = new Fornecedor("maria", end1);

        daoFornecedor.incluirAll(fornecedor1);
        daoFornecedor.incluirAll(fornecedor2);

        daoFornecedor.fechar();

    }
}
