package com.laptrinhjavaweb.buildingenum;

public enum DistrictEnum {

        QUAN_1 ("QUẬN 1"),
        QUAN_2 ("QUẬN 2"),
        QUAN_4 ("QUẬN 4");

        private final String value;

        private DistrictEnum(String value)
        {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

}
