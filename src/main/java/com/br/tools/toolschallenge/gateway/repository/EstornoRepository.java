package com.br.tools.toolschallenge.gateway.repository;

import com.br.tools.toolschallenge.domain.Estorno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstornoRepository extends JpaRepository<Estorno, Long> {
}
