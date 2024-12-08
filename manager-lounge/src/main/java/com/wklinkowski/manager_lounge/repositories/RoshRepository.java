package com.wklinkowski.manager_lounge.repositories;

import com.wklinkowski.manager_lounge.entities.RoshEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoshRepository extends JpaRepository<RoshEntity, Long> {
}
