package com.vitu.design.pattern.factory;

import com.vitu.design.pattern.domain.onetoone.uniderecional.Arqueiro;
import com.vitu.design.pattern.domain.onetoone.uniderecional.Guerreiro;
import com.vitu.design.pattern.domain.onetoone.uniderecional.Mago;
import com.vitu.design.pattern.domain.onetoone.uniderecional.Personagem;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public abstract class PersonagemFactory {

    public static Personagem criarPersonagem(String classe) {
        switch (classe) {
            case "Guerreiro":
                log.info("Criando novo guerreiro");
                return new Guerreiro();
            case "Arqueiro":
                log.info("Criando novo arqueiro");
                return new Arqueiro();
            case "Mago":
                log.info("Criando novo mago");
                return new Mago();
            default:
                return null;
        }
    }

}
