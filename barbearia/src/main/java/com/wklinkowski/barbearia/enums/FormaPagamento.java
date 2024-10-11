package com.wklinkowski.barbearia.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FormaPagamento {

    PIX("Pix"),
    CARTAO_CREDITO("Cartão de crédito"),
    CARTAO_DEBITO("Cartão de débito"),
    DINHEIRO("Dinheiro");

    private final String value;
}
