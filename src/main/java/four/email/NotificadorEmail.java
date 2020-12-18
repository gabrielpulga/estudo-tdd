package four.email;

import four.model.Pedido;
import four.service.AcaoLancamentoPedido;

public class NotificadorEmail implements AcaoLancamentoPedido {
    @Override
    public void executar(Pedido pedido) {
        System.out.println("Enviando o sms...");
    }
}
