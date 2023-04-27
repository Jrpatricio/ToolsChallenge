package com.br.tools.toolschallenge.usecase;

import com.br.tools.toolschallenge.domain.FormaPagamento;
import com.br.tools.toolschallenge.domain.Pagamento;
import com.br.tools.toolschallenge.domain.Transacao;
import com.br.tools.toolschallenge.fixture.FormaPagamentoFixture;
import com.br.tools.toolschallenge.fixture.PagamentoFixture;
import com.br.tools.toolschallenge.gateway.controller.dto.FormaPagamentoRequest;
import com.br.tools.toolschallenge.gateway.controller.dto.PagamentoRequest;
import com.br.tools.toolschallenge.gateway.repository.PagamentoRepository;
import com.br.tools.toolschallenge.interfaceadapter.converter.PagamentoConverter;
import com.br.tools.toolschallenge.usecase.impl.CriaPagamentoImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CriaPagamentoImplTest {

    @Mock
    private CriaTransacao criaTransacao;

    @Mock
    private CriaFormaPagamento criaFormaPagamento;

    @Mock
    private PagamentoConverter converter;

    @Mock
    private PagamentoRepository repository;

    @InjectMocks
    private CriaPagamentoImpl criaPagamento;

    @Test
    public void criaPagamento(){
        when(criaTransacao.executa()).thenReturn(new Transacao());
        when(criaFormaPagamento.executa(any(FormaPagamentoRequest.class))).thenReturn(new FormaPagamentoFixture().getFormaPagamento());
        when(converter.executa(any(PagamentoRequest.class), any(Transacao.class), any(FormaPagamento.class))).thenReturn(new Pagamento());
        when(repository.save(any(Pagamento.class))).thenReturn(new Pagamento());
        criaPagamento.executa(new PagamentoFixture().getPagamentoResquest());
        verify(criaTransacao, times(1)).executa();
        verify(criaFormaPagamento, times(1)).executa(any(FormaPagamentoRequest.class));
        verify(repository, times(1)).save(any(Pagamento.class));
    }
}
