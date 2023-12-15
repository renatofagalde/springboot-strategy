package br.com.likwi.strategy.controller;

import br.com.likwi.strategy.controller.convert.ToModel;
import br.com.likwi.strategy.controller.request.PagamentoRequest;
import br.com.likwi.strategy.controller.response.PagamentoResponse;
import br.com.likwi.strategy.enums.BandeirasCartoes;
import br.com.likwi.strategy.useCase.service.BandeiraFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/pagamento")
public class PagamentoController {
    private BandeiraFactory service;

    public PagamentoController(BandeiraFactory service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> pagar(@RequestBody PagamentoRequest pagamentoRequest){

        BandeirasCartoes bandeira = BandeirasCartoes.valueOf(pagamentoRequest.cartao());
        service.findBandeira(bandeira).efetuarPagamento(ToModel.convert(pagamentoRequest));
        return ResponseEntity.ok().body(new PagamentoResponse(200));
    }
}
