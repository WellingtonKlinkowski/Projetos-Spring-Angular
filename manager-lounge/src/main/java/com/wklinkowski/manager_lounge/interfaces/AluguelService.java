package com.wklinkowski.manager_lounge.interfaces;

import com.wklinkowski.manager_lounge.dtos.AluguelDTO;
import com.wklinkowski.manager_lounge.entities.AluguelEntity;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface AluguelService {

    AluguelDTO criarAluguel(AluguelDTO aluguelDTO);

    AluguelDTO procuraAluguelPorId(Long idAluguel);

    List<AluguelDTO> listarAlugueis();

    AluguelDTO procuraAluguelPorNumeroDaMesa(Integer numeroMesaAluguel);

    List<AluguelDTO> procuraAluguelPorFumo(Long idFumo);

    List<AluguelDTO> procuraAluguelPorCarvao(Long idCarvao);

    List<AluguelDTO> procuraAluguelPorRosh(Long idRosh);

    List<AluguelDTO> procuraAluguelPorNarguile(Long idNarguile);

    List<AluguelDTO> procuraAluguelPorData(LocalDate dataAluguel);

    List<AluguelDTO> procuraAluguelPorDataHora(LocalDateTime dataHoraAluguel);

    List<AluguelDTO> procuraAluguelPorDuracao(Duration minimoDuracaoAluguel, Duration maximoDuracaoAluguel);

    AluguelDTO atualizaAluguelPorId(Long idAluguel, AluguelDTO aluguelDTO);

    void retornaAoEstoqueSuprimentosNaoConsumiveisAposEncerrarAluguel();

    boolean isAluguelExpirado(AluguelEntity aluguelEntity);

    void desativarAluguel(Long idAluguel);

    void deletarAluguelPorId(Long idAluguel);
}
