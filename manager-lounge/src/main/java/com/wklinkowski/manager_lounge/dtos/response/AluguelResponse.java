package com.wklinkowski.manager_lounge.dtos.response;

import com.wklinkowski.manager_lounge.entities.CarvaoEntity;
import com.wklinkowski.manager_lounge.entities.FumoEntity;
import com.wklinkowski.manager_lounge.entities.NarguileEntity;
import com.wklinkowski.manager_lounge.entities.RoshEntity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;

/**
 * Classe usada para ajudar na resposta
 * de dados dos endpoints do aluguel,
 * controlando os dados que podem entrar
 * para o client.
 *
 * @author WellingtonKlinkowski
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AluguelResponse {

    @Min(value = 1, message = "O número da mesa mínimo para o aluguel é 1.")
    private Integer numeroMesaAluguel;

    @NotNull(message = "O fumo não pode estar vazio.")
    private FumoEntity fumoAluguel;

    @NotNull(message = "A quantidade de fumo usado não pode estar vazio.")
    private Integer quantidadeFumoUsado;

    @NotNull(message = "O carvão não pode estar vazio.")
    private CarvaoEntity carvaoAluguel;

    @NotNull(message = "A quantidade de carvão usado não pode estar vazio.")
    private Integer quantidadeCarvaoUsado;

    @NotNull(message = "O rosh não pode estar vazio.")
    private RoshEntity roshAluguel;

    @NotNull(message = "A quantidade de rosh usado não pode estar vazio.")
    private Integer quantidadeRoshUsado;

    @NotNull(message = "A narguile não pode estar vazia.")
    private NarguileEntity narguileAluguel;

    @NotNull(message = "A quantidade de narguile usado não pode estar vazio.")
    private Integer quantidadeNarguileUsado;

    @PastOrPresent
    @NotNull(message = "A duração do aluguel não pode estar vazio.")
    private Duration duracaoAluguel;

    @NotNull(message = "É preciso informar a situação em que o aluguel está.")
    private boolean ativoAluguel;
}

