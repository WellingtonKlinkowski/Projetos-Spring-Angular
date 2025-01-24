package com.wklinkowski.manager_lounge.interfaces;

import com.wklinkowski.manager_lounge.dtos.request.AluguelRequest;
import com.wklinkowski.manager_lounge.dtos.response.AluguelResponse;
import com.wklinkowski.manager_lounge.entities.AluguelEntity;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Interface para agrupar métodos usados no
 * gerenciamento dos alugueis.
 *
 * Uso: AluguelServiceImpl
 *
 * @author WellingtonKlinkowski
 */
public interface AluguelService {

    AluguelResponse criarAluguel(AluguelRequest aluguelRequest);

    AluguelResponse procuraAluguelPorId(Long idAluguel);

    List<AluguelResponse> listarAlugueis();

    AluguelResponse procuraAluguelPorNumeroDaMesa(Integer numeroMesaAluguel);

    List<AluguelResponse> procuraAluguelPorFumo(Long idFumo);

    List<AluguelResponse> procuraAluguelPorCarvao(Long idCarvao);

    List<AluguelResponse> procuraAluguelPorRosh(Long idRosh);

    List<AluguelResponse> procuraAluguelPorNarguile(Long idNarguile);

    List<AluguelResponse> procuraAluguelPorData(LocalDate dataAluguel);

    List<AluguelResponse> procuraAluguelPorDataHora(LocalDateTime dataHoraAluguel);

    List<AluguelResponse> procuraAluguelPorDuracao(Duration minimoDuracaoAluguel, Duration maximoDuracaoAluguel);

    AluguelResponse atualizaAluguelPorId(Long idAluguel, AluguelRequest aluguelRequest);

    void retornaAoEstoqueSuprimentosNaoConsumiveisAposEncerrarAluguel();

    boolean isAluguelExpirado(AluguelEntity aluguelEntity);

    void desativarAluguel(Long idAluguel);

    void deletarAluguelPorId(Long idAluguel);
}
