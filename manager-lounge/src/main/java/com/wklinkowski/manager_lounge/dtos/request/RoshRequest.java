package com.wklinkowski.manager_lounge.dtos.request;

import com.wklinkowski.manager_lounge.enums.MarcasRosh;
import com.wklinkowski.manager_lounge.enums.MaterialRosh;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe usada para ajudar na entrada
 * de dados dos endpoints do rosh,
 * controlando os dados que entrarem
 * do client.
 *
 * @author WellingtonKlinkowski
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoshRequest {

    @NotNull(message = "A marca do rosh não pode estar vazia.")
    @Enumerated(EnumType.STRING)
    private MarcasRosh marcasRosh;

    @NotNull(message = "O material do rosh não pode estar vazio.")
    @Enumerated(EnumType.STRING)
    private MaterialRosh materialRosh;

    @Min(value = 1, message = "A quantidade de rosh deve ser igual a 1.")
    private Integer quantidadeEstoqueRosh = 1;
}
