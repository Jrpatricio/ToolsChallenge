package com.br.tools.toolschallenge.usecase;

import com.br.tools.toolschallenge.domain.Pagamento;
import com.br.tools.toolschallenge.domain.types.Status;

import java.util.Optional;

public interface ConsultaPagamento {
    Optional<Pagamento> executa(Long pagamentoId, Status... status);
}
