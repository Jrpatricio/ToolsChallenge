package com.br.tools.toolschallenge.usecase.impl;

import com.br.tools.toolschallenge.domain.types.Status;
import com.br.tools.toolschallenge.gateway.repository.PagamentoRepository;
import com.br.tools.toolschallenge.usecase.CancelaPagamento;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CancelaPagamentoImpl implements CancelaPagamento {

    @Autowired
    private PagamentoRepository repository;

    @Transactional
    public void executa(Long pagamentoId) {
        repository.updatePagamento(pagamentoId, Status.CANCELADO);
    }
}
