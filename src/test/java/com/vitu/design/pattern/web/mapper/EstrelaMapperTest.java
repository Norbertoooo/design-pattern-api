package com.vitu.design.pattern.web.mapper;

import com.vitu.design.pattern.domain.onetomany.unidirecional.Estrela;
import com.vitu.design.pattern.strategy.EstrelaCorStrategy;
import com.vitu.design.pattern.strategy.impl.ClasseAStrategyImpl;
import com.vitu.design.pattern.strategy.impl.ClasseGStrategyImpl;
import com.vitu.design.pattern.strategy.impl.ClasseMStrategyImpl;
import com.vitu.design.pattern.strategy.impl.ClasseOStrategyImpl;
import com.vitu.design.pattern.web.dto.EstrelaDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Map;

@ExtendWith(SpringExtension.class)
class EstrelaMapperTest {

    EstrelaMapper estrelaMapper;

    @BeforeEach
    void setUp() {
        Map<String, EstrelaCorStrategy> strategyMap = Map.of(
                "M", new ClasseMStrategyImpl(),
                "O", new ClasseOStrategyImpl(),
                "A", new ClasseAStrategyImpl(),
                "G", new ClasseGStrategyImpl());

        estrelaMapper = new EstrelaMapper(strategyMap);
    }

    @Test
    public void deveRetornarCorVermelhoAlaranjadoQuandoForClasseM() {
        EstrelaDto estrelaDto = new EstrelaDto("sol", 'M');
        Estrela estrela = estrelaMapper.toDomain(estrelaDto);
        Assertions.assertEquals("Vermelho alaranjado", estrela.getCor());
    }

    @Test
    public void deveRetornarCorAzulQuandoForClasseO() {
        EstrelaDto estrelaDto = new EstrelaDto("sol", 'O');
        Estrela estrela = estrelaMapper.toDomain(estrelaDto);
        Assertions.assertEquals("Azul", estrela.getCor());
    }

    @Test
    public void deveRetornarCorBrancaQuandoForClasseA() {
        EstrelaDto estrelaDto = new EstrelaDto("sol", 'A');
        Estrela estrela = estrelaMapper.toDomain(estrelaDto);
        Assertions.assertEquals("Branco", estrela.getCor());
    }

    @Test
    public void deveRetornarCorAmarelaQuandoForClasseG() {
        EstrelaDto estrelaDto = new EstrelaDto("sol", 'G');
        Estrela estrela = estrelaMapper.toDomain(estrelaDto);
        Assertions.assertEquals("Amarelo", estrela.getCor());
    }

}