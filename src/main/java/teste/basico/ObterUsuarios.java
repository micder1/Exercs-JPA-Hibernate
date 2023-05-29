package teste.basico;

import modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ObterUsuarios {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-Hibernate");
        EntityManager em = emf.createEntityManager();

//        String jpql = "select u from Usuario u";
//        TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
//        query.setMaxResults(10);
//
//        List<Usuario> listUsuarios = query.getResultList();

        List<Usuario> listUsuarios = em
                .createQuery("select u from Usuario u", Usuario.class)
                .setMaxResults(10)
                .getResultList();

        for(Usuario u : listUsuarios){
            System.out.println("id: " + u.getId() + ", email: " + u.getEmail());
        }

        em.close();
        emf.close();
    }
}
