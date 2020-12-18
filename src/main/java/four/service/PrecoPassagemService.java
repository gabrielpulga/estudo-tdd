package four.service;

import four.model.Passageiro;
import four.model.TipoPassageiro;
import four.model.Voo;

public class PrecoPassagemService {
    public double calcular(Passageiro passageiro, Voo voo){
        return passageiro.getTipo().getCalculadora().calcular(voo);
    }
}
