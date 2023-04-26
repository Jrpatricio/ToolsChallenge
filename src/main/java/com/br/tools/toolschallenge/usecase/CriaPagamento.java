package com.br.tools.toolschallenge.usecase;

import com.br.tools.toolschallenge.domain.Pagamento;
import com.br.tools.toolschallenge.gateway.controller.dto.PagamentoRequest;

public interface CriaPagamento {
    Pagamento executa(PagamentoRequest pagamentoRequest);
}
