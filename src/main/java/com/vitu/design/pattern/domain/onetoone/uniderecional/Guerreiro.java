package com.vitu.design.pattern.domain.onetoone.uniderecional;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
public class Guerreiro extends Personagem {

    private Integer forca = 10;

    public Guerreiro() {
        super.setClasse("Guerreiro");
    }

    public Guerreiro(Long id) {
        super.setClasse("Guerreiro");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Guerreiro guerreiro = (Guerreiro) o;
        return getId() != null && Objects.equals(getId(), guerreiro.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
