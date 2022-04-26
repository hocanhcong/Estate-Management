package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.AssignmentBuildingEntity;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignmentBuildingRepository extends JpaRepository<AssignmentBuildingEntity,Long> {
    List<AssignmentBuildingEntity> findByBuildingId(Long buildingId);
    AssignmentBuildingEntity findByBuildingIdAndUserId(Long buildingId,Long userId);
    void deleteByUserIdAndBuildingId(Long userId,Long buildingId);
    void deleteByUser_IdAndBuilding_Id(Long userId,Long buildingId);
    void deleteAllByBuildingId(Long buildingId);
}
