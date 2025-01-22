package com.wklinkowski.manager_lounge.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wklinkowski.manager_lounge.converters.DurationConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Entidade criada para representar de forma
 * básica um aluguel de narguile.
 *
 * @author WellingtonKlinkowski
 */
@Entity
@Table(name = "ALUGUEIS")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AluguelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer numeroMesaAluguel;

    @ManyToOne
    private FumoEntity fumoAluguel;

    @Column(nullable = false)
    private Integer quantidadeFumoUsado;

    @ManyToOne
    private CarvaoEntity carvaoAluguel;

    @Column(nullable = false)
    private Integer quantidadeCarvaoUsado;

    @ManyToOne
    private RoshEntity roshAluguel;

    @Column(nullable = false)
    private Integer quantidadeRoshUsado;

    @ManyToOne
    private NarguileEntity narguileAluguel;

    @Column(nullable = false)
    private Integer quantidadeNarguileUsado;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAluguel = LocalDate.now();

    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime horaAluguel = LocalDateTime.now();

    /**
     * Atríbuto usado para identificar o estado
     * atual do aluguel em tempo, comparando com
     * a hora do aluguel e a duração recebida.
     *
     * @author WellingtonKlinkowski
     */
    @Column(nullable = false)
    @Convert(converter = DurationConverter.class)
    private Duration duracaoAluguel;

    /**
     * Atríbuto usado para definir se o aluguel
     * expirou/acabou ou se ainda está ativo,
     * ajudando no controle dos materias não
     * consumíveis.
     *
     * @author WellingtonKlinkowski
     */
    @Column(nullable = false)
    private boolean ativoAluguel;
}
