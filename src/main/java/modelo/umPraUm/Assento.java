package modelo.umPraUm;

import javax.persistence.*;

/**
 * Classe que representa um assento em um sistema de reservas.
 */
@Entity
@Table(name = "Assentos")
public class Assento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único do assento

    private String nome; // Nome do assento

    @OneToOne(mappedBy = "assento")
    private Cliente cliente; // Cliente associado ao assento

    /**
     * Construtor padrão da classe Assento.
     */
    public Assento() { }

    /**
     * Construtor da classe Assento que permite definir o nome do assento.
     *
     * @param nome o nome do assento.
     */
    public Assento(String nome) {
        super();
        this.nome = nome;
    }

    /**
     * Obtém o ID do assento.
     *
     * @return o ID do assento.
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o ID do assento.
     *
     * @param id o ID do assento.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtém o nome do assento.
     *
     * @return o nome do assento.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do assento.
     *
     * @param nome o nome do assento.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o cliente associado ao assento.
     *
     * @return o cliente associado ao assento.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Define o cliente associado ao assento.
     *
     * @param cliente o cliente associado ao assento.
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}