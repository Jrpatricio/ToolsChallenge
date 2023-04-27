package com.br.tools.toolschallenge.usecase;

import com.br.tools.toolschallenge.domain.Estorno;
import com.br.tools.toolschallenge.domain.exceptions.PagamentoNaoEncontradoException;
import com.br.tools.toolschallenge.fixture.PagamentoFixture;
import com.br.tools.toolschallenge.gateway.repository.EstornoRepository;
import com.br.tools.toolschallenge.usecase.impl.CriaEstornoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CriaEstornoImplTest {

    @Mock
    private EstornoRepository repository;

    @Mock
    private ConsultaPagamento consultaPagamento;

    @Mock
    private CancelaPagamento cancelaPagamento;

    @InjectMocks
    private CriaEstornoImpl criaEstorno;

    @Test
    public void criaEstorno() {
        when(consultaPagamento.executa(anyLong())).thenReturn(Optional.of(new PagamentoFixture().getPagamento()));
        when(repository.save(any(Estorno.class))).thenReturn(new Estorno());
        doNothing().when(cancelaPagamento).executa(anyLong());
        criaEstorno.executa(1L);
        verify(consultaPagamento, times(1)).executa(anyLong());
        verify(repository, times(1)).save(any(Estorno.class));
        verify(cancelaPagamento, times(1)).executa(anyLong());
    }

    @Test
    public void naoCriaEstornoPorErro() {
        when(consultaPagamento.executa(anyLong())).thenReturn(Optional.empty());
        Assertions.assertThrows(PagamentoNaoEncontradoException.class, () -> criaEstorno.executa(1L));
    }
}
