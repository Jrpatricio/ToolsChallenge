package com.br.tools.toolschallenge.usecase;

import com.br.tools.toolschallenge.domain.types.Status;
import com.br.tools.toolschallenge.gateway.repository.PagamentoRepository;
import com.br.tools.toolschallenge.usecase.impl.CancelaPagamentoImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CancelaPagamentoImplTest {

    @Mock
    private PagamentoRepository repository;

    @InjectMocks
    private CancelaPagamentoImpl cancelaPagamento;

    @Test
    public void test() {
        doNothing().when(repository).updatePagamento(anyLong(), any(Status.class));
        cancelaPagamento.executa(1L);
        verify(repository, times(1)).updatePagamento(anyLong(), any(Status.class));
    }
}
