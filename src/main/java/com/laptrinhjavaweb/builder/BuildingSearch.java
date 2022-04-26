package com.laptrinhjavaweb.builder;

public class BuildingSearch {
    private String name;
    private Integer floorArea;
    private String district;
    private String street;
    private String ward;
    private Integer numberOfBasement;
    private String direction;
    private String level;
    private Integer areaRentFrom;
    private Integer areaRentTo;
    private Integer costRentFrom;
    private Integer costRentTo;
    private String[] buildingTypes;
    private Long staffId;

    public String getName() {
        return name;
    }

    public Integer getFloorArea() {
        return floorArea;
    }

    public String getDistrict() {
        return district;
    }

    public String getStreet() {
        return street;
    }

    public String getWard() {
        return ward;
    }

    public Integer getNumberOfBasement() {
        return numberOfBasement;
    }

    public String getDirection() {
        return direction;
    }

    public String getLevel() {
        return level;
    }

    public Integer getAreaRentFrom() {
        return areaRentFrom;
    }

    public Integer getAreaRentTo() {
        return areaRentTo;
    }

    public Integer getCostRentFrom() {
        return costRentFrom;
    }

    public Integer getCostRentTo() {
        return costRentTo;
    }

    public String[] getBuildingTypes() {
        return buildingTypes;
    }

    public Long getStaffId() {
        return staffId;
    }

    private BuildingSearch(BuildingSearchBuilder buildingSearchBuilder){
        this.name = buildingSearchBuilder.name;
        this.district = buildingSearchBuilder.district;
        this.floorArea = buildingSearchBuilder.floorArea;
        this.ward = buildingSearchBuilder.ward;
        this.street = buildingSearchBuilder.street;
        this.numberOfBasement = buildingSearchBuilder.numberOfBasement;
        this.direction = buildingSearchBuilder.direction;
        this.level = buildingSearchBuilder.level;
        this.areaRentFrom = buildingSearchBuilder.areaRentFrom;
        this.areaRentTo = buildingSearchBuilder.areaRentTo;
        this.costRentFrom = buildingSearchBuilder.costRentFrom;
        this.costRentTo = buildingSearchBuilder.costRentTo;
        this.buildingTypes = buildingSearchBuilder.buildingTypes;
        this.staffId = buildingSearchBuilder.staffId;
    }

    public static class BuildingSearchBuilder
    {
        private String name;
        private Integer floorArea;
        private String district;
        private String street;
        private String ward;
        private Integer numberOfBasement;
        private String direction;
        private String level;
        private Integer areaRentFrom;
        private Integer areaRentTo;
        private Integer costRentFrom;
        private Integer costRentTo;
        private String[] buildingTypes;
        private Long staffId;

        public BuildingSearchBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public BuildingSearchBuilder setFloorArea(Integer floorArea) {
            this.floorArea = floorArea;
            return this;
        }

        public BuildingSearchBuilder setDistrict(String district) {
            this.district = district;
            return this;
        }

        public BuildingSearchBuilder setStreet(String street) {
            this.street = street;
            return this;
        }

        public BuildingSearchBuilder setWard(String ward) {
            this.ward = ward;
            return this;
        }

        public BuildingSearchBuilder setNumberOfBasement(Integer numberOfBasement) {
            this.numberOfBasement = numberOfBasement;
            return this;
        }

        public BuildingSearchBuilder setDirection(String direction) {
            this.direction = direction;
            return this;
        }

        public BuildingSearchBuilder setLevel(String level) {
            this.level = level;
            return this;
        }

        public BuildingSearchBuilder setAreaRentFrom(Integer areaRentFrom) {
            this.areaRentFrom = areaRentFrom;
            return this;
        }

        public BuildingSearchBuilder setAreaRentTo(Integer areaRentTo) {
            this.areaRentTo = areaRentTo;
            return this;
        }

        public BuildingSearchBuilder setCostRentFrom(Integer costRentFrom) {
            this.costRentFrom = costRentFrom;
            return this;
        }

        public BuildingSearchBuilder setCostRentTo(Integer costRentTo) {
            this.costRentTo = costRentTo;
            return this;
        }

        public BuildingSearchBuilder setBuildingTypes(String[] buildingTypes) {
            this.buildingTypes = buildingTypes;
            return this;
        }

        public BuildingSearchBuilder setStaffId(Long staffId) {
            this.staffId = staffId;
            return this;
        }
        public BuildingSearch build()
        {
            BuildingSearch buildingSearch = new BuildingSearch(this);
            return buildingSearch;
        }
    }

}
