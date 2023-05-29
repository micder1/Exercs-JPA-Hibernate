package teste.umPraUm;

import com.mysql.cj.xdevapi.Client;
import infra.DAO;
import modelo.umPraUm.Assento;
import modelo.umPraUm.Cliente;

public class NovoClienteAssento2 {
    public static void main(String[] args) {
        Assento assento = new Assento("4D");
        Cliente cliente = new Cliente("Rodrigo", assento);

        DAO<Cliente> dao = new DAO<>(Cliente.class);
        dao.incluirAll(cliente);
    }
}
