package com.testshop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.testshop.dao.Basedao;
import com.testshop.entity.TESTSHOP_CART;
import com.testshop.entity.TESTSHOP_CART;

public class TESTSHOP_CARTDao {
	public static int insert(TESTSHOP_CART cart) {

		String sql = "insert into cart value(?,?,?,?)";

		Object[] params = { null,
				cart.getUSER_ID(),
				cart.getGOODS_ID(),
				cart.getGOODS_COUNT()};

		return Basedao.exectuIUD(sql, params);
	}
	
	public static int update(TESTSHOP_CART cart) {

		String sql = "update cart set USER_ID=?, GOODS_ID=?, GOODS_COUNT=? where CART_ID = ?";

		Object[] params = { 
				cart.getUSER_ID(),
				cart.getGOODS_ID(),
				cart.getGOODS_COUNT(),
				cart.getCART_ID()};

		return Basedao.exectuIUD(sql, params);
	}
	
	public static int delete(String id) {
		String sql = "delete from cart where CART_ID=?";
		
		Object[] params = {id};
		
		return Basedao.exectuIUD(sql, params);
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
			if (keywords != null && !keywords.isEmpty()) {
				String sql = "select count(*) from cart where USER_ID = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, keywords);

			} else {
				String sql = "select count(*) from cart";
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
	 * 通过关键字查找某用户ID购物车列表
	 * @param cpage 当前页数
	 * @param count 显示个数
	 * @param keywords 搜索关键字
	 * @return 返回指定的购物车集
	 */
	public static ArrayList<TESTSHOP_CART> selectAll(int cpage, int count, String keywords) {
		ArrayList<TESTSHOP_CART> list = new ArrayList<TESTSHOP_CART>();
		ResultSet rs = null;

		Connection conn = Basedao.getconn();

		PreparedStatement ps = null;

		try {
			if (keywords != null && !keywords.isEmpty()) {
				String sql = "select * from cart where USER_ID=? order by CART_ID asc limit ?, ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, keywords);
				ps.setInt(2, (cpage - 1) * count);
				ps.setInt(3, count);

			} else {
				String sql = "select * from cart order by CART_ID asc limit ?, ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, (cpage - 1) * count);
				ps.setInt(2, count);

			}

			rs = ps.executeQuery();

			while (rs.next()) {
				TESTSHOP_CART cart = new TESTSHOP_CART(
						rs.getString("CART_ID"),
						rs.getString("USER_ID"),
						rs.getString("GOODS_ID"),
						rs.getString("GOODS_COUNT")	
				);
				list.add(cart);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return list;
	}
	
	/**
	 * 通过ID查找购物车
	 * @param id 指定ID
	 * @return 返回购物车实体
	 */
	public static TESTSHOP_CART selectByID(String id) {
		TESTSHOP_CART cart = null;
		ResultSet rs = null;

		Connection conn = Basedao.getconn();

		PreparedStatement ps = null;

		try {
			String sql = "select * from cart where CART_ID=?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);

			rs = ps.executeQuery();

			while (rs.next()) {
				cart = new TESTSHOP_CART(
						rs.getString("CART_ID"),
						rs.getString("USER_ID"),
						rs.getString("GOODS_ID"),
						rs.getString("GOODS_COUNT")	
				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return cart;
	}
}
