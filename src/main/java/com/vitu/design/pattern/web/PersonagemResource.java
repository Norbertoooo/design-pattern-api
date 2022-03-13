package com.vitu.design.pattern.web;

import com.vitu.design.pattern.domain.onetoone.uniderecional.Personagem;
import com.vitu.design.pattern.service.PersonagemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/personagem")
public class PersonagemResource {

    private final PersonagemService personagemService;

    @GetMapping("/{classe}")
    public ResponseEntity<Personagem> criar(@PathVariable String classe) {
        Personagem personagem = personagemService.criar(classe);
        return ResponseEntity.status(CREATED).body(personagem);
    }
}
