package com.br.tools.toolschallenge.interfaceadapter.converter;

import com.br.tools.toolschallenge.domain.Pagamento;
import com.br.tools.toolschallenge.usecase.dto.TransacaoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransacaoConverter {

    @Autowired
    private DescricaoConverter descricaoConverter;

    @Autowired
    private FormaPagamentoConverter formaPagamentoConverter;

    public TransacaoResponse executa(Pagamento pagamento) {
        TransacaoResponse transacaoResponse = new TransacaoResponse();
        transacaoResponse.setId(pagamento.getId().toString());
        transacaoResponse.setCartao(pagamento.getCartao());
        transacaoResponse.setDescricao(descricaoConverter.executa(pagamento));
        transacaoResponse.setFormaPagamento(formaPagamentoConverter.executa(pagamento));
        return transacaoResponse;
    }
}
