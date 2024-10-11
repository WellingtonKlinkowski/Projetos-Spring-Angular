package com.wklinkowski.barbearia.enums;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Servicos {

    BARBA("Barba"),
    CABELO_DEGRADE("Corte de cabelo degrâde"),
    CABELO_TESOURA("Corte de cabelo na tesoura"),
    CABELO_SEM_DEGRADE("Corte de cabelo sem degrâde"),
    CABELO_NAVALHA("Corte de cabelo navalhado"),
    BARBA_MAQUINA("Barba na máquina"),
    BARBA_NAVALHA("Barba na navalha");

    private final String value;

    }
