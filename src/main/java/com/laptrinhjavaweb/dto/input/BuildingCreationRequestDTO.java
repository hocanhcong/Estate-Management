package com.laptrinhjavaweb.dto.input;

import java.util.Map;

public class BuildingCreationRequestDTO {
    private String name;
    private String district;
    private String ward;
    private String street;
    private String construction;
    private Integer numberOfBaseMent;
    private Integer floorArea;
    private String direction;
    private String level;
    private String areaRent;
    private String areaRentDescription;
    private Integer rentPrice;
    private String serviceFee;
    private String[] buildingTypes;
    private Map<String,String> check;//để check các type

    public Map<String, String> getCheck() {
        return check;
    }

    public void setCheck(Map<String, String> check) {
        this.check = check;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getConstruction() {
        return construction;
    }

    public void setConstruction(String construction) {
        this.construction = construction;
    }

    public Integer getNumberOfBaseMent() {
        return numberOfBaseMent;
    }

    public void setNumberOfBaseMent(Integer numberOfBaseMent) {
        this.numberOfBaseMent = numberOfBaseMent;
    }

    public Integer getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(Integer floorArea) {
        this.floorArea = floorArea;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getAreaRent() {
        return areaRent;
    }

    public void setAreaRent(String areaRent) {
        this.areaRent = areaRent;
    }

    public String getAreaRentDescription() {
        return areaRentDescription;
    }

    public void setAreaRentDescription(String areaRentDescription) {
        this.areaRentDescription = areaRentDescription;
    }

    public Integer getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(Integer rentPrice) {
        this.rentPrice = rentPrice;
    }

    public String getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(String serviceFee) {
        this.serviceFee = serviceFee;
    }

    public String[] getBuildingTypes() {
        return buildingTypes;
    }

    public void setBuildingTypes(String[] buildingTypes) {
        this.buildingTypes = buildingTypes;
    }
}
