package com.wklinkowski.manager_lounge.exceptions;

/**
 * Exception criada para ser usada quando
 * o insumo disponível em estoque é menor
 * que o exigido para a criação do aluguel.
 *
 * @author WellingtonKlinkowski
 */
public class InsumoInsuficienteException extends RuntimeException {

    public InsumoInsuficienteException(String nomeProdutoFaltante) {
        super("A quantidade em estoque está abaixo ou zerado para o produto " + nomeProdutoFaltante);
    }
}
