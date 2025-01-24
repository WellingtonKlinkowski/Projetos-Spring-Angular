package com.wklinkowski.manager_lounge.repositories;

import com.wklinkowski.manager_lounge.entities.NarguileEntity;
import com.wklinkowski.manager_lounge.enums.MarcasNarguile;
import com.wklinkowski.manager_lounge.enums.MaterialNarguile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositório para manipulação de narguiles
 * e agrupar métodos de consulta.
 *
 * @author WellingtonKlinkowski
 */
@Repository
public interface NarguileRepository extends JpaRepository<NarguileEntity, Long> {

    /**
     * Procura no banco os registros que contenham
     * o nome do narguile igual ao exigido.
     *
     * @param nomeNarguile nome do narguile que deve ser filtrado.
     * @return retorna os registros que contenham o nome igual ao exigido.
     *
     * @author WellingtonKlinkowski
     */
    List<NarguileEntity> findByNomeNarguileOrderByNomeNarguileDesc(String nomeNarguile);

    /**
     * Procura no banco os registros que contenham
     * a marca do narguile igual ao exigido.
     *
     * @param marcasNarguile marca do narguile que deve ser filtrado.
     * @return retorna os registros que contenham a marca igual ao exigido.
     *
     * @author WellingtonKlinkowski
     */
    List<NarguileEntity> findByMarcasNarguileOrderByMarcasNarguileDesc(MarcasNarguile marcasNarguile);

    /**
     * Procura no banco os registros que contenham
     * a quantidade de mangueiras do narguile igual
     * ao exigido.
     *
     * @param quantidadeMangueirasNarguile quantidade de mangueiras do narguile que deve ser filtrado.
     * @return retorna os registros que contenham a quantidade de mangueiras igual ao exigido.
     *
     * @author WellingtonKlinkowski
     */
    List<NarguileEntity> findByQuantidadeMangueirasNarguileOrderByQuantidadeMangueirasNarguileDesc(Integer quantidadeMangueirasNarguile);

    /**
     * Procura no banco os registros que usam
     * o material do narguile igual ao exigido.
     *
     * @param materialNarguile material do narguile que deve ser filtrado.
     * @return retorna os registros que usam o material igual ao exigido.
     *
     * @author WellingtonKlinkowski
     */
    List<NarguileEntity> findByMaterialNarguileOrderByMaterialNarguileDesc(MaterialNarguile materialNarguile);

    /**
     * Procura no banco os registros que contenham
     * entre o nome a palavra passada por parâmetro.
     *
     * @param nomeNarguile palavra que o nome do narguile deve ter entre os carácteres.
     * @return retorna os registros que contenham no nome a palavra igual a exigida.
     *
     * @author WellingtonKlinkowski
     */
    @Query(value = "SELECT * FROM NARGUILES n WHERE n.nome_narguile LIKE %?1%", nativeQuery = true)
    List<NarguileEntity> procuraNomeNarguileComMetodoLike(String nomeNarguile);

    /**
     * Procura no banco os registros que contenham
     * entre o nome da marca a palavra passada por parâmetro.
     *
     * @param marcasNarguile palavra que a marca do narguile deve ter entre os carácteres.
     * @return retorna os registros que contenham no nome da marca a palavra igual à exigida.
     *
     * @author WellingtonKlinkowski
     */
    @Query(value = "SELECT * FROM NARGUILES n WHERE n.marcas_narguile LIKE %?1%", nativeQuery = true)
    List<NarguileEntity> procuraMarcasNarguileComMetodoLike(String marcasNarguile);

    /**
     * Procura no banco os registros que contenham
     * entre o nome do material usado a palavra
     * passada por parâmetro.
     *
     * @param materialNarguile palavra que o material do narguile deve ter entre os carácteres.
     * @return retorna os registros que contenham no nome do material a palavra igual à exigida.
     *
     * @author WellingtonKlinkowski
     */
    @Query(value = "SELECT * FROM NARGUILES n WHERE n.material_narguile LIKE %?1%", nativeQuery = true)
    List<NarguileEntity> procuraMaterialNarguileComMetodoLike(String materialNarguile);

    /**
     * Procura no banco os registros que estão
     * com a quantidade de mangueiras entre os
     * dois valores exigidos.
     *
     * @param quantidadeMinima quantidade mínima de mangueiras que o narguile deve ter.
     * @param quantidadeMaxima quantidade máxima de mangueiras que o narguile deve ter.
     * @return retorna os registros que estão com a quantidade de mangueiras entre os valores exigidos.
     *
     * @author WellingtonKlinkowski
     */
    List<NarguileEntity> findByQuantidadeMangueirasNarguileBetween(Integer quantidadeMinima, Integer quantidadeMaxima);

    /**
     * Procura no banco os registros que estão
     * com a quantidade em estoque igual ao exigido;
     *
     * @param quantidadeEstoqueNarguile narguile com a quantidade em estoque igual à exigida.
     * @return retorna os registros que contenham no estoque a quantidade igual à exigida.
     *
     * @author WellingtonKlinkowski
     */
    List<NarguileEntity> findByQuantidadeEstoqueNarguileOrderByQuantidadeEstoqueNarguileDesc(Integer quantidadeEstoqueNarguile);

    /**
     * Procura no banco e apaga os registros que
     * usam a marca do narguile igual a exigida.
     *
     * @param marcasNarguile marca do narguile que deve ser apagada.
     *
     * @author WellingtonKlinkowski
     */
    void deleteByMarcasNarguile(MarcasNarguile marcasNarguile);

    /**
     * Procura no banco e apaga os registros que
     * usam o material do narguile igual ao exigido.
     *
     * @param materialNarguile material do narguile que deve ser apagado.
     *
     * @author WellingtonKlinkowski
     */
    void deleteByMaterialNarguile(MaterialNarguile materialNarguile);

    /**
     * Procura no banco e apaga os registros que
     * tenham a quantidade de mangueiras do
     * narguile igual ao exigido.
     *
     * @param quantidadeMangueirasNarguile quantidade de mangueiras do narguile que deve ser apagado.
     *
     * @author WellingtonKlinkowski
     */
    void deleteByQuantidadeMangueirasNarguile(Integer quantidadeMangueirasNarguile);
}
