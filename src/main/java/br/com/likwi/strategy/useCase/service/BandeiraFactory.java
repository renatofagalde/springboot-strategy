package br.com.likwi.strategy.useCase.service;

import br.com.likwi.strategy.enums.BandeirasCartoes;
import br.com.likwi.strategy.useCase.BandeiraUseCase;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class BandeiraFactory {
    private Map<BandeirasCartoes,BandeiraUseCase> cartoes = new HashMap<BandeirasCartoes,BandeiraUseCase>();

    public BandeiraFactory(Set<BandeiraUseCase> cartoes) {
        this.adicionarCartoes(cartoes);
    }

    private void adicionarCartoes(Set<BandeiraUseCase> cartoes){
        cartoes.forEach(bandeiraUseCase -> this.cartoes.put(bandeiraUseCase.bandeira(),bandeiraUseCase));
    }

    public BandeiraUseCase findBandeira(BandeirasCartoes cartao){
        return cartoes.get(cartao);
    }
}
