package com.laptrinhjavaweb.constant;

import com.laptrinhjavaweb.buildingenum.DistrictEnum;
import com.laptrinhjavaweb.buildingenum.TypeBuildingEnum;

import java.util.HashMap;
import java.util.Map;

public class SystemConstant {
    /*Spring security 4: ROLE_ADMIN, Spring security 3 not required*/
    public static final String ADMIN_ROLE = "ROLE_ADMIN";
    /*Spring security 4: ROLE_ADMIN, Spring security 3 not required*/
    public static final String USER_ROLE = "ROLE_USER";
    public static final String MANAGER_ROLE = "MANAGER";
    public static final String HOME = "/trang-chu";
    public static final String ADMIN_HOME = "/admin/home";
    public static final String MODEL = "model";
    public static final String INSERT_SUCCESS = "insert_success";
    public static final String UPDATE_SUCCESS = "update_success";
    public static final String DELETE_SUCCESS = "delete_success";
    public static final String ERROR_SYSTEM = "error_system";
    public static final String ALERT = "alert";
    public static final String MESSAGE_RESPONSE = "messageResponse";
    public static final String PASSWORD_DEFAULT = "123456";
    public static final String CHANGE_PASSWORD_FAIL = "change_password_fail";
    public final static String DB_URL = "jdbc:mysql://localhost:3306/estateadvance";
    public final static String USER = "root";
    public final static String PASS = "31121996";
    public final static String DRIVER = "com.mysql.jdbc.Driver";

    public static Map<String,String> typeTable()
    {
        Map<String,String> result = new HashMap<>();
        for(TypeBuildingEnum item: TypeBuildingEnum.values())
        {
            result.put(item.name(), item.getValue());
        }
        return result;
    }

    public static Map<String,String> districtTable()
    {
        Map<String,String> result = new HashMap<>();
        for(DistrictEnum item:DistrictEnum.values())
        {
            result.put(item.name(), item.getValue());
        }
        return result;
    }
}
