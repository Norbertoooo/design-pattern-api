package com.vitu.design.pattern.domain.onetoone.uniderecional;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
public class Mago extends Personagem {

    private Integer magia = 10;

    public Mago() {
        super.setClasse("Mago");
    }

    public Mago(Long id) {
        super.setClasse("Mago");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Mago mago = (Mago) o;
        return getId() != null && Objects.equals(getId(), mago.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
