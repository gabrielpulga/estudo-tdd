package two;

import java.util.Objects;

public class ResumoPedido {
    private double valorTotal;
    private double desconto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResumoPedido that = (ResumoPedido) o;
        return Double.compare(that.valorTotal, valorTotal) == 0 &&
                Double.compare(that.desconto, desconto) == 0;
    }

    @Override
    public String toString() {
        return "ResumoPedido{" +
                "valorTotal=" + valorTotal +
                ", desconto=" + desconto +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(valorTotal, desconto);
    }

    public ResumoPedido(double valorTotal, double desconto) {
        this.valorTotal = valorTotal;
        this.desconto = desconto;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }
}
