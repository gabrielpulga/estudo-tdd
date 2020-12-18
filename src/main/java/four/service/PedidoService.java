package four.service;

import four.email.NotificadorEmail;
import four.model.Pedido;
import four.repository.PedidosRepository;
import four.sms.NotificadorSms;

import java.util.List;

public class PedidoService {

    private PedidosRepository pedidosRepository;
    private List<AcaoLancamentoPedido> acoes;

    public PedidoService(PedidosRepository pedidosRepository, List<AcaoLancamentoPedido> acoes) {
        this.pedidosRepository = pedidosRepository;
        this.acoes = acoes;
    }

    public double lancar(Pedido pedido) {
        double imposto = pedido.getValor() * 0.1;

        pedidosRepository.guardar(pedido);

        acoes.forEach(a -> a.executar(pedido));

        return imposto;
    }

    public Pedido pagar(Long codigo) {
        Pedido pedido = pedidosRepository.buscarPelocodigo(codigo);

        if (!pedido.getStatus().equals(StatusPedido.PENDENTE))
            throw new PedidoInvalidoException();

        pedido.setStatus(StatusPedido.PAGO);
        return pedido;
    }
}
