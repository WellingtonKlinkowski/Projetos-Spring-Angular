package com.wklinkowski.manager_lounge.exceptions;

public class InsumoInsuficienteException extends RuntimeException {

    public InsumoInsuficienteException(String nomeProdutoFaltante) {
        super("A quantidade em estoque está abaixo ou zerado para o produto " + nomeProdutoFaltante);
    }
}
