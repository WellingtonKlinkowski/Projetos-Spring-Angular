package com.wklinkowski.manager_lounge.dtos.response;

import com.wklinkowski.manager_lounge.enums.MarcaCarvao;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe usada para ajudar na resposta
 * de dados dos endpoints do carvão,
 * controlando os dados que podem sair
 * para o client.
 *
 * @author WellingtonKlinkowski
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarvaoResponse {

    @Enumerated(EnumType.STRING)
    private MarcaCarvao marcaCarvao;

    private Integer pesoCarvao;

    private Integer quantidadeCarvao;

    private Integer quantidadeEstoqueCaixaCarvao;

    private Integer quantidadeTotalCarvao;
}
