package com.br.tools.toolschallenge.interfaceadapter.converter;

import com.br.tools.toolschallenge.domain.FormaPagamento;
import com.br.tools.toolschallenge.domain.Pagamento;
import com.br.tools.toolschallenge.gateway.controller.dto.FormaPagamentoRequest;
import com.br.tools.toolschallenge.usecase.dto.FormaPagamentoResponse;
import org.springframework.stereotype.Component;

@Component
public class FormaPagamentoConverter {

    public FormaPagamento executa(FormaPagamentoRequest formaPagamentoResquest) {
        FormaPagamento formaPagamento = new FormaPagamento();
        formaPagamento.setTipoPagamento(formaPagamentoResquest.getTipo());
        formaPagamento.setParcelas(formaPagamentoResquest.getParcelas());
        return formaPagamento;
    }

    public FormaPagamentoResponse executa(Pagamento pagamento) {
        FormaPagamentoResponse formaPagamentoResponse = new FormaPagamentoResponse();
        formaPagamentoResponse.setTipo(pagamento.getFormaPagamento().getTipoPagamento());
        formaPagamentoResponse.setParcelas(pagamento.getFormaPagamento().getParcelas().toString());
        return formaPagamentoResponse;
    }
}
