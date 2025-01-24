package com.wklinkowski.manager_lounge.repositories;

import com.wklinkowski.manager_lounge.entities.CarvaoEntity;
import com.wklinkowski.manager_lounge.enums.MarcaCarvao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositório para manipulação de carvoes
 * e agrupar métodos de consulta.
 *
 * @author WellingtonKlinkowski
 */
@Repository
public interface CarvaoRepository extends JpaRepository<CarvaoEntity, Long> {

    /**
     * Procura no banco os carvões que tenham
     * a marca passada por parâmetro.
     *
     * @param marcaCarvao marca do carvão para filtrar os registros.
     * @return todos os registros que usem a marca.
     *
     * @author WellingtonKlinkowski
     */
    List<CarvaoEntity> findByMarcaCarvaoOrderByMarcaCarvaoDesc(MarcaCarvao marcaCarvao);

    /**
     * Procura no banco os carvões que tenham
     * o peso passado por parâmetro.
     *
     * @param pesoCarvao peso do carvão para filtrar os registros.
     * @return todos os registros que tenham o peso igual ao passado.
     *
     * @author WellingtonKlinkowski
     */
    List<CarvaoEntity> findByPesoCarvaoOrderByPesoCarvaoDesc(Integer pesoCarvao);

    /**
     * Procura no banco os carvões que tenham
     * a mesma quantidade de carvão passada
     * por parâmetro.
     *
     * @param quantidadeCarvao quantidade de carvão para filtrar os registros.
     * @return todos os registros que tenham a quantidade igual a passada.
     *
     * @author WellingtonKlinkowski
     */
    List<CarvaoEntity> findByQuantidadeCarvaoOrderByQuantidadeCarvaoDesc(Integer quantidadeCarvao);

    /**
     * Procura no banco os carvões que tenham
     * a marca e o peso iguais ao passado por
     * parâmetro.
     *
     * @param marcaCarvao marca do carvão para filtrar os registros.
     * @param pesoCarvao peso do carvão para filtrar os registros.
     * @return todos os registros que tenham a marca e peso iguais ao solicitado.
     *
     * @author WellingtonKlinkowski
     */
    @Query("SELECT c FROM CarvaoEntity c WHERE c.marcaCarvao = :marcaCarvao AND c.pesoCarvao = :pesoCarvao")
    List<CarvaoEntity> procuraCarvaoPorMarcaEPeso(MarcaCarvao marcaCarvao, Integer pesoCarvao);

    /**
     * Procura no banco as marcas que possuem
     * em alguma parte do seu nome o valor da
     * palavra solicitada.
     *
     * @param marcaCarvao palavra que contém na marca do carvão para filtrar os registros.
     * @return todos os registros que contenham em seu nome a palavra solicitada.
     *
     * @author WellingtonKlinkowski
     */
    @Query(value = "SELECT * FROM CARVOES c WHERE c.marca_carvao LIKE %?1%", nativeQuery = true)
    List<CarvaoEntity> procuraMarcaCarvaoComMetodoLike(String marcaCarvao);

    /**
     * Procura no banco todos os registros que
     * tenham o peso entre os dois valores passados
     * para filtrar.
     *
     * @param pesoMinimoCarvao peso mínimo que o carvão deve ter para entrar no filtro.
     * @param pesoMaximoCarvao peso máximo que o carvão deve ter para entrar no filtro.
     * @return todos os registros que estão com o peso entre os dois valores passados.
     *
     * @author WellingtonKlinkowski
     */
    List<CarvaoEntity> findByPesoCarvaoBetween(Integer pesoMinimoCarvao, Integer pesoMaximoCarvao);

    /**
     * Procura no banco todos os registros que
     * tenham a quantidade de caixa em estoque
     * iguais ao solicitado.
     *
     * @param quantidadeEstoqueCarvao quantidade de caixa de carvão que deve ter para entrar no filtro.
     * @return todos os registros que tenham a quantidade de caixas em estoque igual ao passado.
     *
     * @author WellingtonKlinkowski
     */
    List<CarvaoEntity> findByQuantidadeEstoqueCaixaCarvaoOrderByQuantidadeEstoqueCaixaCarvaoDesc(Integer quantidadeEstoqueCarvao);

    /**
     * Apaga carvões que usem a marca solicitada.
     *
     * @param marcaCarvao marca do carvão que deve ser apagada..
     *
     * @author WellingtonKlinkowski
     */
    void deleteByMarcaCarvao(MarcaCarvao marcaCarvao);
}
