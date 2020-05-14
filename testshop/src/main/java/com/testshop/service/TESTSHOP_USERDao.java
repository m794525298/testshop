package com.testshop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.alibaba.fastjson.JSONObject;
import com.testshop.dao.Basedao;
import com.testshop.entity.TESTSHOP_USER;

public class TESTSHOP_USERDao {
	public static int insert(TESTSHOP_USER u) {

		String sql = "insert into user value(?,?,?,?,?,?,?,?,?,?)";

		Object[] params = { 
				null,
				u.getUSER_NAME(),
				u.getUSER_ACCOUNT(),
				u.getUSER_PASSWORD(),
				u.getUSER_ICON(),
				u.getUSER_EMAIL(),
				u.getUSER_STUNUM(),
				u.getUSER_ADDRESS(),
				u.getUSER_CONTACT(),
				u.getUSER_IDENTITY(),
		};

		return Basedao.executeIUD(sql, params);
	}
	
	public static int update(TESTSHOP_USER u) {

		String sql = "update user set USER_NAME=?, USER_ACCOUNT=?, USER_PASSWORD=?, USER_ICON=?, USER_EMAIL=?, USER_STUNUM=?, USER_ADDRESS=?, USER_CONTACT=?, USER_IDENTITY=? where USER_ID = ?";

		Object[] params = { 
				u.getUSER_NAME(),
				u.getUSER_ACCOUNT(),
				u.getUSER_PASSWORD(),
				u.getUSER_ICON(),
				u.getUSER_EMAIL(),
				u.getUSER_STUNUM(),
				u.getUSER_ADDRESS(),
				u.getUSER_CONTACT(),
				u.getUSER_IDENTITY(),
				u.getUSER_ID()
		};

		return Basedao.executeIUD(sql, params);
	}
	
	public static int delete(String id) {
		String sql = "delete from user where USER_ID=?";
		
		Object[] params = {id};
		
		return Basedao.executeIUD(sql, params);
	}

	/**
	 * 获取总记录数和总页数
	 * @param count		每页记录数
	 * @param keywords	搜索关键字
	 * @return
	 */
	public static int[] totalPage(int count, String keywords) {
		int arr[] = { 0, 1 };

		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			if (keywords != null) {
				String sql = "select count(*) from user where USER_NAME like ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, "%" + keywords + "%");

			} else {
				String sql = "select count(*) from user";
				ps = conn.prepareStatement(sql);
			}

			rs = ps.executeQuery();
			while (rs.next()) {
				arr[0] = rs.getInt(1);

				if (arr[0] % count == 0) {
					arr[1] = arr[0] / count;
				} else {
					arr[1] = arr[0] / count + 1;
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return arr;

	}
	
	/**
	 * 通过关键字查找用户列表
	 * @param cpage 当前页数
	 * @param count 显示个数
	 * @param keywords 搜索关键字
	 * @return 返回指定的用户集
	 */
	public static ArrayList<TESTSHOP_USER> selectAll(int cpage, int count, String keywords) {
		ArrayList<TESTSHOP_USER> list = new ArrayList<TESTSHOP_USER>();
		ResultSet rs = null;

		Connection conn = Basedao.getconn();

		PreparedStatement ps = null;

		try {
			if (keywords != null) {
				String sql = "select * from user where USER_NAME like ? order by USER_ID asc limit ?, ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, "%" + keywords + "%");
				ps.setInt(2, (cpage - 1) * count);
				ps.setInt(3, count);

			} else {
				String sql = "select * from user order by USER_ID asc limit ?, ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, (cpage - 1) * count);
				ps.setInt(2, count);

			}

			rs = ps.executeQuery();

			while (rs.next()) {
				TESTSHOP_USER u = new TESTSHOP_USER(
						rs.getString("USER_ID"),
						rs.getString("USER_NAME"),
						rs.getString("USER_ACCOUNT"),
						rs.getString("USER_PASSWORD"),
						rs.getString("USER_ICON"),
						rs.getString("USER_EMAIL"),
						rs.getString("USER_STUNUM"),
						rs.getString("USER_ADDRESS"),
						rs.getString("USER_CONTACT"),
						rs.getString("USER_IDENTITY")
				);
				list.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return list;
	}
	
	/**
	 * 通过ID查找用户
	 * @param id 指定ID
	 * @return 返回用户实体
	 */
	public static TESTSHOP_USER selectByID(String id) {
		TESTSHOP_USER u = null;
		ResultSet rs = null;

		Connection conn = Basedao.getconn();

		PreparedStatement ps = null;

		try {
			String sql = "select * from user where USER_ID=?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);

			rs = ps.executeQuery();

			while (rs.next()) {
				u = new TESTSHOP_USER(
						rs.getString("USER_ID"),
						rs.getString("USER_NAME"),
						rs.getString("USER_ACCOUNT"),
						rs.getString("USER_PASSWORD"),
						rs.getString("USER_ICON"),
						rs.getString("USER_EMAIL"),
						rs.getString("USER_STUNUM"),
						rs.getString("USER_ADDRESS"),
						rs.getString("USER_CONTACT"),
						rs.getString("USER_IDENTITY")
				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return u;
	}


	public static int selectByAccount(String account) {
		int count = 0;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "select count(*) from user where USER_ACCOUNT=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, account);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return count;
	}

	public static int selectByEmail(String email) {
		int count = 0;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "select count(*) from user where USER_EMAIL=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				count = rs.getInt(1);
				System.out.println(count);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return count;
	}
}