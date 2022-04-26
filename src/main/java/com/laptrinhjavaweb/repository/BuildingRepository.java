package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.BuildingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BuildingRepository extends JpaRepository<BuildingEntity, Long> {
    void deleteById(Long id);
    BuildingEntity findById(Long id);
}
