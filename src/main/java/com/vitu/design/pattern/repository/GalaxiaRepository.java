package com.vitu.design.pattern.repository;

import com.vitu.design.pattern.domain.onetomany.unidirecional.Galaxia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GalaxiaRepository extends JpaRepository<Galaxia, Long> {
}