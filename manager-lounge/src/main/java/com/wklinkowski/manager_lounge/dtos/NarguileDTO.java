package com.wklinkowski.manager_lounge.dtos;

import com.wklinkowski.manager_lounge.enums.MarcasNarguile;
import com.wklinkowski.manager_lounge.enums.MaterialNarguile;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe usada para ajudar na transferência
 * e entrada de dados dos endpoints do narguile,
 * controlando os dados que podem entrar e sair
 * para o client.
 *
 * @author WellingtonKlinkowski
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NarguileDTO {

    @NotBlank(message = "O nome não pode estar vazio.")
    @Size(min = 3, max = 50, message = "O nome deve ter entre 3 a 50 letras.")
    private String nomeNarguile;

    @NotNull(message = "A marca não pode estar vazia.")
    @Enumerated(EnumType.STRING)
    private MarcasNarguile marcasNarguile;

    @Min(value = 1, message = "A narguile deve ter mangueiras.")
    private Integer quantidadeMangueirasNarguile = 1;

    @NotNull(message = "O material não pode estar vazio.")
    @Enumerated(EnumType.STRING)
    private MaterialNarguile materialNarguile;

    @Min(value = 1, message = "A quantidade de narguile deve ser igual a 1.")
    private Integer quantidadeEstoqueNarguile = 1;
}
