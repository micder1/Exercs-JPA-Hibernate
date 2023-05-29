package teste.muitosPraMuitos;

import infra.DAO;
import modelo.muitosPraMuitos.Sobrinho;
import modelo.muitosPraMuitos.Tio;

public class NovoTioSobrinho {
    public static void main(String[] args) {

        Tio tia1 = new Tio("Marcia");
        Tio tio2 = new Tio("Carlos");

        Sobrinho sobrinho1 = new Sobrinho("marcos");
        Sobrinho sobrinho2 = new Sobrinho("Jonas");

        tia1.getListSobrinhos().add(sobrinho1);
        sobrinho1.getListTios().add(tia1);

        tia1.getListSobrinhos().add(sobrinho2);
        sobrinho2.getListTios().add(tia1);

        tio2.getListSobrinhos().add(sobrinho1);
        sobrinho1.getListTios().add(tio2);

        tio2.getListSobrinhos().add(sobrinho2);
        sobrinho2.getListTios().add(tio2);

        DAO<Object> dao = new DAO<>();

        dao.abrirT()
                .incluir(tia1)
                .incluir(tio2)
                .incluir(sobrinho1)
                .incluir(sobrinho2)
                .fecharT()
                .fechar();

    }
}
