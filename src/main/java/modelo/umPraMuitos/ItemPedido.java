package modelo.umPraMuitos;

import javax.persistence.*;

/**
 * Classe que representa um item de pedido.
 */
@Entity
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Pedido pedido;

    @ManyToOne(fetch = FetchType.EAGER) // O valor padrão de fetch para ...ToOne é EAGER
    @JoinColumn(name = "prod_id", insertable = false, updatable = false)
    private ProdutoUmPMuitos prod;

    @Column(name = "prod_id")
    private Long prodID;

    @Column(nullable = false)
    private int qtd;

    @Column
    private Double preco;

    public ItemPedido() {
    }

    /**
     * Construtor para criar um novo item de pedido.
     *
     * @param pedido O pedido ao qual o item pertence.
     * @param prod O produto associado ao item.
     * @param qtd A quantidade do produto no item.
     */
    public ItemPedido(Pedido pedido, ProdutoUmPMuitos prod, int qtd) {
        super();
        this.setPedido(pedido);
        this.setProd(prod);
        this.setQtd(qtd);
        this.setPreco(prod.getPreco());
    }

    /**
     * Construtor para criar um novo item de pedido usando o ID do produto.
     *
     * @param pedido O pedido ao qual o item pertence.
     * @param prodID O ID do produto associado ao item.
     * @param qtd A quantidade do produto no item.
     */

//    public ItemPedido(Pedido pedido, Long prodID, int qtd) {
//        super();
//        this.setPedido(pedido);
//        this.setProdID(prodID);
//        this.setQtd(qtd);
//        this.setPreco(99.9);
//    }

    /**
     * Construtor para criar um novo item de pedido com todos os parâmetros.
     *
     * @param pedido O pedido ao qual o item pertence.
     * @param prod O produto associado ao item.
     * @param prodID O ID do produto associado ao item.
     * @param qtd A quantidade do produto no item.
     */
    public ItemPedido(Pedido pedido, ProdutoUmPMuitos prod, Long prodID, int qtd) {
        super();
        this.setPedido(pedido);
        this.setProd(prod);
        this.setProdID(prod.getId());
        this.setQtd(qtd);
        this.setPreco(prod.getPreco());
    }

    /**
     * Construtor para criar um novo item de pedido com o ID.
     *
     * @param id O ID do item de pedido.
     */
    public ItemPedido(Long id) {
        this.id = id;
    }

    public Long getProdID() {
        return prodID;
    }

    public void setProdID(Long prodID) {
        this.prodID = prodID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public ProdutoUmPMuitos getProd() {
        return prod;
    }

    public void setProd(ProdutoUmPMuitos prod) {
        this.prod = prod;

        if (prod != null && this.preco == null) this.setPreco(prod.getPreco());
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
