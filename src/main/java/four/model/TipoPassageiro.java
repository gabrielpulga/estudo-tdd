package four.model;

import four.service.CalculadoraPrecoPassagem;
import four.service.PrecoPassagemGold;
import four.service.PrecoPassagemSilver;

public enum TipoPassageiro {
    GOLD(new PrecoPassagemGold()),
    SILVER(new PrecoPassagemSilver());

    CalculadoraPrecoPassagem calculadoraPrecoPassagem;

    TipoPassageiro(CalculadoraPrecoPassagem calculadoraPrecoPassagem) {
        this.calculadoraPrecoPassagem = calculadoraPrecoPassagem;
    }

    public CalculadoraPrecoPassagem getCalculadora() {
        return calculadoraPrecoPassagem;
    }
}
