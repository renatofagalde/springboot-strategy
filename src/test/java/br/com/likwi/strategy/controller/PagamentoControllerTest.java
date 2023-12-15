package br.com.likwi.strategy.controller;

import br.com.likwi.strategy.controller.request.PagamentoRequest;
import br.com.likwi.strategy.enums.BandeirasCartoes;
import br.com.likwi.strategy.useCase.service.BandeiraFactory;
import br.com.likwi.strategy.useCase.service.MasterCardService;
import br.com.likwi.strategy.useCase.service.VisaService;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class PagamentoControllerTest {

    private Faker faker = new Faker();
    @InjectMocks
    private PagamentoController underTest;

    @Mock
    private BandeiraFactory service;

    @Test
    void deve_processar_pagamento_usando_master(){

        when(this.service.findBandeira(BandeirasCartoes.MASTERCARD)).thenReturn(new MasterCardService());
        ResponseEntity<?> responseEntity = this.underTest.pagar(pagamentoMasterCard());
        assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
    }

    @Test
    void deve_processar_pagamento_usando_visa(){

        when(this.service.findBandeira(BandeirasCartoes.VISA)).thenReturn(new VisaService());
        ResponseEntity<?> responseEntity = this.underTest.pagar(pagamentoVisa());
        assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
    }


    private PagamentoRequest pagamentoMasterCard(){

        return new PagamentoRequest(faker.number().randomNumber(),BigDecimal.valueOf(faker.number().numberBetween(0,1000)),
                faker.number().randomNumber()+"","MASTERCARD");

    }
    private PagamentoRequest pagamentoVisa(){
        return new PagamentoRequest(faker.number().randomNumber(),BigDecimal.valueOf(faker.number().numberBetween(0,1000)),
                faker.number().randomNumber()+"","VISA");
    }
}