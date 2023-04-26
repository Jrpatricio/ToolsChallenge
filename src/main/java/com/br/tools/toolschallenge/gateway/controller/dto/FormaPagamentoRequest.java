package com.br.tools.toolschallenge.gateway.controller.dto;

import com.br.tools.toolschallenge.domain.types.Status;
import com.br.tools.toolschallenge.domain.types.TipoPagamento;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class FormaPagamentoRequest {

    @NotNull
    private TipoPagamento tipo;

    @NotNull
    @Positive
    private Integer parcelas;
}
