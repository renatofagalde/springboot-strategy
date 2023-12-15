package br.com.likwi.strategy.useCase.service;

import br.com.likwi.strategy.enums.BandeirasCartoes;
import br.com.likwi.strategy.model.Pagamento;
import br.com.likwi.strategy.useCase.BandeiraUseCase;
import org.springframework.stereotype.Service;

@Service
public class MasterCardService implements BandeiraUseCase {

    @Override
    public BandeirasCartoes bandeira() {
        return BandeirasCartoes.MASTERCARD;
    }

    @Override
    public BandeirasCartoes efetuarPagamento(Pagamento pagamento) {
        System.out.println("Pagamento efetuado pela bandeira MasterCard");
        return pagamento.getBandeirasCartoes();
    }
}
