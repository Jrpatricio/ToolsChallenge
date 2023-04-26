package com.br.tools.toolschallenge.usecase;

import com.br.tools.toolschallenge.domain.types.Status;
import com.br.tools.toolschallenge.usecase.dto.PagamentoResponse;

import java.util.List;

public interface ConsultaPagamentos {
    List<PagamentoResponse> executa(Status... status);
}
