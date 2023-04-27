package com.br.tools.toolschallenge.usecase;

import com.br.tools.toolschallenge.domain.Pagamento;
import com.br.tools.toolschallenge.domain.types.Status;
import com.br.tools.toolschallenge.gateway.repository.PagamentoRepository;
import com.br.tools.toolschallenge.usecase.impl.ConsultaPagamentoImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ConsultaPagamentoImplTest {

    @Mock
    private PagamentoRepository repository;

    @InjectMocks
    private ConsultaPagamentoImpl consultaPagamento;

    @Test
    public void buscaPorId(){
        when(repository.findById(anyLong())).thenReturn(Optional.of(new Pagamento()));
        consultaPagamento.executa(anyLong());
        verify(repository, times(1)).findById(anyLong());
        verify(repository,times(0)).findByIdAndStatus(anyLong(), any(Status.class));
    }

    @Test
    public void buscaPorIdEStatus(){
        when(repository.findByIdAndStatus(anyLong(), any(Status.class))).thenReturn(Optional.of(new Pagamento()));
        consultaPagamento.executa(1L, Status.CANCELADO);
        verify(repository, times(0)).findById(anyLong());
        verify(repository,times(1)).findByIdAndStatus(anyLong(), any(Status.class));
    }
}