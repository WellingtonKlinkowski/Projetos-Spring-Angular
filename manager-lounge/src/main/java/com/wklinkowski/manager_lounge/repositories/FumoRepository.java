package com.wklinkowski.manager_lounge.repositories;

import com.wklinkowski.manager_lounge.entities.FumoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FumoRepository extends JpaRepository<FumoEntity, Long> {

}
