package com.br.tools.toolschallenge.usecase.dto;

import com.br.tools.toolschallenge.domain.types.Status;
import lombok.Data;

@Data
public class DescricaoResponse {

    private String valor;
    private String dataHora;
    private String estabelecimento;
    private String nsu;
    private String codigoAutorizacao;
    private Status status;
}
