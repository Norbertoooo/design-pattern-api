package com.vitu.design.pattern.service;

import com.vitu.design.pattern.domain.onetoone.uniderecional.Personagem;
import com.vitu.design.pattern.factory.PersonagemFactory;
import com.vitu.design.pattern.repository.PersonagemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonagemService {

    private final PersonagemRepository personagemRepository;

    public Personagem criar(String classe) {
        Personagem personagem = PersonagemFactory.criarPersonagem(classe);
        return personagemRepository.save(personagem);
    }

}
