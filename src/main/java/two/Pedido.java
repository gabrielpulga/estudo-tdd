package two;

import two.desconto.CalculadoraFaixaDesconto;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private CalculadoraFaixaDesconto calculadoraFaixaDesconto;

    public Pedido(CalculadoraFaixaDesconto calculadoraFaixaDesconto){
        this.calculadoraFaixaDesconto = calculadoraFaixaDesconto;
    }

    public Pedido() {
    }

    private List<ItemPedido> itens = new ArrayList<>();

    public void adicionarItem(ItemPedido itemPedido)
    {
        if (itemPedido.getQuantidade() < 0)
            throw new QuantidadeItensInvalidaException();
        itens.add(itemPedido);
    }

    public double valorTotal() {
        //valorTotal += itemPedido.getValorUnitario()*itemPedido.getQuantidade();
        return itens.stream().mapToDouble(i -> i.getValorUnitario() * i.getQuantidade()).sum();
    }

    public double desconto() {
        double desconto = 0;
        double valorTotal = valorTotal();
        if (valorTotal > 300.0) {
            desconto = valorTotal * 0.04;
        }
        return desconto;
    }

    public ResumoPedido resumoPedido() {
        double valorTotal = itens.stream().mapToDouble((i -> i.getValorUnitario() * i.getQuantidade())).sum();
        double desconto = 0;

        /**if (valorTotal > 300.0 && valorTotal <= 800.0) {
            desconto = valorTotal * 0.04;
        } else if (valorTotal > 800.0 && valorTotal <= 1000.0) {
            desconto = valorTotal*0.06;
        } else if (valorTotal > 1000.0) {
            desconto = valorTotal*0.08;
        }*/

        return new ResumoPedido(valorTotal, desconto);
    }
}
