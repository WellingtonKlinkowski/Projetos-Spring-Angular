package com.wklinkowski.barbearia.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Horarios {

    PRIMEIRO("09:00"),
    SEGUNDO("10:00"),
    TERCEIRO("11:00"),
    QUARTO("12:00"),
    QUINTO("13:00"),
    SEXTO("14:00"),
    SETIMO("15:00"),
    OITAVO("16:00"),
    NONO("17:00"),
    DECIMO("18:00"),
    DECIMO_PRIMEIRO("19:00");

    private final String value;

}
