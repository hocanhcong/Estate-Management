package com.laptrinhjavaweb.utils;

public class ValidateUtils {
    public static boolean isValid (Object obj)
    {
        //Obj hoặc là Integer or là String
        boolean isTrue = obj != null && !(obj.toString().isEmpty());
        if(isTrue)
        {
            if(obj instanceof String) {
                return true;
            }
            else if(obj instanceof Integer)
            {
                return Integer.parseInt(obj.toString()) >=0; //dành cho các trường area
            }
            else if(obj instanceof Long)
            {
                return Long.parseLong(obj.toString()) >= 0;
            }
        }
        return false;
    }

    public static boolean isNotBlank(String value)
    {
        if(value.isEmpty() || value == null)
        {
            return false;
        }
        return true;
    }
}
