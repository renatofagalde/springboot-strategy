package br.com.likwi.strategy.controller.request;

import br.com.likwi.strategy.enums.BandeirasCartoes;

import java.math.BigDecimal;

public record PagamentoRequest(Long id, BigDecimal valor, String customerId, String cartao){}

