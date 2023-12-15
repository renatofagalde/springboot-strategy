package br.com.likwi.strategy.controller.request;

import java.math.BigDecimal;

public record PagamentoRequest(Long id, BigDecimal valor, String customerId, String cartao){}

