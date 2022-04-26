package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.builder.BuildingSearch;
import com.laptrinhjavaweb.entity.BuildingEntity;

import java.util.List;
import java.util.Map;

public interface BuildingRepositoryCustom{
    List<BuildingEntity> findBuilding(BuildingSearch buildingSearch);
}
