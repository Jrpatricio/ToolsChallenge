package com.br.tools.toolschallenge.domain;

import com.br.tools.toolschallenge.domain.types.TipoPagamento;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class FormaPagamento extends AuditEvents{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated
    private TipoPagamento tipoPagamento;

    @Positive
    private Integer parcelas;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Pagamento pagamento;
}
