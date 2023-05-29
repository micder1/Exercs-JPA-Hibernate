package teste.umPraMuitos;

import infra.DAO;
import modelo.umPraMuitos.ProdutoUmPMuitos;

/**
 * Classe de teste para adicionar um novo produto.
 */
public class NovoProduto2 {
    public static void main(String[] args) {

        DAO<ProdutoUmPMuitos> dao = new DAO<>(ProdutoUmPMuitos.class);

        ProdutoUmPMuitos prod = new ProdutoUmPMuitos("memoria ram", 380.9);

        // Inclui o novo produto no banco de dados e fecha a conexão com o DAO.
        dao.incluirAll(prod).fechar();
    }
}
