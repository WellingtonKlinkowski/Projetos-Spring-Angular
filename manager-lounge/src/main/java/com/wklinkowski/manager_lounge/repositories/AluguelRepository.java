package com.wklinkowski.manager_lounge.repositories;

import com.wklinkowski.manager_lounge.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AluguelRepository extends JpaRepository<AluguelEntity, Long> {

    Optional<AluguelEntity> findByNumeroMesaAluguel(Integer numeroMesaAluguel);

    List<AluguelEntity> findByFumoAluguel(Long idfumo);

    List<AluguelEntity> findByCarvaoAluguel(Long idCarvao);

    List<AluguelEntity> findByRoshAluguel(Long idRosh);

    List<AluguelEntity> findByNarguileAluguel(Long idNarguile);

    List<AluguelEntity> findByDataAluguel(LocalDate dataAluguel);

    List<AluguelEntity> findByHoraAluguel(LocalDateTime horaAluguel);

    List<AluguelEntity> findByDuracaoAluguelBetween(Duration minimoDuracaoAluguel, Duration maximoDuracaoAluguel);

}
