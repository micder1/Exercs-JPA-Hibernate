package teste.umPraUm;

import infra.DAO;
import modelo.umPraUm.Assento;
import modelo.umPraUm.Cliente;

/**
 * Classe de teste para criar um novo cliente e assento e persisti-los no banco de dados.
 */
public class NovoClienteAssento1 {
    public static void main(String[] args) {

        Assento assento = new Assento("18CF"); // Cria um novo assento com o numero passado
        Cliente cliente = new Cliente("Joao", assento); // Cria um novo cliente com o nome passado e associa o assento

        DAO<Object> dao = new DAO<>(); // Cria uma instância do DAO para interagir com o banco de dados

        dao.abrirT() // Abre uma transação
                .incluir(assento) // Inclui o assento no banco de dados
                .incluir(cliente) // Inclui o cliente no banco de dados
                .fecharT() // Fecha a transação
                .fechar(); // Fecha a conexão com o banco de dados
    }
}
