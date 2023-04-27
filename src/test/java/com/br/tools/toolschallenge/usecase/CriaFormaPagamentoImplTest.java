package com.br.tools.toolschallenge.usecase;

import com.br.tools.toolschallenge.domain.FormaPagamento;
import com.br.tools.toolschallenge.gateway.controller.dto.FormaPagamentoRequest;
import com.br.tools.toolschallenge.gateway.repository.FormaPagamentoRepository;
import com.br.tools.toolschallenge.interfaceadapter.converter.FormaPagamentoConverter;
import com.br.tools.toolschallenge.usecase.impl.CriaFormaPagamentoImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CriaFormaPagamentoImplTest {

    @Mock
    private FormaPagamentoRepository repository;

    @Mock
    private FormaPagamentoConverter converter;

    @InjectMocks
    private CriaFormaPagamentoImpl criaFormaPagamento;

    @Test
    public void criaFormaPagamento() {
        when(repository.save(any(FormaPagamento.class))).thenReturn(new FormaPagamento());
        when(converter.executa(any(FormaPagamentoRequest.class))).thenReturn(new FormaPagamento());
        criaFormaPagamento.executa(new FormaPagamentoRequest());
        verify(repository, times(1)).save(any(FormaPagamento.class));
        verify(converter, times(1)).executa(any(FormaPagamentoRequest.class));
    }
}
