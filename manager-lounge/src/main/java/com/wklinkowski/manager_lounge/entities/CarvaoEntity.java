package com.wklinkowski.manager_lounge.entities;

import com.wklinkowski.manager_lounge.enums.MarcaCarvao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Entidade criada para representar de forma
 * básica o carvão usado no aluguel.
 *
 * @author WellingtonKlinkowski
 */
@Entity
@Table(name = "CARVOES")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarvaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MarcaCarvao marcaCarvao;

    @Column(nullable = false)
    private Integer pesoCarvao = 1;

    @Column(nullable = false)
    private Integer quantidadeCarvao = 1;

    @Column(nullable = false)
    private Integer quantidadeEstoqueCaixaCarvao = 1;

    /**
     * Atríbuto que será usado pra saber a quantidade
     * total atualizada de carvão no estoque.
     *
     * @author WellingtonKlinkowski
     */
    @Column(nullable = false)
    private Integer quantidadeTotalCarvao;

    @OneToMany(mappedBy = "id")
    private List<AluguelEntity> aluguelCarvao;

    /**
     * Método usado para calcular a quantidade real
     * de carvão no estoque, ajudando posteriormente
     * no controle de entrada e saída.
     *
     * @author WellingtonKlinkowski
     */
    public void calculaQuantidadeTotalDeCarvao() {
        this.quantidadeTotalCarvao = quantidadeEstoqueCaixaCarvao * quantidadeCarvao;
    }
}
