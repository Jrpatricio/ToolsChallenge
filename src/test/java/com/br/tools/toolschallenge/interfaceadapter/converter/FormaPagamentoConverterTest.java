package com.br.tools.toolschallenge.interfaceadapter.converter;

import com.br.tools.toolschallenge.domain.FormaPagamento;
import com.br.tools.toolschallenge.fixture.FormaPagamentoFixture;
import com.br.tools.toolschallenge.fixture.PagamentoFixture;
import com.br.tools.toolschallenge.usecase.dto.FormaPagamentoResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FormaPagamentoConverterTest {


    @Autowired
    private FormaPagamentoConverter converter;

    @Test
    public void getFormaPagamento() {
        FormaPagamento formaPagamento = converter.executa(new FormaPagamentoFixture().getFormaPagamentoRequest());
        Assertions.assertNotNull(formaPagamento);
    }

    @Test
    public void getFormaPagamentoResponse() {
        FormaPagamentoResponse formaPagamentoResponse = converter.executa(new PagamentoFixture().getPagamento());
        Assertions.assertNotNull(formaPagamentoResponse);
    }
}
