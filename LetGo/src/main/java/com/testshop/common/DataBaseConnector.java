package com.testshop.common;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class DataBaseConnector {
	
private static Connection conn;
	
	static{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			setConnection();
			System.setProperty("user.home", "D:/Program Files/eclipse/eclipse-workspace");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
	}
	
	public static Statement getStatement(){
		try {
			return getConnection().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	public static PreparedStatement getPreparedStatement(String sql) {
		try {
			setConnection();
			return conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Connection getConnection() {
		setConnection();
		return conn;
	}
	
	public static Map<String, String> getResultMap(ResultSet rs)
            throws SQLException {
        Map<String, String> hm = new HashMap<String, String>();
        ResultSetMetaData rsmd = rs.getMetaData();
        int count = rsmd.getColumnCount();
        for (int i = 1; i <= count; i++) {
            String key = rsmd.getColumnLabel(i);
            String value = rs.getString(i);
            hm.put(key, value);
        }
        return hm;
    }
	
	public static Connection setConnection() {
		try {
			conn = ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
         
	}
}