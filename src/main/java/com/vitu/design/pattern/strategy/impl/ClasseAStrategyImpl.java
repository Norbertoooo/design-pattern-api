package com.vitu.design.pattern.strategy.impl;

import com.vitu.design.pattern.strategy.EstrelaCorStrategy;

public class ClasseAStrategyImpl implements EstrelaCorStrategy {

    @Override
    public String getCor(Character classe) {
        return "Branco";
    }
}
