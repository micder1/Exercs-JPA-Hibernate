package teste.query;

import modelo.muitosPraMuitos.*;
import infra.DAO;

import java.util.List;

public class ObterFilmes {
    public static void main(String[] args) {
        DAO<Filme> dao = new DAO<Filme>(Filme.class);
        List<Filme> filmes = dao.execQuery(
                "filmesNotaMaiorQue",
                "nota", 9.0
        );

        for (Filme filme: filmes) {
            System.out.println(filme.getNome() + ", nota: " + filme.getNota());

            for (Ator ator: filme.getAtores()) {
                System.out.println(ator.getNome());
            }
        }

    }
}
