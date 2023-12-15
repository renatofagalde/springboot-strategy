package br.com.likwi.strategy.useCase;

import br.com.likwi.strategy.enums.BandeirasCartoes;
import br.com.likwi.strategy.model.Pagamento;

public interface BandeiraUseCase extends Bandeira<BandeirasCartoes>{
    BandeirasCartoes efetuarPagamento(Pagamento pagamento);
}
