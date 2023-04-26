package com.br.tools.toolschallenge.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Estorno extends AuditEvents{

    @Id
    private Long id;

    @OneToOne
    private Transacao transacao;
}
