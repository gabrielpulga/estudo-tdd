package four.sms;

import four.model.Pedido;
import four.service.AcaoLancamentoPedido;

public class NotificadorSms implements AcaoLancamentoPedido {

    @Override
    public void executar(Pedido pedido) {
        System.out.println("Enviando o sms...");
    }
}
