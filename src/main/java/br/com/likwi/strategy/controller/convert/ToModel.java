package br.com.likwi.strategy.controller.convert;

import br.com.likwi.strategy.controller.request.PagamentoRequest;
import br.com.likwi.strategy.enums.BandeirasCartoes;
import br.com.likwi.strategy.model.Pagamento;

public class ToModel {
    public static Pagamento convert(PagamentoRequest request){
        return Pagamento
                .builder()
                .id(request.id())
                .valor(request.valor())
                .bandeirasCartoes(BandeirasCartoes.valueOf(request.cartao()))
                .customerId(request.customerId())
                .build();
    }
}
