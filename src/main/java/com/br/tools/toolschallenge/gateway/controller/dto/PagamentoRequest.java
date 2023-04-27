package com.br.tools.toolschallenge.gateway.controller.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoRequest {

    @NotNull
    private TransacaoRequest transacao;
}
