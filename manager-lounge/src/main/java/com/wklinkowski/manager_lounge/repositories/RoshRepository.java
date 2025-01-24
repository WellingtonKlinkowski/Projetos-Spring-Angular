package com.wklinkowski.manager_lounge.repositories;

import com.wklinkowski.manager_lounge.entities.RoshEntity;
import com.wklinkowski.manager_lounge.enums.MarcasRosh;
import com.wklinkowski.manager_lounge.enums.MaterialRosh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositório para manipulação de roshs
 * e agrupar métodos de consulta.
 *
 * @author WellingtonKlinkowski
 */
@Repository
public interface RoshRepository extends JpaRepository<RoshEntity, Long> {

    /**
     * Procura no banco os registros que usam
     * a marca do rosh igual ao exigido.
     *
     * @param marcasRosh marca do rosh que os registros devem usar para aparecer no filtro.
     * @return retorna os registros que usam a marca do rosh exigido.
     *
     * @author WellingtonKlinkowski
     */
    List<RoshEntity> findByMarcasRoshOrderByMarcasRoshDesc(MarcasRosh marcasRosh);

    /**
     * Procura no banco os registros que usam
     * o material do rosh igual ao exigido.
     *
     * @param materialRosh material do rosh que os registros devem usar para aparecer no filtro.
     * @return retorna os registros que usam o material do rosh exigido.
     *
     * @author WellingtonKlinkowski
     */
    List<RoshEntity> findByMaterialRoshOrderByMaterialRoshDesc(MaterialRosh materialRosh);

    /**
     * Procura no banco os registros que contenham
     * entre o nome da marca a palavra passada por
     * parâmetro.
     *
     * @param marcasRosh palavra que a marca do rosh deve conter para aparecer no filtro.
     * @return retorna os registros que tenham a palavra exigida entre o nome da marca exigida.
     *
     * @author WellingtonKlinkowski
     */
    @Query(value = "SELECT * FROM ROSHS r WHERE r.marcas_rosh LIKE %?1%", nativeQuery = true)
    List<RoshEntity> procuraMarcasRoshComMetodoLike(String marcasRosh);

    /**
     * Procura no banco os registros que contenham
     * entre o nome do material a palavra passada por
     * parâmetro.
     *
     * @param materialRosh palavra que o material do rosh deve conter para aparecer no filtro.
     * @return retorna os registros que tenham a palavra exigida entre o nome do material exigida.
     *
     * @author WellingtonKlinkowski
     */
    @Query(value = "SELECT * FROM ROSHS r WHERE r.material_rosh LIKE %?1%", nativeQuery = true)
    List<RoshEntity> procuraMaterialRoshComMetodoLike(String materialRosh);

    /**
     * Procura no banco os registros tenham a
     * quantidade igual a passada por parâmetro.
     *
     * @param quantidadeEstoqueRosh quantidade em estoque do rosh que deve ter para aparecer no filtro.
     * @return retorna os registros que tenham a quantidade em estoque de rosh exigida.
     *
     * @author WellingtonKlinkowski
     */
    List<RoshEntity> findByQuantidadeEstoqueRoshOrderByQuantidadeEstoqueRoshDesc(Integer quantidadeEstoqueRosh);

    /**
     * Busca os registros que usam a marca do rosh
     * exigida e faz a exclusão.
     *
     * @param marcasRosh marca do rosh que deve ser excluída.
     *
     * @author WellingtonKlinkowski
     */
    void deleteByMarcasRosh(MarcasRosh marcasRosh);

    /**
     * Busca os registros que usam o material
     * do rosh exigido e faz a exclusão.
     *
     * @param materialRosh material do rosh que deve ser excluído.
     *
     * @author WellingtonKlinkowski
     */
    void deleteByMaterialRosh(MaterialRosh materialRosh);
}
