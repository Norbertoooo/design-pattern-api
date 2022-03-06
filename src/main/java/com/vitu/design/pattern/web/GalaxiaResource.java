package com.vitu.design.pattern.web;

import com.vitu.design.pattern.domain.onetomany.unidirecional.Galaxia;
import com.vitu.design.pattern.service.GalaxiaService;
import com.vitu.design.pattern.web.dto.EstrelaDto;
import com.vitu.design.pattern.web.mapper.EstrelaMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/galaxia")
public class GalaxiaResource {

    private final GalaxiaService galaxiaService;
    private final EstrelaMapper estrelaMapper;

    @PostMapping
    public ResponseEntity<Galaxia> criar(@RequestBody Galaxia galaxia) {
        log.info("Requisição para criar nova galaxia: {}", galaxia);
        Galaxia CreatedGalaxia = galaxiaService.save(galaxia);
        log.info("{}", CreatedGalaxia);
        return ResponseEntity.status(CREATED).body(CreatedGalaxia);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Galaxia> adicionarEstrela(@PathVariable Long id, @RequestBody EstrelaDto estrelaDto) {
        log.info("Requisição para adicionar estrela: {} na galaxia de id: {}", estrelaDto, id);
        Galaxia CreatedGalaxia = galaxiaService.adicionarEstrela(id, estrelaMapper.toDomain(estrelaDto));
        log.info("{}", CreatedGalaxia);
        return ResponseEntity.status(CREATED).body(CreatedGalaxia);
    }
}
