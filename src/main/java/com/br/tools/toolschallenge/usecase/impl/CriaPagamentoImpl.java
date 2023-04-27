package com.br.tools.toolschallenge.usecase.impl;

import com.br.tools.toolschallenge.domain.FormaPagamento;
import com.br.tools.toolschallenge.domain.Pagamento;
import com.br.tools.toolschallenge.domain.Transacao;
import com.br.tools.toolschallenge.gateway.controller.dto.PagamentoRequest;
import com.br.tools.toolschallenge.gateway.repository.PagamentoRepository;
import com.br.tools.toolschallenge.interfaceadapter.converter.PagamentoConverter;
import com.br.tools.toolschallenge.usecase.CriaFormaPagamento;
import com.br.tools.toolschallenge.usecase.CriaPagamento;
import com.br.tools.toolschallenge.usecase.CriaTransacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriaPagamentoImpl implements CriaPagamento {

    @Autowired
    private CriaTransacao criaTransacao;

    @Autowired
    private CriaFormaPagamento criaFormaPagamento;

    @Autowired
    private PagamentoConverter converter;

    @Autowired
    private PagamentoRepository repository;

    public Pagamento executa(PagamentoRequest pagamentoRequest) {
        Transacao transacao = criaTransacao.executa();
        FormaPagamento formaPagamento = criaFormaPagamento.executa(pagamentoRequest.getTransacao().getFormaPagamento());
        return repository.save(converter.executa(pagamentoRequest, transacao, formaPagamento));
    }
}

