package com.br.tools.toolschallenge.interfaceadapter.converter;

import com.br.tools.toolschallenge.fixture.PagamentoFixture;
import com.br.tools.toolschallenge.usecase.dto.TransacaoResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TransacaoConverterTest {

    @Autowired
    private TransacaoConverter converter;

    @Test
    public void test(){
        TransacaoResponse transacao = converter.executa(new PagamentoFixture().getPagamento());
        Assertions.assertNotNull(transacao);
    }
}
