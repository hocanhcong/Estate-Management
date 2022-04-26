package com.laptrinhjavaweb.buildingenum;

public enum TypeBuildingEnum {
        TANG_TRET ("TẦNG TRỆT"),
        NGUYEN_CAN ("NGUYÊN CĂN"),
        NOI_THAT ("NỘI THẤT");

    private final String value;

    private TypeBuildingEnum(String value)
    {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
