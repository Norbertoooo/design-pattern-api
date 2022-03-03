package com.vitu.design.pattern.web.mapper;

import com.vitu.design.pattern.domain.onetomany.unidirecional.Estrela;
import com.vitu.design.pattern.strategy.EstrelaCorStrategy;
import com.vitu.design.pattern.strategy.impl.ClasseAStrategyImpl;
import com.vitu.design.pattern.strategy.impl.ClasseGStrategyImpl;
import com.vitu.design.pattern.strategy.impl.ClasseMStrategyImpl;
import com.vitu.design.pattern.web.dto.EstrelaDto;
import org.springframework.stereotype.Component;

@Component
public class EstrelaMapper {

    public Estrela toDomain(EstrelaDto estrelaDto) {
        return Estrela.builder()
                .nome(estrelaDto.nome())
                .classe(estrelaDto.classe())
                .cor(getCor(estrelaDto.classe()))
                .build();
    }

    public String getCor(Character classe) {
        return switch (classe) {
            case 'A' -> getStrategy(new ClasseAStrategyImpl(), classe);
            case 'M' -> getStrategy(new ClasseMStrategyImpl(), classe);
            default -> getStrategy(new ClasseGStrategyImpl(), classe);
        };
    }

    public String getStrategy(EstrelaCorStrategy estrelaCorStrategy, Character classe) {
        return estrelaCorStrategy.getCor(classe);
    }
}
