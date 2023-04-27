package com.br.tools.toolschallenge.fixture;

import com.br.tools.toolschallenge.domain.FormaPagamento;
import com.br.tools.toolschallenge.domain.Pagamento;
import com.br.tools.toolschallenge.domain.Transacao;
import com.br.tools.toolschallenge.domain.types.Status;
import com.br.tools.toolschallenge.domain.types.TipoPagamento;
import com.br.tools.toolschallenge.gateway.controller.dto.PagamentoRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Slf4j
public class PagamentoFixture {

    String pagamentoRequest = """
            {
                "transacao": {
                    "cartao": "12345678910",
                    "id": "100101001001001030",
                    "descricao": {
                        "valor": "500.50",
                        "dataHora": "01/05/2021 18:30:00",
                        "estabelecimento": "TESTE"
                    },
                    "formaPagamento": {
                        "tipo": "AVISTA",
                        "parcelas": "1"
                    }
                }
            }
            """;


    public PagamentoRequest getPagamentoResquest() {
        PagamentoRequest fixture = new PagamentoRequest();
        try {
            ObjectMapper om = JsonMapper.builder().addModule(new JavaTimeModule()).build();
            fixture = om.readValue(pagamentoRequest, PagamentoRequest.class);
        } catch (Exception e) {
            log.error("Erro ao gerar o objeto", e);
        }
        return fixture;
    }

    public Pagamento getPagamento(){
        Pagamento pagamento = new Pagamento();
        pagamento.setId(1L);
        pagamento.setStatus(Status.AUTORIZADO);
        pagamento.setCartao("123456");
        pagamento.setNsu("123");
        pagamento.setEstabelecimento("teste");
        pagamento.setDataHora(LocalDateTime.now());
        pagamento.setCodigoAutorizacao("1234568");
        pagamento.setValor(BigDecimal.valueOf(500.50));
        FormaPagamento formaPagamento = new FormaPagamento();
        formaPagamento.setTipoPagamento(TipoPagamento.AVISTA);
        formaPagamento.setParcelas(1);
        formaPagamento.setId(1L);
        formaPagamento.setPagamento(pagamento);
        Transacao transacao = new Transacao();
        transacao.setId(1L);
        transacao.setPagamento(pagamento);
        pagamento.setFormaPagamento(formaPagamento);
        pagamento.setTransacao(transacao);
        return pagamento;
    }
}
