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

/**
 * Repositório para manipulação de alugueis
 * e agrupar métodos de consulta.
 *
 * @author WellingtonKlinkowski
 */
@Repository
public interface AluguelRepository extends JpaRepository<AluguelEntity, Long> {

    /**
     * Recebe o número da mesa, faz a busca no
     * banco de dados e retorna um entidade caso
     * alguem registro contenha o número da mesa.
     *
     * @param numeroMesaAluguel número da mesa que a entidade precisa ter para retornar da busca.
     * @return todos os registros que contenham o número passado.
     *
     * @author WellingtonKlinkowski
     */
    @Query(value = "SELECT * FROM alugueis a WHERE a.numero_mesa_aluguel = ?1 AND a.ativo_aluguel = TRUE", nativeQuery = true)
    Optional<AluguelEntity> findByNumeroMesaAluguel(Integer numeroMesaAluguel);

    /**
     * Recebe o identifcador do fumo, faz a busca
     * no banco trazendo todos os registros que
     * contenham o identificador do fumo.
     *
     * @param idfumo id do fumo que a entidade precisa ter para retornar da busca.
     * @return todos os registros que contenham o identificador passado.
     *
     * @author WellingtonKlinkowski
     */
    @Query(value = "SELECT * FROM alugueis a WHERE a.fumo_aluguel_id = ?1", nativeQuery = true)
    List<AluguelEntity> findByFumoAluguel(Long idfumo);

    /**
     * Recebe o identifcador do carvão, faz a busca
     * no banco trazendo todos os registros que
     * contenham o identificador do carvão.
     *
     * @param idCarvao id do carvão que a entidade precisa ter para retornar da busca.
     * @return todos os registros que contenham o identificador passado.
     *
     * @author WellingtonKlinkowski
     */
    @Query(value = "SELECT * FROM alugueis a WHERE a.carvao_aluguel_id = ?1", nativeQuery = true)
    List<AluguelEntity> findByCarvaoAluguel(Long idCarvao);

    /**
     * Recebe o identifcador do rosh, faz a busca
     * no banco trazendo todos os registros que
     * contenham o identificador do rosh.
     *
     * @param idRosh id do rosh que a entidade precisa ter para retornar da busca.
     * @return todos os registros que contenham o identificador passado.
     *
     * @author WellingtonKlinkowski
     */
    @Query(value = "SELECT * FROM alugueis a WHERE a.rosh_aluguel_id = ?1", nativeQuery = true)
    List<AluguelEntity> findByRoshAluguel(Long idRosh);

    /**
     * Recebe o identifcador do narguile, faz a busca
     * no banco trazendo todos os registros que
     * contenham o identificador do narguile.
     *
     * @param idNarguile id do narguile que a entidade precisa ter para retornar da busca.
     * @return todos os registros que contenham o identificador passado.
     *
     * @author WellingtonKlinkowski
     */
    @Query(value = "SELECT * FROM alugueis a WHERE a.narguile_aluguel_id = ?1", nativeQuery = true)
    List<AluguelEntity> findByNarguileAluguel(Long idNarguile);

    /**
     * Recebe a data do aluguel, faz a busca
     * no banco trazendo todos os registros que
     * contenham essa data.
     *
     * @param dataAluguel data do aluguel que precisa ter para retornar da busca.
     * @return todos os registros que contenham a data passada.
     *
     * @author WellingtonKlinkowski
     */
    List<AluguelEntity> findByDataAluguel(LocalDate dataAluguel);

    /**
     * Recebe a data e hora do aluguel, faz a busca
     * no banco trazendo todos os registros que
     * contenham essa data e essa hora.
     *
     * @param horaAluguel data e hora do aluguel que precisa ter para retornar da busca.
     * @return todos os registros que contenham a data e hora passada.
     *
     * @author WellingtonKlinkowski
     */
    List<AluguelEntity> findByHoraAluguel(LocalDateTime horaAluguel);

    /**
     * Recebe duas durações, faz a busca no banco
     * e retorna os registros que tenham a duração
     * entre as duas passadas.
     *
     * @param minimoDuracaoAluguel duração mínima para entrar no filtro.
     * @param maximoDuracaoAluguel duração máxima para entrar no filtro.
     * @return todos os registros que estão entre as durações passadas.
     *
     * @author WellingtonKlinkowski
     */
    List<AluguelEntity> findByDuracaoAluguelBetween(Duration minimoDuracaoAluguel, Duration maximoDuracaoAluguel);

    /**
     * Procura no banco todos os alugueis que
     * estão ativos e retorna os que estão true.
     *
     * @return todos os registros que estão ativos.
     *
     * @author WellingtonKlinkowski
     */
    @Query(value = "SELECT * FROM alugueis A WHERE A.ativo_aluguel = TRUE", nativeQuery = true)
    List<AluguelEntity> findAluguelIsAtivo();
}
