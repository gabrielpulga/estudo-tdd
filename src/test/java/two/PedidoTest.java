package two;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import three.PedidoBuilder;
import two.desconto.*;

import static org.junit.Assert.fail;

public class PedidoTest {

    private PedidoBuilder pedido;

    @Before
    public void setup() {
        pedido = new PedidoBuilder();
    }

    private void assertResumoPedido(double valorTotal, double desconto) {
        ResumoPedido resumoPedido = pedido.construir().resumoPedido();

        //sempre melhor deixar apenas uma asserção
        //Assert.assertEquals(valorTotal, resumoPedido.getValorTotal(), 0.001);
        //Assert.assertEquals(desconto, resumoPedido.getDesconto(), 0.001);
        Assert.assertEquals(new ResumoPedido(valorTotal, desconto), resumoPedido);
    }

    @Test
    public void deveCriarUmPedido() throws Exception {
        Pedido pedido = new Pedido();
    }

    @Test
    public void devePermitirAdicionarUmItemNoPedido() throws Exception {
        Pedido pedido = new Pedido();
        pedido.adicionarItem(new ItemPedido("Sabonete", 3.0, 10));
    }

    @Test
    public void deveCalcularValorTotalEDescontoParaPedidoVazio() throws Exception {
        assertResumoPedido(0.0, 0.0);
    }

    @Test
    public void deveCalcularResumoParaUmItemSemDesconto() throws Exception {
        //pedido.adicionarItem(new ItemPedido("Sabonete", 5.0, 5));
        pedido.comItem(5.0, 5);
        assertResumoPedido(25.0, 0.0);
    }

    @Test
    public void deveCalcularResumoParaDoisItemsSemDesconto() throws Exception {
        //pedido.adicionarItem(new ItemPedido("Paste dental", 1.0, 5));
        //pedido.adicionarItem(new ItemPedido("Sabonetezeira", 5.0, 5));

        pedido.comItem(3.0, 3)
                .comItem(7.0, 3);

        assertResumoPedido(30.0, 0.0);
    }

    @Test
    public void deveAplicarDescontoNaPrimeiraFaixa() throws Exception {
        //pedido.adicionarItem(new ItemPedido("Creme", 20.0, 20));

        pedido.comItem(20.0, 20);

        assertResumoPedido(400.0, 16.0);
    }

    @Test
    public void deveAplicarDescontoNa2aFaixa() throws Exception {
        //pedido.adicionarItem(new ItemPedido("shampoo", 15.0, 30));
        //pedido.adicionarItem(new ItemPedido("óleo", 15.0, 30));

        pedido
                .comItem(15.0, 30)
                .comItem(15.0, 30);

        assertResumoPedido(900.0, 54.0);
    }

    @Test
    public void deveAplicarDescontoNa3aFaixa() throws Exception {
        //pedido.adicionarItem(new ItemPedido("shampoo", 15.0, 30));
        //pedido.adicionarItem(new ItemPedido("óleo", 15.0, 30));
        //pedido.adicionarItem(new ItemPedido("creme", 10.0, 30));

        pedido
                .comItem(15.0, 30)
                .comItem(15.0, 30)
                .comItem(10.0, 30);

        assertResumoPedido(1200.0, 96.0);
    }

    // como tratar exceções
    @Test(expected = QuantidadeItensInvalidaException.class)
    public void naoAceitarPedidosComItensComQuantidadesNegativas() throws Exception {
        //try {
        pedido.comItem(0.0, -10);
        //fail("Deveria ter lançado a exception QuantidadeItensInvalidaException");
        //} catch (QuantidadeItensInvalidaException e) {
        //String message = e.getMessage();
        //Assert.assertEquals("Nao pode ser negativo", message);
    }
}
//}
