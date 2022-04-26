package com.laptrinhjavaweb.dto.input;

public class BuildingSearchRequestDTO{
	private String name;
	private Integer floorArea;
	private String district;
	private String street;
	private String ward;
	private Integer numberOfBaseMent;
	private String direction;
	private String level;
	private Integer areaRentFrom;
	private Integer areaRentTo;
	private Integer costRentFrom;
	private Integer costRentTo;
	private String[] buildingTypes;
	private Long staffId;

	public Long getStaffId() {
		return staffId;
	}

	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}

	public BuildingSearchRequestDTO(String name, Integer floorArea, String district, String street,
									String ward, Integer numberOfBaseMent, String direction, String level,
									Integer areaRentFrom, Integer areaRentTo, Integer costRentFrom, Integer costRentTo, String[] buildingTypes) {
		this.name = name;
		this.floorArea = floorArea;
		this.district = district;
		this.street = street;
		this.ward = ward;
		this.numberOfBaseMent = numberOfBaseMent;
		this.direction = direction;
		this.level = level;
		this.areaRentFrom = areaRentFrom;
		this.areaRentTo = areaRentTo;
		this.costRentFrom = costRentFrom;
		this.costRentTo = costRentTo;
		this.buildingTypes = buildingTypes;
	}

	public String[] getBuildingTypes() {
		return buildingTypes;
	}

	public void setBuildingTypes(String[] buildingTypes) {
		this.buildingTypes = buildingTypes;
	}

	public BuildingSearchRequestDTO() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getFloorArea() {
		return floorArea;
	}

	public void setFloorArea(Integer floorArea) {
		this.floorArea = floorArea;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public Integer getNumberOfBaseMent() {
		return numberOfBaseMent;
	}

	public void setNumberOfBaseMent(Integer numberOfBaseMent) {
		this.numberOfBaseMent = numberOfBaseMent;
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

	public Integer getAreaRentFrom() {
		return areaRentFrom;
	}

	public void setAreaRentFrom(Integer areaRentFrom) {
		this.areaRentFrom = areaRentFrom;
	}

	public Integer getAreaRentTo() {
		return areaRentTo;
	}

	public void setAreaRentTo(Integer areaRentTo) {
		this.areaRentTo = areaRentTo;
	}

	public Integer getCostRentFrom() {
		return costRentFrom;
	}

	public void setCostRentFrom(Integer costRentFrom) {
		this.costRentFrom = costRentFrom;
	}

	public Integer getCostRentTo() {
		return costRentTo;
	}

	public void setCostRentTo(Integer costRentTo) {
		this.costRentTo = costRentTo;
	}
}
