package com.vitu.design.pattern.web.mapper;

import com.vitu.design.pattern.domain.onetomany.unidirecional.Estrela;
import com.vitu.design.pattern.strategy.EstrelaCorStrategy;
import com.vitu.design.pattern.web.dto.EstrelaDto;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class EstrelaMapper {

    // spring automaticamente injeta todas as classes concretas do strategy sendo a key do map o nome da classe ou
    // o nome passado no @component

    private final Map<String, EstrelaCorStrategy> strategyMap;

    public EstrelaMapper(Map<String, EstrelaCorStrategy> strategyMap) {
        this.strategyMap = strategyMap;
    }

    public Estrela toDomain(EstrelaDto estrelaDto) {
        return Estrela.builder()
                .nome(estrelaDto.nome())
                .classe(estrelaDto.classe())
                .cor(getCor(estrelaDto.classe()))
                .build();
    }

    public String getCor(Character classe) {
        return strategyMap.get(classe.toString()).getCor(classe);
    }

}
