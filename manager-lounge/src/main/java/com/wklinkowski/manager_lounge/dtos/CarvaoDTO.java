package com.wklinkowski.manager_lounge.dtos;

import com.wklinkowski.manager_lounge.enums.MarcaCarvao;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 * Classe usada para ajudar na transferência
 * e entrada de dados dos endpoints do carvão,
 * controlando os dados que podem entrar e sair
 * para o client.
 *
 * @author WellingtonKlinkowski
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarvaoDTO {

    @NotNull(message = "A marca do carvão não pode estar vazia.")
    @Enumerated(EnumType.STRING)
    private MarcaCarvao marcaCarvao;

    @Min(value = 1, message = "O peso mínimo para o carvão é 1g.")
    private Integer pesoCarvao = 1;

    @Min(value = 1, message = "A quantidade mínima de carvão permitida é 1.")
    private Integer quantidadeCarvao = 1;

    @Min(value = 1, message = "A quantidade mínima de caixa de carvão permitida é 1.")
    private Integer quantidadeEstoqueCaixaCarvao = 1;

    /**
     * Atríbuto para controle total de carvão sem
     * setter pois é feito por um método dentro da
     * entidade carvão.
     *
     * @author WellingtonKlinkowski
     */
    @Setter(AccessLevel.NONE)
    private Integer quantidadeTotalCarvao;

}
