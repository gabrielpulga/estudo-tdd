package four.service;

import four.model.Voo;

public class PrecoPassagemGold implements CalculadoraPrecoPassagem {

    @Override
    public double calcular(Voo voo) {
        if (voo.getPreco() > 500)
            return calcularValorAbaixoDoLimite(voo);
        return calcularValorAcimaDoLimite(voo);
    }

    private double calcularValorAbaixoDoLimite(Voo voo) {
        return voo.getPreco() * 0.85;
    }

    private double calcularValorAcimaDoLimite(Voo voo) {
        return voo.getPreco() * 0.9;
    }


}
