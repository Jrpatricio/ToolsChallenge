package com.br.tools.toolschallenge.usecase.dto;

import lombok.Data;

@Data
public class TransacaoResponse {

    private String id;
    private String cartao;
    private DescricaoResponse descricao;
    private FormaPagamentoResponse formaPagamento;
}
