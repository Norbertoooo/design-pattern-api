package com.vitu.design.pattern.repository;

import com.vitu.design.pattern.domain.Historico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HistoricoRepository extends JpaRepository<Historico, Long> {
    Optional<Historico> findByConta_Id(Long id);
}