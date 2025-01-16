package com.wklinkowski.manager_lounge.repositories;

import com.wklinkowski.manager_lounge.entities.NarguileEntity;
import com.wklinkowski.manager_lounge.enums.MarcasNarguile;
import com.wklinkowski.manager_lounge.enums.MaterialNarguile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NarguileRepository extends JpaRepository<NarguileEntity, Long> {

    List<NarguileEntity> findByNomeNarguileOrderByNomeNarguileDesc(String nomeNarguile);

    List<NarguileEntity> findByMarcasNarguileOrderByMarcasNarguileDesc(MarcasNarguile marcasNarguile);

    List<NarguileEntity> findByQuantidadeMangueirasNarguileOrderByQuantidadeMangueirasNarguileDesc(Integer quantidadeMangueirasNarguile);

    List<NarguileEntity> findByMaterialNarguileOrderByMaterialNarguileDesc(MaterialNarguile materialNarguile);

    @Query(value = "SELECT * FROM NARGUILES n WHERE n.nome_narguile LIKE %?1%", nativeQuery = true)
    List<NarguileEntity> procuraNomeNarguileComMetodoLike(String nomeNarguile);

    @Query(value = "SELECT * FROM NARGUILES n WHERE n.marcas_narguile LIKE %?1%", nativeQuery = true)
    List<NarguileEntity> procuraMarcasNarguileComMetodoLike(String marcasNarguile);

    @Query(value = "SELECT * FROM NARGUILES n WHERE n.material_narguile LIKE %?1%", nativeQuery = true)
    List<NarguileEntity> procuraMaterialNarguileComMetodoLike(String materialNarguile);

    List<NarguileEntity> findByQuantidadeMangueirasNarguileBetween(Integer quantidadeMinima, Integer quantidadeMaxima);

    List<NarguileEntity> findByQuantidadeEstoqueNarguileOrderByQuantidadeEstoqueNarguileDesc(Integer quantidadeEstoqueNarguile);

    void deleteByMarcasNarguile(MarcasNarguile marcasNarguile);

    void deleteByMaterialNarguile(MaterialNarguile materialNarguile);

    void deleteByQuantidadeMangueirasNarguile(Integer quantidadeMangueirasNarguile);
}
