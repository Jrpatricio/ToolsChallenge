package com.br.tools.toolschallenge.usecase;

import com.br.tools.toolschallenge.domain.Pagamento;
import com.br.tools.toolschallenge.domain.types.Status;
import com.br.tools.toolschallenge.gateway.repository.PagamentoRepository;
import com.br.tools.toolschallenge.interfaceadapter.converter.PagamentoConverter;
import com.br.tools.toolschallenge.usecase.dto.PagamentoResponse;
import com.br.tools.toolschallenge.usecase.impl.ConsultaPagamentosImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ConsultaPagamentosImplTest {

    @Mock
    private PagamentoRepository repository;

    @Mock
    private PagamentoConverter converter;

    @InjectMocks
    private ConsultaPagamentosImpl consultaPagamentos;

    @Test
    public void buscaTodos() {
        when(repository.findAll()).thenReturn(List.of(new Pagamento()));
        when(converter.executa(anyList())).thenReturn(List.of(new PagamentoResponse()));
        consultaPagamentos.executa();
        verify(repository, times(1)).findAll();
        verify(repository, times(0)).findAllByStatus(any(Status.class));
    }

    @Test
    public void buscaTodosPorStatus() {
        when(repository.findAllByStatus(any(Status.class))).thenReturn(List.of(new Pagamento()));
        when(converter.executa(anyList())).thenReturn(List.of(new PagamentoResponse()));
        consultaPagamentos.executa(Status.CANCELADO);
        verify(repository, times(0)).findAll();
        verify(repository, times(1)).findAllByStatus(any(Status.class));
    }
}
