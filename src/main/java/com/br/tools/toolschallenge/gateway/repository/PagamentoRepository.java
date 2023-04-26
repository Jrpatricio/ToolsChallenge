package com.br.tools.toolschallenge.gateway.repository;

import com.br.tools.toolschallenge.domain.Pagamento;
import com.br.tools.toolschallenge.domain.types.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {


    @Modifying
    @Query("UPDATE Pagamento p SET p.status = :status WHERE p.id = :id")
    void updatePagamento(@Param("id") Long id, @Param("status") Status status);

    Optional<Pagamento> findByIdAndStatus(Long Id, Status status);

    List<Pagamento> findAllByStatus(Status status);
}
