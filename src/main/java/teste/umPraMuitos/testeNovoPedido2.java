package teste.umPraMuitos;

import infra.DAO;
import modelo.umPraMuitos.ItemPedido;
import modelo.umPraMuitos.Pedido;
import modelo.umPraMuitos.ProdutoUmPMuitos;

/**
 * Classe de teste para criar um novo pedido com um item associado a um produto existente.
 */
public class testeNovoPedido2 {
    public static void main(String[] args) {

        DAO<ProdutoUmPMuitos> daoProd = new DAO<>(ProdutoUmPMuitos.class);
        // Obtém um produto existente pelo seu ID
        ProdutoUmPMuitos prodTesteId = daoProd.obterPorID(11L);
        daoProd.fechar();

        DAO<Object> dao = new DAO<>();
        Pedido pedido = new Pedido();
        // Cria um novo item de pedido associado ao produto obtido
        ItemPedido item = new ItemPedido(pedido, prodTesteId, prodTesteId.getId(), 12);

        dao.abrirT()
                .incluir(pedido)
                .incluir(item)
                .fecharT()
                .fechar();

    }
}
