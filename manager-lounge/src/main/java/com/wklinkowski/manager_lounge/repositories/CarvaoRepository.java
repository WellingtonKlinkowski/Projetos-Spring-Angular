package com.wklinkowski.manager_lounge.repositories;

import com.wklinkowski.manager_lounge.entities.CarvaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarvaoRepository extends JpaRepository<CarvaoEntity, Long> {
}
