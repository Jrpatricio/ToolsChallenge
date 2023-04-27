package com.br.tools.toolschallenge.usecase;


import com.br.tools.toolschallenge.domain.Transacao;
import com.br.tools.toolschallenge.gateway.repository.TransacaoRepository;
import com.br.tools.toolschallenge.usecase.impl.CriaTransacaoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CriaTransacaoImplTest {

    @Mock
    private TransacaoRepository repository;

    @InjectMocks
    private CriaTransacaoImpl criaTransacao;

    @Test
    public void criaTransacao() {
        when(repository.save(any(Transacao.class))).thenReturn(new Transacao());
        Transacao transacao = criaTransacao.executa();
        verify(repository, times(1)).save(any(Transacao.class));
        Assertions.assertNotNull(transacao);
    }

}
