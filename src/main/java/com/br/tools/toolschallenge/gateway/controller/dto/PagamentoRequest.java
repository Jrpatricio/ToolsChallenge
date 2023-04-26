package com.br.tools.toolschallenge.gateway.controller.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PagamentoRequest {

    @NotNull
    private TransacaoRequest transacao;
}
