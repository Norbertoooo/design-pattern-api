package com.vitu.design.pattern.services;

import com.vitu.design.pattern.domain.onetomany.unidirecional.Estrela;
import com.vitu.design.pattern.domain.onetomany.unidirecional.Galaxia;
import com.vitu.design.pattern.repository.GalaxiaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class GalaxiaService {

    private final GalaxiaRepository galaxiaRepository;

    public Galaxia save(Galaxia galaxia) {
        log.info("Salvando galaxia: {}", galaxia);
        return galaxiaRepository.save(galaxia);
    }

    public Galaxia adicionarEstrela(Long id, Estrela estrela) {
        Optional<Galaxia> byId = galaxiaRepository.findById(id);

        if (byId.isPresent()) {
            Galaxia galaxia = byId.get();
            galaxia.getEstrelas().add(estrela);
            return galaxiaRepository.save(galaxia);
        } else {
            return null;
        }
    }
}
