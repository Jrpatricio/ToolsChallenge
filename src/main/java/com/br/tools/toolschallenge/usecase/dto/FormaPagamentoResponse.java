package com.br.tools.toolschallenge.usecase.dto;

import com.br.tools.toolschallenge.domain.types.TipoPagamento;
import lombok.Data;

@Data
public class FormaPagamentoResponse {

    private TipoPagamento tipo;
    private String parcelas;
}
