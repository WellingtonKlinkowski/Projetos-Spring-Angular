package com.wklinkowski.manager_lounge.repositories;

import com.wklinkowski.manager_lounge.entities.FumoEntity;
import com.wklinkowski.manager_lounge.enums.MarcasFumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositório para manipulação de fumos
 * e agrupar métodos de consulta.
 *
 * @author WellingtonKlinkowski
 */
@Repository
public interface FumoRepository extends JpaRepository<FumoEntity, Long> {

    /**
     * Procura no banco todos os registros que
     * tenham a marca iguais a solicitada.
     *
     * @param marcasFumo marca do fumo que deve ter para entrar no filtro.
     * @return todos os registros que usam a marca do fumo igual ao passado.
     *
     * @author WellingtonKlinkowski
     */
    List<FumoEntity> findByMarcasFumoOrderByMarcasFumoDesc(MarcasFumo marcasFumo);

    /**
     * Procura no banco todos os registros que
     * tenham o sabor iguais ao solicitado.
     *
     * @param saborFumo sabor do fumo que deve ter para entrar no filtro.
     * @return todos os registros que tenham o sabor do fumo igual ao passado.
     *
     * @author WellingtonKlinkowski
     */
    List<FumoEntity> findBySaborFumoOrderBySaborFumoDesc(String saborFumo);

    /**
     * Procura no banco todos os registros que
     * tenham o peso igual ao solicitado.
     *
     * @param pesoFumo peso do fumo que deve ter para entrar no filtro.
     * @return todos os registros que tenham o peso do fumo igual ao passado.
     *
     * @author WellingtonKlinkowski
     */
    List<FumoEntity> findByPesoFumoOrderByPesoFumoDesc(Integer pesoFumo);

    /**
     * Procura no banco todos os registros que
     * contenham a palavra passada entre a marca
     * do fumo.
     *
     * @param marcasFumo palavra que a marca deve ter para entrar no filtro.
     * @return todos os registros que tenham entre o nome da marca a palavra igual a passada.
     *
     * @author WellingtonKlinkowski
     */
    @Query(value = "SELECT * FROM FUMOS f WHERE f.marcas_fumo LIKE %?1%", nativeQuery = true)
    List<FumoEntity> procuraMarcasFumoComMetodoLike(String marcasFumo);

    /**
     * Procura no banco todos os registros que
     * contenham a palavra passada entre o sabor
     * do fumo.
     *
     * @param saborFumo palavra que o sabor deve ter para entrar no filtro.
     * @return todos os registros que tenham entre o nome do sabor a palavra a passada.
     *
     * @author WellingtonKlinkowski
     */
    @Query(value = "SELECT * FROM FUMOS f WHERE f.sabor_fumo LIKE %?1%", nativeQuery = true)
    List<FumoEntity> procuraSaborFumoComMetodoLike(String saborFumo);

    /**
     * Procura no banco todos os registros que
     * tenham o peso entre os dois valores exigidos.
     *
     * @param pesoMinimo peso mínimo que o fumo deve ter para entrar no filtro.
     * @param pesoMaximo peso máximo que o fumo deve ter para entrar no filtro.
     * @return todos os registros que estejam entre os pesos passados.
     *
     * @author WellingtonKlinkowski
     */
    List<FumoEntity> findByPesoFumoBetween(Integer pesoMinimo, Integer pesoMaximo);

    /**
     * Procura no banco os registros que
     * tenham a quantidade de fumo passado
     * no parâmetro.
     *
     * @param quantidadeEstoqueFumo quantidade que o fumo deve ter para entrar no filtro.
     * @return todos os registros que estejam com a quantidade exigida.
     *
     * @author WellingtonKlinkowski
     */
    List<FumoEntity> findByQuantidadeEstoqueFumoOrderByQuantidadeEstoqueFumoDesc(Integer quantidadeEstoqueFumo);

    /**
     * Procura no banco e apaga todos os registros
     * que usam a marca passada por parâmetro.
     *
     * @param marcasFumo marca do fumo que deve ser excluída.
     * @return apaga todos os registros que usam a marca passada.
     *
     * @author WellingtonKlinkowski
     */
    void deleteByMarcasFumo(MarcasFumo marcasFumo);
}
