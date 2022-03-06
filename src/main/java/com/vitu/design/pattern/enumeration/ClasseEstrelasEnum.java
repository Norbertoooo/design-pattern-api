package com.vitu.design.pattern.enumeration;

import lombok.Getter;

@Getter
public enum ClasseEstrelasEnum {

    A("A"),
    G("G"),
    M("M"),
    O("O");

    private final String nome;

    ClasseEstrelasEnum(String nome) {

        this.nome = nome;
    }
    public static String getClasseA() {
        return A.getNome();
    }
}
