package com.wklinkowski.manager_lounge.exceptions;

import jakarta.persistence.EntityNotFoundException;

/**
 * Exception criada para ser usada quando
 * a consulta não retorna registros ou quando
 * não encontra registro com o identificador.
 *
 * @author WellingtonKlinkowski
 */
public class EntidadeNaoEncontrada extends EntityNotFoundException {

    public EntidadeNaoEncontrada() {
        super("Não foi encontrado registro com esse identificador.");
    }
}
