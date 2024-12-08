package com.wklinkowski.manager_lounge.repositories;

import com.wklinkowski.manager_lounge.entities.NarguileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NarguileRepository extends JpaRepository<NarguileEntity, Long> {
}
