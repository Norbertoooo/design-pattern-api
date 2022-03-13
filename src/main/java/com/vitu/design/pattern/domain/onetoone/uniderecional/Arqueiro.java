package com.vitu.design.pattern.domain.onetoone.uniderecional;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
public class Arqueiro extends Personagem {

    private Integer destreza = 10;

    public Arqueiro() {
        super.setClasse("Arqueiro");
    }

    public Arqueiro(Long id) {
        super.setClasse("Arqueiro");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Arqueiro arqueiro = (Arqueiro) o;
        return getId() != null && Objects.equals(getId(), arqueiro.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
