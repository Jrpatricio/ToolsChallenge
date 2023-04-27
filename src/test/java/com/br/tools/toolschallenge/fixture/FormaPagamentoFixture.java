package com.br.tools.toolschallenge.fixture;

import com.br.tools.toolschallenge.domain.FormaPagamento;
import com.br.tools.toolschallenge.gateway.controller.dto.FormaPagamentoRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FormaPagamentoFixture {
    String formaPagamentoRequest = "{\"tipo\":\"AVISTA\",\"parcelas\":1}";

    String formaPagamento = """
            {
                "createdAt":null,
                "updateAt":null,
                "id":null,
                "tipoPagamento":"AVISTA",
                "parcelas":1,
                "pagamento":null
            }
            """;

    public FormaPagamento getFormaPagamento() {
        FormaPagamento fixture = new FormaPagamento();
        try {
            ObjectMapper om = new ObjectMapper();
            fixture = om.readValue(formaPagamento, FormaPagamento.class);
        } catch (Exception e) {
            log.error("Erro ao converter o objeto", e);
        }
        return fixture;
    }

    public FormaPagamentoRequest getFormaPagamentoRequest() {
        FormaPagamentoRequest fixture = new FormaPagamentoRequest();
        try {
            ObjectMapper om = new ObjectMapper();
            fixture = om.readValue(formaPagamentoRequest, FormaPagamentoRequest.class);
        } catch (Exception e) {
            log.error("Erro ao converter o objeto", e);
        }
        return fixture;

    }
}
