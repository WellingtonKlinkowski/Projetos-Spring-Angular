package com.wklinkowski.manager_lounge.repositories;

import com.wklinkowski.manager_lounge.entities.CarvaoEntity;
import com.wklinkowski.manager_lounge.enums.MarcaCarvao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarvaoRepository extends JpaRepository<CarvaoEntity, Long> {

    List<CarvaoEntity> findByMarcaCarvaoOrderByMarcaCarvaoDesc (MarcaCarvao marcaCarvao);

    List<CarvaoEntity> findByPesoCarvaoOrderByPesoCarvaoDesc (Integer pesoCarvao);

    List<CarvaoEntity> findByQuantidadeCarvaoOrderByQuantidadeCarvaoDesc (Integer quantidadeCarvao);

    @Query("SELECT c FROM CarvaoEntity c WHERE c.marcaCarvao = :marcaCarvao AND c.pesoCarvao = :pesoCarvao")
    List<CarvaoEntity> procuraCarvaoPorMarcaEPeso (MarcaCarvao marcaCarvao, Integer pesoCarvao);

    @Query(value = "SELECT * FROM CARVOES c WHERE c.marca_carvao LIKE %?1%", nativeQuery = true)
    List<CarvaoEntity> procuraMarcaCarvaoComMetodoLike (String marcaCarvao);

    List<CarvaoEntity> findByPesoCarvaoBetween (Integer pesoMinimoCarvao, Integer pesoMaximoCarvao);

    List<CarvaoEntity> findByQuantidadeEstoqueCarvaoOrderByQuantidadeEstoqueCarvaoDesc (Integer quantidadeEstoqueCarvao);

    void deleteByMarcaCarvao (MarcaCarvao marcaCarvao);
}
