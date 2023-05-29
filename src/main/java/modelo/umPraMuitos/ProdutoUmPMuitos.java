package modelo.umPraMuitos;

import javax.persistence.*;

/**
 * Classe que representa um produto.
 */
@Entity
public class ProdutoUmPMuitos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "prod_nome", length = 200)
    private String nome;

    @Column(name = "prod_preco", precision = 11, scale = 2)
    private Double preco;

    public ProdutoUmPMuitos() {
    }

    /**
     * Construtor para criar um novo produto com o nome e preço especificados.
     *
     * @param nome  O nome do produto.
     * @param preco O preço do produto.
     */
    public ProdutoUmPMuitos(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    /**
     * Construtor para criar um produto com um ID específico.
     *
     * @param id O ID do produto.
     */
    public ProdutoUmPMuitos(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
