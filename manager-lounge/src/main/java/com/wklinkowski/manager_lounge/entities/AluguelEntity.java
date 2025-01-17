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

    @ManyToOne
    private CarvaoEntity carvaoAluguel;

    @ManyToOne
    private RoshEntity roshAluguel;

    @ManyToOne
    private NarguileEntity narguileAluguel;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAluguel = LocalDate.now();

    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime horaAluguel = LocalDateTime.now();

    @Column(nullable = false)
    @Convert(converter = DurationConverter.class)
    private Duration duracaoAluguel;

    @Column(nullable = false)
    private boolean ativoAluguel;
}
