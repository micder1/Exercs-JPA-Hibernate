package teste.umPraMuitos;

import infra.DAO;
import modelo.umPraMuitos.ItemPedido;
import modelo.umPraMuitos.Pedido;

/**
 * Classe de teste para obter um pedido e exibir seus itens.
 */
public class ObterPedido {
    public static void main(String[] args) {

        DAO<Pedido> dao = new DAO<>(Pedido.class);

        Pedido pedido = dao.obterPorID(10L);

        // Itera sobre os itens do pedido e exibe a quantidade e o nome do produto de cada item.
        for(ItemPedido item : pedido.getItens()){
            System.out.println(item.getQtd());
            System.out.println(item.getProd().getNome());
        }

        dao.fechar();
    }
}
