package br.com.likwi.strategy.controller;

import br.com.likwi.strategy.controller.request.PagamentoRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PagamentoControllerIT {

    @Autowired
    private PagamentoController underTest;

    @Autowired
    private MockMvc mockMvc;

    private Faker faker = new Faker();

    private final String RESPONSE = "{\"code\":200}";

    @Test
    void deve_pagar_usando_master() throws Exception {

        ResultActions resultActions = this.mockMvc.perform(post("/v1/pagamento")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectToJson(pagamentoMasterCard())));


        resultActions.andExpect(status().isOk());

    }

    private String objectToJson(Object object) {

        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException jpe) {
            fail("Failed to convert object to json");
            return null;
        }
    }

    private PagamentoRequest pagamentoMasterCard(){

        return new PagamentoRequest(faker.number().randomNumber(), BigDecimal.valueOf(faker.number().numberBetween(0,1000)),
                faker.number().randomNumber()+"","MASTERCARD");

    }
}
