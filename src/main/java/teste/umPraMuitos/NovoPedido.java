package teste.umPraMuitos;

import infra.DAO;
import modelo.umPraMuitos.ItemPedido;
import modelo.umPraMuitos.Pedido;
import modelo.umPraMuitos.ProdutoUmPMuitos;

/**
 * Classe de teste para criar um novo pedido com um item.
 */
public class NovoPedido {
    public static void main(String[] args) {

        DAO<Object> dao = new DAO<>();

        ProdutoUmPMuitos prod = new ProdutoUmPMuitos("monitor", 650.9);
        Pedido pedido = new Pedido();
        ItemPedido item = new ItemPedido(pedido, prod, 2);

        // Abre a transação, inclui o produto, o pedido e o item no banco de dados e fecha a transação e o DAO.
        dao.abrirT()
                .incluir(prod)
                .incluir(pedido)
                .incluir(item)
                .fecharT()
                .fechar();

    }
}
