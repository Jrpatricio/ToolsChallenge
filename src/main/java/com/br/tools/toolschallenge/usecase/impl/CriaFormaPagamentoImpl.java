package com.br.tools.toolschallenge.usecase.impl;

import com.br.tools.toolschallenge.domain.FormaPagamento;
import com.br.tools.toolschallenge.gateway.controller.dto.FormaPagamentoRequest;
import com.br.tools.toolschallenge.gateway.repository.FormaPagamentoRepository;
import com.br.tools.toolschallenge.interfaceadapter.converter.FormaPagamentoConverter;
import com.br.tools.toolschallenge.usecase.CriaFormaPagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriaFormaPagamentoImpl implements CriaFormaPagamento {

    @Autowired
    private FormaPagamentoRepository repository;

    @Autowired
    private FormaPagamentoConverter converter;

    public FormaPagamento executa(FormaPagamentoRequest formaPagamentoRequest){
        return repository.save(converter.executa(formaPagamentoRequest));
    }

}
