package br.com.likwi.strategy.model;

import br.com.likwi.strategy.enums.BandeirasCartoes;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class Pagamento {
    private Long id;
    private BigDecimal valor;
    private String customerId;

    private BandeirasCartoes bandeirasCartoes;
}
