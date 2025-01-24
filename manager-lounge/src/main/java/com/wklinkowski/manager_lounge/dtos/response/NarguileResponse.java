package com.wklinkowski.manager_lounge.dtos.response;

import com.wklinkowski.manager_lounge.enums.MarcasNarguile;
import com.wklinkowski.manager_lounge.enums.MaterialNarguile;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe usada para ajudar na resposta
 * de dados dos endpoints do narguile,
 * controlando os dados que podem sair
 * para o client.
 *
 * @author WellingtonKlinkowski
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NarguileResponse {

    private String nomeNarguile;

    @Enumerated(EnumType.STRING)
    private MarcasNarguile marcasNarguile;

    private Integer quantidadeMangueirasNarguile;

    @Enumerated(EnumType.STRING)
    private MaterialNarguile materialNarguile;

    private Integer quantidadeEstoqueNarguile;
}
