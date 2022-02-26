package com.vitu.design.pattern.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vitu.design.pattern.domain.Conta;
import com.vitu.design.pattern.domain.Historico;
import com.vitu.design.pattern.repository.ContaRepository;
import com.vitu.design.pattern.repository.HistoricoRepository;
import com.vitu.design.pattern.services.ContaService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
class ContaResourceTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    HistoricoRepository historicoRepository;

    @Test
    void create() throws Exception {
        Conta conta = new Conta();
        conta.setNome("first");
        mockMvc.perform(post("/conta")
                        .content(new ObjectMapper().writeValueAsString(conta))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.historico", hasSize(1)))
                .andDo(print());
        Optional<Historico> byConta_id = historicoRepository.findByConta_Id(1L);
        log.info(byConta_id.toString());

    }
}