package modelo.muitosPraMuitos;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToMany
    private List<Sobrinho> listSobrinhos = new ArrayList<>();

    public Tio() {
    }

    public Tio(String nome) {
        this.nome = nome;
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

    public List<Sobrinho> getListSobrinhos() {
        return listSobrinhos;
    }

    public void setListSobrinhos(List<Sobrinho> listSobrinhos) {
        this.listSobrinhos = listSobrinhos;
    }
}
