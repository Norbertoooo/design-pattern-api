package com.vitu.design.pattern.web;

import lombok.extern.slf4j.Slf4j;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.StandardCharsets;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class PersonagemResourceTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void criarPersonagemClasseArqueiro() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/personagem/Arqueiro")
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", Matchers.notNullValue()))
                .andExpect(jsonPath("$.classe", Matchers.is("Arqueiro")))
                .andExpect(jsonPath("$.destreza", Matchers.is(10)))
                .andDo(print());
    }

    @Test
    void criarPersonagemClasseMago() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/personagem/Mago")
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", Matchers.notNullValue()))
                .andExpect(jsonPath("$.classe", Matchers.is("Mago")))
                .andExpect(jsonPath("$.magia", Matchers.is(10)))
                .andDo(print());
    }

    @Test
    void criarPersonagemClasseGuerreiro() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/personagem/Guerreiro")
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", Matchers.notNullValue()))
                .andExpect(jsonPath("$.classe", Matchers.is("Guerreiro")))
                .andExpect(jsonPath("$.forca", Matchers.is(10)))
                .andDo(print());
    }

}