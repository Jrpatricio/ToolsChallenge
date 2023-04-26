package com.br.tools.toolschallenge.domain;

import com.br.tools.toolschallenge.domain.types.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Pagamento extends AuditEvents implements Serializable {


    @Id
    private Long id;

    @NotBlank
    private String cartao;

    @NotBlank
    private String estabelecimento;

    @NotBlank
    private String nsu;

    @NotBlank
    private String codigoAutorizacao;

    @NotNull
    private LocalDateTime dataHora;

    @NotNull
    private BigDecimal valor;

    @Enumerated
    private Status status;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private FormaPagamento formaPagamento;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Transacao transacao;
}
