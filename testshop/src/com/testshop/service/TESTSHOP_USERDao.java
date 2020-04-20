package com.testshop.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.testshop.dao.Basedao;
import com.testshop.entity.TESTSHOP_USER;

public class TESTSHOP_USERDao {
	public static int insert(TESTSHOP_USER u){
		
	String sql="insert into user value(?,?,?,?,?,?,?)";
	
	Object[] params={u.getUSER_ID(),
			u.getUSER_NAME(),
			u.getUSER_PASSWORD(),
			u.getUSER_IDENTITY(),
			u.getUSER_EMAIL(),
			u.getUSER_STUNUM(),
			u.getUSER_QQ()
			};
	
	return Basedao.exectuIUD(sql,params);
}
	
	public static int[] totalPage(int count) {
		int arr[]={0,1};
		
		Connection conn =Basedao.getconn();
		PreparedStatement ps =null;
		ResultSet rs =null;
		
		try {
			String sql ="select count(*) from user";
			
			ps = conn.prepareStatement(sql);
			
			rs= ps.executeQuery();
			while(rs.next()){
				arr[0]=rs.getInt(1);
				
				if(arr[0]%count==0)
				{arr[1] = arr[0]/count;
				}
				else{
					arr[1]=arr[0]/count+1;
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		
		return arr;
		
	}
	
	public static ArrayList<TESTSHOP_USER> selectAll(int cpage, int count){
		 ArrayList<TESTSHOP_USER> list =new  ArrayList<TESTSHOP_USER>();
		ResultSet rs =null;
		
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps =null;
		
		try {
			String sql = "select * from user order by USER_ID asc limit ?, ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (cpage-1)*count);
			ps.setInt(2, count);
			rs=ps.executeQuery();
			
			while(rs.next()){
				TESTSHOP_USER u =new TESTSHOP_USER(
						rs.getString("USER_ID"),
						rs.getString("USER_NAME"),
						rs.getString("USER_PASSWORD"),
						rs.getString("USER_IDENTITY"),
						rs.getString("USER_EMAIL"),
						rs.getString("USER_STUNUM"),
						rs.getString("USER_QQ")
						
						);
				list.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs,ps,conn);
		}
		
		
		
		
		 return list;
	}
}