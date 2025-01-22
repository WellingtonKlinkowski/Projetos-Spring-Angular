package com.wklinkowski.manager_lounge.repositories;

import com.wklinkowski.manager_lounge.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AluguelRepository extends JpaRepository<AluguelEntity, Long> {

    Optional<AluguelEntity> findByNumeroMesaAluguel(Integer numeroMesaAluguel);

    @Query(value = "SELECT * FROM alugueis a WHERE a.fumo_aluguel_id = ?1", nativeQuery = true)
    List<AluguelEntity> findByFumoAluguel(Long idfumo);

    @Query(value = "SELECT * FROM alugueis a WHERE a.carvao_aluguel_id = ?1", nativeQuery = true)
    List<AluguelEntity> findByCarvaoAluguel(Long idCarvao);

    @Query(value = "SELECT * FROM alugueis a WHERE a.rosh_aluguel_id = ?1", nativeQuery = true)
    List<AluguelEntity> findByRoshAluguel(Long idRosh);

    @Query(value = "SELECT * FROM alugueis a WHERE a.narguile_aluguel_id = ?1", nativeQuery = true)
    List<AluguelEntity> findByNarguileAluguel(Long idNarguile);

    List<AluguelEntity> findByDataAluguel(LocalDate dataAluguel);

    List<AluguelEntity> findByHoraAluguel(LocalDateTime horaAluguel);

    List<AluguelEntity> findByDuracaoAluguelBetween(Duration minimoDuracaoAluguel, Duration maximoDuracaoAluguel);

    @Query(value = "SELECT * FROM alugueis A WHERE A.ativo_aluguel = TRUE", nativeQuery = true)
    List<AluguelEntity> findAluguelIsAtivo();
}
