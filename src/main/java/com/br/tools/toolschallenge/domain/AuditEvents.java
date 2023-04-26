package com.br.tools.toolschallenge.domain;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class AuditEvents {

    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    @PrePersist
    public void setCreatedAt() {
        this.createdAt = LocalDateTime.now();
        this.updateAt = LocalDateTime.now();
    }

    @PreUpdate
    public void setUpdateAt() {
        this.updateAt = LocalDateTime.now();
    }
}
