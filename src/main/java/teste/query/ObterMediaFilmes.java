package teste.query;

import infra.DAO;
import modelo.muitosPraMuitos.Filme;
import modelo.query.NotaFilme;

public class ObterMediaFilmes {
    public static void main(String[] args) {
        DAO<NotaFilme> dao = new DAO<>(NotaFilme.class);

        NotaFilme nota = dao.execSingleQuery("MediaGeral");

        System.out.println(nota.getMedia());

        dao.fechar();
    }
}
