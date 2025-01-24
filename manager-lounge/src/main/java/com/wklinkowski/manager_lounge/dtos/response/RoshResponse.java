package com.wklinkowski.manager_lounge.dtos.response;

import com.wklinkowski.manager_lounge.enums.MarcasRosh;
import com.wklinkowski.manager_lounge.enums.MaterialRosh;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe usada para ajudar na resposta
 * de dados dos endpoints do rosh,
 * controlando os dados que podem sair
 * para o client.
 *
 * @author WellingtonKlinkowski
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoshResponse {

    @Enumerated(EnumType.STRING)
    private MarcasRosh marcasRosh;

    @Enumerated(EnumType.STRING)
    private MaterialRosh materialRosh;

    private Integer quantidadeEstoqueRosh;
}
