package com.br.tools.toolschallenge.usecase.impl;

import com.br.tools.toolschallenge.domain.Pagamento;
import com.br.tools.toolschallenge.domain.types.Status;
import com.br.tools.toolschallenge.gateway.repository.PagamentoRepository;
import com.br.tools.toolschallenge.usecase.ConsultaPagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@Service
public class ConsultaPagamentoImpl implements ConsultaPagamento {

    @Autowired
    private PagamentoRepository repository;

    public Optional<Pagamento> executa(Long pagamentoId, Status... status){
        if(ObjectUtils.isEmpty(status) && pagamentoId != null){
            return repository.findById(pagamentoId);
        }
        return repository.findByIdAndStatus(pagamentoId, status[0]);
    }
}
