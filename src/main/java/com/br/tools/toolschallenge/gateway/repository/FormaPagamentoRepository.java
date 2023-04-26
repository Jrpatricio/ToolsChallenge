package com.br.tools.toolschallenge.gateway.repository;

import com.br.tools.toolschallenge.domain.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long> {
}
