package com.wklinkowski.manager_lounge.repositories;

import com.wklinkowski.manager_lounge.entities.FumoEntity;
import com.wklinkowski.manager_lounge.enums.MarcasFumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FumoRepository extends JpaRepository<FumoEntity, Long> {

    List<FumoEntity> findByMarcasFumoOrderByMarcasFumoDesc (MarcasFumo marcasFumo);

    List<FumoEntity> findBySaborFumoOrderBySaborFumoDesc (String saborFumo);

    List<FumoEntity> findByPesoFumoOrderByPesoFumoDesc (Integer pesoFumo);

    @Query(value = "SELECT * FROM FUMOS f WHERE f.marcas_fumo LIKE %?1%", nativeQuery = true)
    List<FumoEntity> procuraMarcasFumoComMetodoLike (String marcasFumo);

    @Query(value = "SELECT * FROM FUMOS f WHERE f.sabor_fumo LIKE %?1%")
    List<FumoEntity> procuraSaborFumoComMetodoLike (String saborFumo);

    List<FumoEntity> findByPesoFumoBetween (Integer pesoMinimo, Integer pesoMaximo);

    void deleteByMarcasFumo(MarcasFumo marcasFumo);
}
