package com.wklinkowski.manager_lounge.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class EntidadeNaoEncontrada extends EntityNotFoundException {
    public EntidadeNaoEncontrada() {
        super("Não foi encontrado registro com esse identificador.");
    }
}
