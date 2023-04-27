package com.br.tools.toolschallenge.gateway.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransacaoRequest {

    @NotNull
    private Long id;

    @NotBlank
    private String cartao;

    @NotNull
    private DescricaoRequest descricao;

    @NotNull
    private FormaPagamentoRequest formaPagamento;
}
