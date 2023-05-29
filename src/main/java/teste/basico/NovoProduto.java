package teste.basico;

import infra.DAO;
import modelo.basico.Produto;

public class NovoProduto {
    public static void main(String[] args) {

        DAO<Produto> dao = new DAO<>(Produto.class);

        //Produto prod = new Produto("Caneta", 7.45);
        //dao.abrirT().incluir(prod).fecharT().fechar();

        Produto prod2 = new Produto("mouse", 299.9);
        dao.incluirAll(prod2).fechar();

    }
}
