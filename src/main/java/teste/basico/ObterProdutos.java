package teste.basico;

import infra.ProdutoDAO;
import modelo.basico.Produto;

import java.util.List;

public class ObterProdutos {
    public static void main(String[] args) {

        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> listProdutos = dao.obterTodos();

        for(Produto p : listProdutos){
            System.out.println("id: " + p.getId() + ", nome: " + p.getNome());
        }

        double precoFinal = listProdutos
                .stream()
                .map(p -> p.getPreco())
                .reduce(0.0, (t, p) -> t + p)
                .doubleValue();

        System.out.println("Preço total do carrinho: " + precoFinal);

        dao.fecharT();
    }
}
