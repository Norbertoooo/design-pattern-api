package com.vitu.design.pattern.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vitu.design.pattern.domain.onetomany.unidirecional.Estrela;
import com.vitu.design.pattern.domain.onetomany.unidirecional.Galaxia;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.nio.charset.StandardCharsets;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("integration-test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Testcontainers
class GalaxiaResourceTest {

    // TODO: 06/03/2022 corrigir uso da anotação de order, pois quebra o conceito de teste ser independente
    @Autowired
    MockMvc mockMvc;

    @Container
    public static MySQLContainer<?> mysql = new MySQLContainer<>(DockerImageName.parse("mysql:5.7.37"));

    @DynamicPropertySource
    public static void setDatasourceProperties(final DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mysql::getJdbcUrl);
        registry.add("spring.datasource.password", mysql::getPassword);
        registry.add("spring.datasource.username", mysql::getUsername);
    }

    @Test
    @Order(1)
    @DisplayName("Deve criar nova galaxia com sucesso")
    void create() throws Exception {

        Galaxia galaxia = Galaxia.builder().nome("Via Láctea").build();

        mockMvc.perform(post("/galaxia")
                        .content(new ObjectMapper().writeValueAsString(galaxia))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", Matchers.notNullValue()))
                .andExpect(jsonPath("$.nome", Matchers.is("Via Láctea")))
                .andDo(print());
    }

    @Test
    @Order(1)
    void adicionarEstrelaClasseA() throws Exception {

        Estrela estrela = Estrela.builder().classe('A').nome("ESTRELA A").build();

        mockMvc.perform(post("/galaxia/1")
                        .content(new ObjectMapper().writeValueAsString(estrela))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.estrelas", Matchers.hasSize(1)))
                .andExpect(jsonPath("$.estrelas.[0].id", Matchers.notNullValue()))
                .andExpect(jsonPath("$.estrelas.[0].cor", Matchers.is("Branco")))
                .andExpect(jsonPath("$.estrelas.[0].classe", Matchers.is("A")))
                .andDo(print());

    }

    @Test
    @Order(2)
    void adicionarEstrelaClasseM() throws Exception {

        Estrela estrela = Estrela.builder().classe('M').nome("ESTRELA M").build();

        mockMvc.perform(post("/galaxia/1")
                        .content(new ObjectMapper().writeValueAsString(estrela))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.estrelas", Matchers.hasSize(2)))
                .andExpect(jsonPath("$.estrelas.[1].id", Matchers.notNullValue()))
                .andExpect(jsonPath("$.estrelas.[1].cor", Matchers.is("Vermelho alaranjado")))
                .andExpect(jsonPath("$.estrelas.[1].classe", Matchers.is("M")))
                .andDo(print());


    }

    @Test
    @Order(3)
    void adicionarEstrelaClasseG() throws Exception {

        Estrela estrela = Estrela.builder().classe('G').nome("ESTRELA G").build();

        mockMvc.perform(post("/galaxia/1")
                        .content(new ObjectMapper().writeValueAsString(estrela))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.estrelas", Matchers.hasSize(3)))
                .andExpect(jsonPath("$.estrelas.[2].id", Matchers.notNullValue()))
                .andExpect(jsonPath("$.estrelas.[2].cor", Matchers.is("Amarelo")))
                .andExpect(jsonPath("$.estrelas.[2].classe", Matchers.is("G")))
                .andDo(print());

    }

    @Test
    @Order(4)
    void adicionarEstrelaClasseO() throws Exception {

        Estrela estrela = Estrela.builder().classe('O').nome("ESTRELA O").build();

        mockMvc.perform(post("/galaxia/1")
                        .content(new ObjectMapper().writeValueAsString(estrela))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.estrelas", Matchers.hasSize(4)))
                .andExpect(jsonPath("$.estrelas.[3].id", Matchers.notNullValue()))
                .andExpect(jsonPath("$.estrelas.[3].cor", Matchers.is("Azul")))
                .andExpect(jsonPath("$.estrelas.[3].classe", Matchers.is("O")))
                .andDo(print());

    }
}