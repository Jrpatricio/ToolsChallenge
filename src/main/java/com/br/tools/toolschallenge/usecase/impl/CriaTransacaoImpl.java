package com.br.tools.toolschallenge.usecase.impl;

import com.br.tools.toolschallenge.domain.Transacao;
import com.br.tools.toolschallenge.gateway.repository.TransacaoRepository;
import com.br.tools.toolschallenge.usecase.CriaTransacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriaTransacaoImpl implements CriaTransacao {

    @Autowired
    private TransacaoRepository repository;

    public Transacao executa() {
        return repository.save(new Transacao());
    }

}
