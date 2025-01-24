package com.wklinkowski.manager_lounge.dtos.response;

import com.wklinkowski.manager_lounge.enums.MarcasFumo;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe usada para ajudar na resposta
 * de dados dos endpoints do fumo,
 * controlando os dados que podem sair
 * para o client.
 *
 * @author WellingtonKlinkowski
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FumoResponse {

    @Enumerated(EnumType.STRING)
    private MarcasFumo marcasFumo;

    private String saborFumo;

    private Integer pesoFumo;

    private Integer quantidadeEstoqueFumo;

    private Integer quantidadeTotalFumo;
}
