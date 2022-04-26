package com.laptrinhjavaweb.utils;

import com.laptrinhjavaweb.constant.SystemConstant;

import java.sql.*;

public class SqlUtils {
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(SystemConstant.DRIVER);
            return DriverManager.getConnection(SystemConstant.DB_URL, SystemConstant.USER,
                    SystemConstant.PASS);

        } catch (ClassNotFoundException | SQLException  ex) {
            throw new SQLException("Could not get connection!");
        }
    }

    public static void ConnectionClosing(Connection conn, Statement stmt, ResultSet rs) {
        try
        {
            if(conn!=null)
            {
                conn.close();
            }
            if(rs!=null)
            {
                rs.close();
            }
            if(stmt!=null)
            {
                stmt.close();
            }
        }
        catch(SQLException e)
        {
            e.getMessage();
        }
    }
}
