package com.vitu.design.pattern.strategy.impl;

import com.vitu.design.pattern.strategy.EstrelaCorStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("A")
public class ClasseAStrategyImpl implements EstrelaCorStrategy {

    @Override
    public String getCor(Character classe) {
        log.info("Estratégia para estrela de classe A");
        return "Branco";
    }
}
