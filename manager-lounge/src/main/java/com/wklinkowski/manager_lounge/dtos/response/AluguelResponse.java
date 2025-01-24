package com.wklinkowski.manager_lounge.dtos.response;

import com.wklinkowski.manager_lounge.entities.CarvaoEntity;
import com.wklinkowski.manager_lounge.entities.FumoEntity;
import com.wklinkowski.manager_lounge.entities.NarguileEntity;
import com.wklinkowski.manager_lounge.entities.RoshEntity;
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

    private Integer numeroMesaAluguel;

    private FumoEntity fumoAluguel;

    private Integer quantidadeFumoUsado;

    private CarvaoEntity carvaoAluguel;

    private Integer quantidadeCarvaoUsado;

    private RoshEntity roshAluguel;

    private Integer quantidadeRoshUsado;

    private NarguileEntity narguileAluguel;

    private Integer quantidadeNarguileUsado;

    private Duration duracaoAluguel;

    private boolean ativoAluguel;
}

