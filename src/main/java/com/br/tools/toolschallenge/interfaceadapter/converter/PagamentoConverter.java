package com.br.tools.toolschallenge.interfaceadapter.converter;

import com.br.tools.toolschallenge.domain.FormaPagamento;
import com.br.tools.toolschallenge.domain.Pagamento;
import com.br.tools.toolschallenge.domain.Transacao;
import com.br.tools.toolschallenge.domain.types.Status;
import com.br.tools.toolschallenge.gateway.controller.dto.PagamentoRequest;
import com.br.tools.toolschallenge.usecase.dto.PagamentoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PagamentoConverter {

    @Autowired
    private TransacaoConverter transacaoConverter;

    public Pagamento executa(PagamentoRequest pagamentoRequest, Transacao transacao, FormaPagamento formaPagamento) {
        Pagamento pagamento = new Pagamento();
        pagamento.setId(pagamentoRequest.getTransacao().getId());
        pagamento.setCartao(pagamentoRequest.getTransacao().getCartao());
        pagamento.setEstabelecimento(pagamentoRequest.getTransacao().getDescricao().getEstabelecimento());
        pagamento.setNsu("1234567890");
        pagamento.setCodigoAutorizacao("147258369");
        pagamento.setDataHora(pagamentoRequest.getTransacao().getDescricao().getDataHora());
        pagamento.setStatus(Status.AUTORIZADO);
        pagamento.setValor(pagamentoRequest.getTransacao().getDescricao().getValor());
        pagamento.setTransacao(transacao);
        pagamento.setFormaPagamento(formaPagamento);
        transacao.setPagamento(pagamento);
        formaPagamento.setPagamento(pagamento);
        return pagamento;
    }

    public PagamentoResponse executa(Pagamento pagamentos) {
        return getPagamentoResponse(pagamentos);
    }

    public List<PagamentoResponse> executa(List<Pagamento> pagamentos) {
        List<PagamentoResponse> response = new ArrayList<>();
        if (!pagamentos.isEmpty()) {
            pagamentos.forEach(pagamento -> response.add(executa(pagamento)));
        }
        return response;
    }

    private PagamentoResponse getPagamentoResponse(Pagamento pagamento) {
        PagamentoResponse pagamentoResponse = new PagamentoResponse();
        pagamentoResponse.setTransacao(transacaoConverter.executa(pagamento));
        return pagamentoResponse;
    }


}