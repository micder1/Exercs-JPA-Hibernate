package infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Classe genérica que fornece funcionalidades básicas para acesso a dados usando JPA e Hibernate.
 *
 * @param <E> o tipo de entidade que será manipulada pelo DAO.
 */
public class DAO<E> {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private Class<E> classe;

    static{
        try {
            emf = Persistence.createEntityManagerFactory("JPA-Hibernate");
        } catch (Exception e){
            System.out.println(e);
        }
    }

    /**
     * Cria um DAO com a classe genérica definida como nula.
     */
    public DAO() {
        this(null);
    }

    /**
     * Cria um DAO com a classe genérica especificada.
     *
     * @param classe a classe genérica a ser utilizada pelo DAO.
     */
    public DAO(Class<E> classe) {
        this.classe = classe;
        em = emf.createEntityManager();
    }

    /**
     * Inicia uma nova transação no gerenciador de entidades.
     *
     * @return o próprio DAO para permitir a realização de chamadas encadeadas.
     */
    public DAO<E> abrirT(){
        em.getTransaction().begin();
        return this;
    }

    /**
     * Finaliza a transação atual no gerenciador de entidades.
     *
     * @return o próprio DAO para permitir a realização de chamadas encadeadas.
     */
    public DAO<E> fecharT(){
        em.getTransaction().commit();
        return this;
    }

    /**
     * Inclui uma entidade no banco de dados.
     *
     * @param entidade a entidade a ser incluída.
     * @return o próprio DAO para permitir a realização de chamadas encadeadas.
     */
    public DAO<E> incluir(E entidade){
        em.persist(entidade);
        return this;
    }

    /**
     * Inclui uma entidade no banco de dados dentro de uma nova transação e finaliza a transação.
     *
     * @param entidade a entidade a ser incluída.
     * @return o próprio DAO para permitir a realização de chamadas encadeadas.
     */
    public DAO<E> incluirAll(E entidade){
        return this.abrirT().incluir(entidade).fecharT();
    }

    public E obterPorID(Object id){
        return em.find(classe, id);
    }

    /**
     * Obtém todos os registros da entidade do banco de dados, com opções de quantidade máxima e deslocamento.
     *
     * @param qtd a quantidade máxima de registros a serem retornados.
     * @param deslocamento o deslocamento inicial dos registros.
     * @return uma lista de entidades obtidas do banco de dados.
     * @throws UnsupportedOperationException se a classe genérica for nula.
     */
    public List<E> obterTodos(int qtd, int deslocamento) {
        if(classe == null) {
            throw new UnsupportedOperationException("Classe nula");
        }

        String jpql = "select e from " + classe.getName() + " e";
        TypedQuery<E> query = em.createQuery(jpql, classe);

        query.setMaxResults(qtd);
        query.setFirstResult(deslocamento);
        return query.getResultList();
    }

    /**
     * Obtém todos os registros da entidade do banco de dados com valores padrão para quantidade máxima e deslocamento.
     *
     * @return uma lista de entidades obtidas do banco de dados.
     */
    public List<E> obterTodos() {
        return this.obterTodos(10, 0);
    }

    public void fechar(){
        em.close();
    }

    /**
     * Executa uma consulta nomeada com parâmetros e retorna uma lista de entidades.
     *
     * @param nomeQuery O nome da consulta nomeada a ser executada.
     * @param params    Os parâmetros a serem definidos na consulta nomeada.
     *                  Os parâmetros são fornecidos como pares de nome-valor.
     *                  O nome é o nome do parâmetro na consulta nomeada,
     *                  e o valor é o valor a ser definido para esse parâmetro.
     *                  Os parâmetros devem ser fornecidos na ordem dos pares de nome-valor.
     * @return Uma lista de entidades resultantes da execução da consulta nomeada.
     */
    public List<E> execQuery(String nomeQuery, Object... params) {
        TypedQuery<E> query = em.createNamedQuery(nomeQuery, classe);

        for (int i = 0; i < params.length; i += 2) {
            query.setParameter(params[i].toString(), params[i + 1]);
        }

        return query.getResultList();
    }

    public E execSingleQuery(String nomeQuery, Object... params) {
        List<E> lista = execQuery(nomeQuery, params);

        return lista.isEmpty() ? null : lista.get(0);
    }

}
