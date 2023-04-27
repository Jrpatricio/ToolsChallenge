package com.br.tools.toolschallenge.interfaceadapter.converter;

import com.br.tools.toolschallenge.fixture.PagamentoFixture;
import com.br.tools.toolschallenge.usecase.dto.DescricaoResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DescricaoConverterTest {

    @Autowired
    private DescricaoConverter converter;

    @Test
    public void getDescricaoResponse(){
        DescricaoResponse descricao = converter.executa(new PagamentoFixture().getPagamento());
        Assertions.assertNotNull(descricao);
    }
}
