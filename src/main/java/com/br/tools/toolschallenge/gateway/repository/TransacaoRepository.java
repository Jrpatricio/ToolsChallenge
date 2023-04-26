package com.br.tools.toolschallenge.gateway.repository;

import com.br.tools.toolschallenge.domain.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
