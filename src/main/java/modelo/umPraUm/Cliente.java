package modelo.umPraUm;

import javax.persistence.*;

/**
 * Classe que representa um cliente em um sistema de reservas.
 */
@Entity
@Table(name = "Clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único do cliente

    private String nome; // Nome do cliente

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "assento_id", unique = true)
    private Assento assento; // Assento associado ao cliente

    /**
     * Construtor padrão da classe Cliente.
     */
    public Cliente() { }

    /**
     * Construtor da classe Cliente que permite definir o nome do cliente e o assento associado.
     *
     * @param nome o nome do cliente.
     * @param assento o assento associado ao cliente.
     */
    public Cliente(String nome, Assento assento) {
        super();
        this.nome = nome;
        this.assento = assento;
    }

    /**
     * Obtém o ID do cliente.
     *
     * @return o ID do cliente.
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o ID do cliente.
     *
     * @param id o ID do cliente.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtém o nome do cliente.
     *
     * @return o nome do cliente.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do cliente.
     *
     * @param nome o nome do cliente.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o assento associado ao cliente.
     *
     * @return o assento associado ao cliente.
     */
    public Assento getAssento() {
        return assento;
    }

    /**
     * Define o assento associado ao cliente.
     *
     * @param assento o assento associado ao cliente.
     */
    public void setAssento(Assento assento) {
        this.assento = assento;
    }
}
