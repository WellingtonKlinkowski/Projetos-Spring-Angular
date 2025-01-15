package com.wklinkowski.manager_lounge.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "ALUGUEIS")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class AluguelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer numeroMesaAluguel;

    @ManyToOne
    private FumoEntity fumoAluguel;

    @ManyToOne
    private CarvaoEntity carvaoAluguel;

    @ManyToOne
    private RoshEntity roshAluguel;

    @ManyToOne
    private NarguileEntity narguileAluguel;

    @Column(nullable = false)
    private LocalDate dataAluguel = LocalDate.now();

    @Column(nullable = false)
    private LocalDateTime horaAluguel = LocalDateTime.now();

    @Column(nullable = false)
    private Duration duracaoAluguel;

}
