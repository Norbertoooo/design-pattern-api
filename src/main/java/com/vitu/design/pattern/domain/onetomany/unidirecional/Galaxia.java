package com.vitu.design.pattern.domain.onetomany.unidirecional;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Galaxia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "galaxy_id", foreignKey = @ForeignKey(name = "fk_estrela_galaxy_id"))
    private List<Estrela> estrelas = new ArrayList<>();
}
