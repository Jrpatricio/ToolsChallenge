package com.br.tools.toolschallenge.usecase.impl;

import com.br.tools.toolschallenge.domain.Estorno;
import com.br.tools.toolschallenge.domain.Pagamento;
import com.br.tools.toolschallenge.domain.exceptions.PagamentoNaoEncontradoException;
import com.br.tools.toolschallenge.gateway.repository.EstornoRepository;
import com.br.tools.toolschallenge.usecase.CancelaPagamento;
import com.br.tools.toolschallenge.usecase.ConsultaPagamento;
import com.br.tools.toolschallenge.usecase.CriaEstorno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriaEstornoImpl implements CriaEstorno {

    @Autowired
    private EstornoRepository repository;

    @Autowired
    private ConsultaPagamento consultaPagamento;

    @Autowired
    private CancelaPagamento cancelaPagamento;

    public void executa(Long pagamentoId) {
        Pagamento pagamento = consultaPagamento.executa(pagamentoId).orElseThrow(PagamentoNaoEncontradoException::new);
        Estorno estorno = new Estorno();
        estorno.setTransacao(pagamento.getTransacao());
        repository.save(estorno);
        cancelaPagamento.executa(pagamentoId);
    }

}
