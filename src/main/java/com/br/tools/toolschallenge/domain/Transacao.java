package com.br.tools.toolschallenge.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Transacao extends AuditEvents implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Pagamento pagamento;
}
