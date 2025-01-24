package com.wklinkowski.manager_lounge.dtos.response;

import com.wklinkowski.manager_lounge.enums.MarcaCarvao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe usada para ajudar na saída
 * de dados dos endpoints do carvão,
 * controlando os dados que podem entrar
 * e sair para o client.
 *
 * @author WellingtonKlinkowski
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarvaoResponse {

    private MarcaCarvao marcaCarvao;

    private Integer pesoCarvao;

    private Integer quantidadeCarvao;

    private Integer quantidadeEstoqueCaixaCarvao;

    private Integer quantidadeTotalCarvao;
}
