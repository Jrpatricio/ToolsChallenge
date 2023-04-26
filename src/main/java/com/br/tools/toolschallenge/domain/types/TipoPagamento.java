package com.br.tools.toolschallenge.domain.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoPagamento {

    AVISTA("AVISTA"),
    PARCELADOLOJA("PARCELADO LOJA"),
    PARCELADOEMISSOR("PARCELADO EMISSOR");

    private final String value;
}
