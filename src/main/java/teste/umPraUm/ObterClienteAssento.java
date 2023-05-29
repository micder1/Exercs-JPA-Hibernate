package teste.umPraUm;

import infra.DAO;
import modelo.umPraUm.Assento;
import modelo.umPraUm.Cliente;

/**
 * Classe de teste para obter um cliente e seu assento do banco de dados.
 */
public class ObterClienteAssento {
    public static void main(String[] args) {

        DAO<Cliente> daoCliente = new DAO<>(Cliente.class); // Cria uma instância do DAO para interagir com o banco de dados e manipular objetos do tipo Cliente

        Cliente cliente = daoCliente.obterPorID(2L); // Obtém um cliente com ID passado do banco de dados
        System.out.println(cliente.getAssento().getNome()); // Imprime o nome do assento associado ao cliente
        daoCliente.fechar(); // Fecha a conexão com o banco de dados

        DAO<Assento> daoAssento = new DAO<>(Assento.class); // Cria uma instância do DAO para interagir com o banco de dados e manipular objetos do tipo Assento

        Assento assento = daoAssento.obterPorID(cliente.getAssento().getId()); // Obtém um assento com o ID do assento associado ao cliente obtido anteriormente
        System.out.println(assento.getCliente().getNome()); // Imprime o nome do cliente associado ao assento
        daoAssento.fechar(); // Fecha a conexão com o banco de dados
    }
}
