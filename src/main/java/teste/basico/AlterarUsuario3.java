package teste.basico;

import modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlterarUsuario3 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-Hibernate");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Usuario usuario = em.find(Usuario.class, 8L);
        em.detach(usuario); // faz com que o update nao funcione mais sem o merge
        usuario.setNome("Tulio Alterado 2");

        em.merge(usuario);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
