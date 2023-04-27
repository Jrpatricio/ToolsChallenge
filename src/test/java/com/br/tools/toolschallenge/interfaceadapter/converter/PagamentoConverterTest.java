package com.br.tools.toolschallenge.interfaceadapter.converter;

import com.br.tools.toolschallenge.domain.Pagamento;
import com.br.tools.toolschallenge.domain.Transacao;
import com.br.tools.toolschallenge.fixture.FormaPagamentoFixture;
import com.br.tools.toolschallenge.fixture.PagamentoFixture;
import com.br.tools.toolschallenge.usecase.dto.PagamentoResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PagamentoConverterTest {

    @Autowired
    private PagamentoConverter converter;

    @Test
    public void getPagamento() {
        Pagamento pagamento = converter.executa(new PagamentoFixture().getPagamentoResquest(), new Transacao(), new FormaPagamentoFixture().getFormaPagamento());
        Assertions.assertNotNull(pagamento);
    }

    @Test
    public void getPagamentoResponse() {
        PagamentoResponse response = converter.executa(new PagamentoFixture().getPagamento());
        Assertions.assertNotNull(response);
    }

    @Test
    public void getPagamentoResponseList() {
        List<PagamentoResponse> response = converter.executa(List.of(new PagamentoFixture().getPagamento()));
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.size(), 1);
    }

}
