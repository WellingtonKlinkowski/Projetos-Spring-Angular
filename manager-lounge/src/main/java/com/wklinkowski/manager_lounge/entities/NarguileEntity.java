package com.wklinkowski.manager_lounge.entities;

import com.wklinkowski.manager_lounge.enums.MarcasNarguile;
import com.wklinkowski.manager_lounge.enums.MaterialNarguile;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Entidade criada para representar de forma
 * básica a narguile usada no aluguel.
 *
 * @author WellingtonKlinkowski
 */
@Entity
@Table(name = "NARGUILES")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NarguileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeNarguile;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MarcasNarguile marcasNarguile;

    @Column(nullable = false)
    private Integer quantidadeMangueirasNarguile = 1;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MaterialNarguile materialNarguile;

    @Column(nullable = false)
    private Integer quantidadeEstoqueNarguile = 1;

    @OneToMany(mappedBy = "id")
    private List<AluguelEntity> aluguelNarguile;
}
