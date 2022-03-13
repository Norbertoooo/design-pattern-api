package com.vitu.design.pattern.factory;

import com.vitu.design.pattern.domain.onetoone.uniderecional.Arqueiro;
import com.vitu.design.pattern.domain.onetoone.uniderecional.Guerreiro;
import com.vitu.design.pattern.domain.onetoone.uniderecional.Mago;
import com.vitu.design.pattern.domain.onetoone.uniderecional.Personagem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonagemFactoryTest {

    @Test
    void criarPersonagemArqueiro() {
        Personagem arqueiro = PersonagemFactory.criarPersonagem("Arqueiro");
        Assertions.assertEquals(Arqueiro.class, arqueiro.getClass());
        Assertions.assertEquals("Arqueiro", arqueiro.getClasse());
    }

    @Test
    void criarPersonagemGuerreiro() {
        Personagem guerreiro = PersonagemFactory.criarPersonagem("Guerreiro");
        Assertions.assertEquals(Guerreiro.class, guerreiro.getClass());
        Assertions.assertEquals("Guerreiro", guerreiro.getClasse());
    }

    @Test
    void criarPersonagemMago() {
        Personagem mago = PersonagemFactory.criarPersonagem("Mago");
        Assertions.assertEquals(Mago.class, mago.getClass());
        Assertions.assertEquals("Mago", mago.getClasse());
    }

    @Test
    void naoDeveCriarPersonagemQuandoClasseForInexistente() {
        Personagem mago = PersonagemFactory.criarPersonagem("elfo");
        Assertions.assertNull(mago);
    }
}