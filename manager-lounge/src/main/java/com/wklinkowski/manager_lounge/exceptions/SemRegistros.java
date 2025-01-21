package com.wklinkowski.manager_lounge.exceptions;

public class SemRegistros extends RuntimeException {

    public SemRegistros() {
        super("Não há registros que atendam ao filtro solicitado.");
    }
}
