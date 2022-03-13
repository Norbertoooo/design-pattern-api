package com.vitu.design.pattern.repository;

import com.vitu.design.pattern.domain.onetoone.uniderecional.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
}