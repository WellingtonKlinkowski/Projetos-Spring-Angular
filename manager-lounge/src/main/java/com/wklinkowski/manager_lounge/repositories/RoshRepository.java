package com.wklinkowski.manager_lounge.repositories;

import com.wklinkowski.manager_lounge.entities.RoshEntity;
import com.wklinkowski.manager_lounge.enums.MarcasRosh;
import com.wklinkowski.manager_lounge.enums.MaterialRosh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoshRepository extends JpaRepository<RoshEntity, Long> {

    List<RoshEntity> findByMarcasRoshOrderByMarcasRoshDesc (MarcasRosh marcasRosh);

    List<RoshEntity> findByMaterialRoshOrderByMaterialRoshDesc (MaterialRosh materialRosh);

    @Query(value = "SELECT * FROM ROSHS r WHERE r.marcas_rosh LIKE %?1%", nativeQuery = true)
    List<RoshEntity> procuraMarcasRoshComMetodoLike (String marcasRosh);

    @Query(value = "SELECT * FROM ROSHS r WHERE r.material_rosh LIKE %?1%", nativeQuery = true)
    List<RoshEntity> procuraMaterialRoshComMetodoLike (String materialRosh);

    void deleteByMarcasRosh (MarcasRosh marcasRosh);

    List<RoshEntity> findByQuantidadeEstoqueRoshOrderByQuantidadeEstoqueRoshDesc (Integer quantidadeEstoqueRosh);

    void deleteByMaterialRosh (MaterialRosh materialRosh);
}
