package four.repository;

import four.model.Pedido;
import four.service.AcaoLancamentoPedido;

public class PedidosRepository implements AcaoLancamentoPedido {

    @Override
    public void executar(Pedido pedido){
        System.out.println("Salvando no BD...");
    }

    public Pedido buscarPelocodigo(Long codigo){
        //buscar no bd pelo codigo
        return new Pedido();
    }

    public void guardar(Pedido pedido){
        System.out.println("Salvando no BD...");
    }
}
