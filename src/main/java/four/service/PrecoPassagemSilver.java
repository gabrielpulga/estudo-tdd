package four.service;

import four.model.Voo;

public class PrecoPassagemSilver implements CalculadoraPrecoPassagem {

    @Override
    public double calcular(Voo voo) {
        if (voo.getPreco() > 700.0)
            return calcularValorAbaixoDoLimite(voo);
        return calcularValorAcimaDoLimite(voo);

    }

    private double calcularValorAbaixoDoLimite(Voo voo) {
        return voo.getPreco() * 0.9;
    }

    private double calcularValorAcimaDoLimite(Voo voo) {
        return voo.getPreco() * 0.94;
    }
}
