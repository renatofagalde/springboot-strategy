package br.com.likwi.strategy.service;

import br.com.likwi.strategy.enums.BandeirasCartoes;
import br.com.likwi.strategy.model.Pagamento;
import br.com.likwi.strategy.useCase.BandeiraUseCase;
import br.com.likwi.strategy.useCase.service.BandeiraFactory;
import br.com.likwi.strategy.useCase.service.MasterCardService;
import br.com.likwi.strategy.useCase.service.VisaService;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ServiceStrategyTest {

    @Autowired
    private BandeiraFactory service;

    private Faker faker = new Faker();

    @Test
    public void deve_pagar_usando_master_card(){

        Pagamento masterCard = this.pagamentoMasterCard();
        BandeirasCartoes masterCardResult = service.findBandeira(masterCard.getBandeirasCartoes()).efetuarPagamento(masterCard);
        assertEquals(masterCard.getBandeirasCartoes(), masterCardResult);
    }

    @Test
    public void deve_pagar_usando_visa(){

        Pagamento visa = this.pagamentoVisa();
        BandeirasCartoes visaResult = service.findBandeira(visa.getBandeirasCartoes()).efetuarPagamento(visa);
        assertEquals(visa.getBandeirasCartoes(), visaResult);


    }
    private Pagamento pagamentoMasterCard(){
        return Pagamento
                .builder()
                .id(faker.number().randomNumber())
                .valor(BigDecimal.valueOf(faker.number().numberBetween(0,1000)))
                .bandeirasCartoes(BandeirasCartoes.MASTERCARD).build();
    }
    private Pagamento pagamentoVisa(){
        return Pagamento
                .builder()
                .id(faker.number().randomNumber())
                .valor(BigDecimal.valueOf(faker.number().numberBetween(0,1000)))
                .bandeirasCartoes(BandeirasCartoes.VISA).build();
    }
}