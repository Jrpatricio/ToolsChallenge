package com.br.tools.toolschallenge.usecase.impl;

import com.br.tools.toolschallenge.domain.types.Status;
import com.br.tools.toolschallenge.gateway.repository.PagamentoRepository;
import com.br.tools.toolschallenge.interfaceadapter.converter.PagamentoConverter;
import com.br.tools.toolschallenge.usecase.ConsultaPagamentos;
import com.br.tools.toolschallenge.usecase.dto.PagamentoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class ConsultaPagamentosImpl implements ConsultaPagamentos {

    @Autowired
    private PagamentoRepository repository;

    @Autowired
    private PagamentoConverter converter;

    public List<PagamentoResponse> executa(Status... status) {

        if (ObjectUtils.isEmpty(status)) {
            return converter.executa(repository.findAll());
        }
        return converter.executa(repository.findAllByStatus(status[0]));
    }
}
