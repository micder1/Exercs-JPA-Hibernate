package teste.muitosPraMuitos;

import infra.DAO;
import modelo.muitosPraMuitos.Ator;
import modelo.muitosPraMuitos.Filme;

public class NovoFilmeAtor {
    public static void main(String[] args) {

        Filme filmeA = new Filme("Interstellar", 9.6);
        Filme filmeB = new Filme("Lobo de Wallstreet", 8.8);

        Ator atorA = new Ator("Matthew McConaughey");
        Ator atorB = new Ator("Jessica Chastain");

        filmeA.addAtor(atorA);
        filmeA.addAtor(atorB);

        filmeB.addAtor(atorA);

        DAO<Filme> dao = new DAO<Filme>();
        dao.incluirAll(filmeA);
    }
}
