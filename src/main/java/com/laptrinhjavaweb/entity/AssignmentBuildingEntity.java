package com.laptrinhjavaweb.entity;

import javax.persistence.*;

@Entity
@Table(name = "assignmentbuilding")
public class AssignmentBuildingEntity extends  BaseEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staffid",nullable = false)
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buildingid",nullable = false)
    private BuildingEntity building;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public BuildingEntity getBuilding() {
        return building;
    }

    public void setBuilding(BuildingEntity building) {
        this.building = building;
    }
}
