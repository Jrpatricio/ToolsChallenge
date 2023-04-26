package com.br.tools.toolschallenge.usecase;

import com.br.tools.toolschallenge.domain.FormaPagamento;
import com.br.tools.toolschallenge.gateway.controller.dto.FormaPagamentoRequest;

public interface CriaFormaPagamento {
    FormaPagamento executa(FormaPagamentoRequest formaPagamentoRequest);
}
