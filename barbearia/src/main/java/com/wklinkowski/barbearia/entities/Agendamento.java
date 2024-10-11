package com.wklinkowski.barbearia.entities;

import com.wklinkowski.barbearia.enums.FormaPagamento;
import com.wklinkowski.barbearia.enums.Horarios;
import com.wklinkowski.barbearia.enums.Servicos;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "AGENDAMENTOS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgendamento;

    @NotNull
    @ManyToOne
    @Column(name = "barbeiro", nullable = false)
    private Barbeiro barbeiroAgendamento;

    @NotNull
    @OneToOne
    @Column(name = "cliente", nullable = false)
    private Cliente idClienteAgendamento;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_servico", nullable = false)
    private Servicos servicoAgendamento;

    @NotNull
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    @Column(name = "data", nullable = false)
    private LocalDate dataAgendamento;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "horario", nullable = false)
    private Horarios horarioAgendamento;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "forma_pagamento", nullable = false)
    private FormaPagamento formaPagamentoAgendamento;

    @NotNull
    @Column(name = "adiantar_horario", nullable = false)
    private boolean adiantarHorarioAgendamento = false;

    @NotNull
    @Column(name = "cancelado", nullable = false)
    private boolean canceladoAgendamento = true;
}
