package four.service;

import four.email.NotificadorEmail;
import four.model.Pedido;
import four.model.builder.PedidoBuilder;
import four.repository.PedidosRepository;
import four.sms.NotificadorSms;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

public class PedidoServiceTest {

    private PedidoService pedidoService;
    private Pedido pedido;

    @Mock
    private PedidosRepository pedidosRepository;

    @Mock
    private NotificadorEmail notificadorEmail;

    @Mock
    private NotificadorSms notificadorSms;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        List<AcaoLancamentoPedido> acoes = Arrays.asList(notificadorEmail, notificadorSms);

        pedidoService = new PedidoService(pedidosRepository, acoes);

        pedido = new PedidoBuilder()
                .comValor(100.0)
                .para("Joao", "email", "telefone")
                .construir();

     }

    @Test
    public void deveCalcularOImposto() throws Exception {
        double imposto = pedidoService.lancar(pedido);
        Assert.assertEquals(10.0, imposto, 0.001);
    }

    @Test
    public void deveSalvarPedidoNoBD() throws Exception {
        pedidoService.lancar(pedido);
        Mockito.verify(pedidosRepository).guardar(pedido);
    }

    @Test
    public void deveNotificarPorEmail() throws Exception {
        pedidoService.lancar(pedido);
        Mockito.verify(notificadorEmail).executar(pedido);
    }

    @Test
    public void deveNotificarPorSms() throws Exception {
        pedidoService.lancar(pedido);
        Mockito.verify(notificadorSms).executar(pedido);
    }

    @Test
    public void devePagarPedidoPendente() throws Exception {
        Long codigoPedido = 135L;
        Pedido pedidoPendente = new Pedido();
        pedidoPendente.setStatus(StatusPedido.PENDENTE);

        Mockito.when(pedidosRepository.buscarPelocodigo(codigoPedido)).thenReturn(pedidoPendente);

        Pedido pedidoPago = pedidoService.pagar(codigoPedido);

        Assert.assertEquals(StatusPedido.PAGO, pedidoPago.getStatus());
    }
}
