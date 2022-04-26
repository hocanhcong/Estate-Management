package com.laptrinhjavaweb.repository.output;

import com.laptrinhjavaweb.builder.BuildingSearch;
import com.laptrinhjavaweb.dto.input.BuildingSearchRequestDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.BuildingRepositoryCustom;
import com.laptrinhjavaweb.utils.SqlUtils;
import com.laptrinhjavaweb.utils.ValidateUtils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BuildingRepositoryImpl implements BuildingRepositoryCustom {

    @Override
    public List<BuildingEntity> findBuilding(BuildingSearch buildingSearch) {
        List<BuildingEntity> result = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = SqlUtils.getConnection();
            if (conn != null) {
                StringBuilder sql = new StringBuilder("Select * from building as bd");
                sql = buildingBuilderJoinQuery(buildingSearch, sql);
                sql.append(" where 1 = 1 ");
                sql = buildingBuilderSqlPart1(buildingSearch, sql);
                sql = buildingBuilderSqlPart2(buildingSearch, sql);
                sql.append(" group by bd.id ");

                stmt = conn.createStatement();
                System.out.println(sql);
                //rs = stmt.executeQuery("Select * from building");
                rs = stmt.executeQuery(sql.toString());
                while (rs.next()) {
                    BuildingEntity buildingEntity = new BuildingEntity();
                    buildingEntity.setId(rs.getLong("id"));
                    buildingEntity.setName(rs.getString("name"));
                    buildingEntity.setStreet(rs.getString("street"));
                    buildingEntity.setWard(rs.getString("ward"));
                    buildingEntity.setDistrict(rs.getString("district"));
                    buildingEntity.setFloorarea(rs.getInt("floorarea"));
                    buildingEntity.setRentprice(rs.getInt("rentprice"));
                    buildingEntity.setBrokeragetee(rs.getInt("brokeragefee"));
                    buildingEntity.setServicefee(rs.getString("servicefee"));
                    buildingEntity.setType(rs.getString("type"));
                    result.add(buildingEntity);
                }
            }
            return result;
        } catch (SQLException | ArithmeticException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            SqlUtils.ConnectionClosing(conn, stmt, rs);
        }
        return new ArrayList<>();
    }

    private StringBuilder buildingBuilderJoinQuery(BuildingSearch buildingSearch, StringBuilder sql) {
        Long staffIdValue = buildingSearch.getStaffId();
        if(staffIdValue != null)
        {
            sql.append(" INNER JOIN assignmentbuilding as asbd on bd.id = asbd.buildingid");
        }
        Integer areaRentFromValue = buildingSearch.getAreaRentFrom();
        Integer areaRentToValue = buildingSearch.getAreaRentTo();
        if (ValidateUtils.isValid(areaRentFromValue) || ValidateUtils.isValid(areaRentToValue))
        {
            sql.append(" INNER JOIN rentarea as ra on bd.id = ra.buildingid");
        }
        return sql;
    }
    //Part 1:Xây dựng sql normal

    private StringBuilder buildingBuilderSqlPart1(BuildingSearch buildingSearch, StringBuilder sql) {
        Field[] fields = BuildingSearch.class.getDeclaredFields();
        try
        {
            for(int i = 0;i<fields.length;i++)
            {
                fields[i].setAccessible(true);
                String fieldName = fields[i].getName();
                if(!fieldName.equals("buildingTypes")
                        && !fieldName.startsWith("costRent")
                        && !fieldName.startsWith("areaRent")
                        && !fieldName.equals("staffId")
                )
                {
                    Object objValue = fields[i].get(buildingSearch);
                    if(ValidateUtils.isValid(objValue))
                    {
                        if(objValue instanceof String)
                        {
                            sql.append(" and bd." + fieldName.toLowerCase() + " like '%" +objValue +"%'");
                        }
                        else if (objValue instanceof Integer)
                        {
                            sql.append(" and bd." + fieldName.toLowerCase() + " = " + objValue +" ");
                        }
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return sql;
    }

    private StringBuilder buildingBuilderSqlPart2(BuildingSearch buildingSearch, StringBuilder sql) {
        //CostRent
        Integer costRentFromValue = buildingSearch.getCostRentFrom();

        if(ValidateUtils.isValid(costRentFromValue))
        {
            sql.append(" and bd.rentprice >=" + costRentFromValue +"");
        }

        Integer costRentToValue = buildingSearch.getCostRentTo();

        if(ValidateUtils.isValid(costRentToValue))
        {
            sql.append(" and bd.rentprice <=" + costRentToValue +"");
        }

        //Rentarea
        Integer areaRentFromValue = buildingSearch.getAreaRentFrom();

        if(ValidateUtils.isValid(areaRentFromValue))
        {
            sql.append(" and ra.value>=" +areaRentFromValue+"");
        }

        Integer areaRentToValue = buildingSearch.getAreaRentTo();

        if(ValidateUtils.isValid(areaRentToValue))
        {
            sql.append(" and ra.value<=" +areaRentToValue+"");
        }
        //staffid-->Xử lý sau cùng
        Long staffIdValue = buildingSearch.getStaffId();
        if(ValidateUtils.isValid(staffIdValue))
        {
            sql.append(" and asbd.staffid=" + ""+staffIdValue+"" +"");
        }

        //Types
        String types[] = buildingSearch.getBuildingTypes();
        if (types != null && types.length>0)
        {
            sql.append(" and ( ");
            String sqlType = Arrays.stream(types).map(item-> "  bd.type like '%"+item+"%' ").collect(Collectors.joining(" or "));
            sql.append(sqlType);
            sql.append(" ) ");
        }
        return sql;
    }
}
