package com.wklinkowski.manager_lounge.entities;

import com.wklinkowski.manager_lounge.enums.MarcasFumo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Entidade criada para representar de forma
 * básica o fumo usado no aluguel.
 *
 * @author WellingtonKlinkowski
 */
@Entity
@Table(name = "FUMOS")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FumoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MarcasFumo marcasFumo;

    @Column(nullable = false)
    private String saborFumo;

    @Column(nullable = false)
    private Integer pesoFumo = 1;

    @Column(nullable = false)
    private Integer quantidadeEstoqueFumo = 1;

    /**
     * Atríbuto que será usado pra saber a quantidade
     * total atualizada de fumo no estoque.
     *
     * @author WellingtonKlinkowski
     */
    @Column(nullable = false)
    private Integer quantidadeTotalFumo;

    @OneToMany(mappedBy = "id")
    private List<AluguelEntity> aluguelFumo;

    /**
     * Método usado para calcular a quantidade real
     * de fumo no estoque, ajudando posteriormente
     * no controle de entrada e saída.
     *
     * @author WellingtonKlinkowski
     */
    public void calculaQuantidadeTotalDeFumo() {
        this.quantidadeTotalFumo = quantidadeEstoqueFumo * pesoFumo;
    }
}
