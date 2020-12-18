package four.service;

import four.model.Passageiro;
import four.model.TipoPassageiro;
import four.model.Voo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PrecoPassagemServiceTest {

    private PrecoPassagemService precoPassagemService;

    @Before
    public void setup() {
        precoPassagemService = new PrecoPassagemService();
    }

    @Test
    public void deveCriarPrecoPassagemService() throws Exception {
    }

    @Test
    public void devePermitirChamarCalculoDoValor() throws Exception {

        Passageiro passageiro = new Passageiro("Joao", TipoPassageiro.GOLD);
        Voo voo = new Voo("SP", "RJ", 100.00);


        double valor = precoPassagemService.calcular(passageiro, voo);
    }

    @Test
    public void deveCalcularValorPassagemParaPassageiroGold_comValorAbaixoDoLimite() throws Exception {

        Passageiro passageiro = new Passageiro("Joao", TipoPassageiro.GOLD);
        Voo voo = new Voo("SP", "RJ", 100.00);

        double valor = precoPassagemService.calcular(passageiro,voo);

        Assert.assertEquals(90.0, valor, 0.0001);
    }

    @Test
    public void deveCalcularValorPassagemParaPassageiroGold_comValorAcimaDoLimite() throws Exception {

        Passageiro passageiro = new Passageiro("Joao", TipoPassageiro.GOLD);
        Voo voo = new Voo("SP", "RJ", 600.0);

        double valor = precoPassagemService.calcular(passageiro,voo);

        Assert.assertEquals(510.0, valor, 0.0001);
    }

    @Test
    public void deveCalcularValorPassagemParaPassageiroSilver_comValorAbaixoDoLimite() throws Exception {

        Passageiro passageiro = new Passageiro("Joao", TipoPassageiro.SILVER);
        Voo voo = new Voo("SP", "RJ", 100);

        double valor = precoPassagemService.calcular(passageiro,voo);

        Assert.assertEquals(94.0, valor, 0.0001);
    }

    @Test
    public void deveCalcularValorPassagemParaPassageiroSilver_comValorAcimaDoLimite() throws Exception {

        Passageiro passageiro = new Passageiro("Joao", TipoPassageiro.SILVER);
        Voo voo = new Voo("SP", "RJ", 800.0);

        double valor = precoPassagemService.calcular(passageiro,voo);

        Assert.assertEquals(720.0, valor, 0.0001);
    }
}
