package com.testshop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.testshop.dao.Basedao;
import com.testshop.entity.TESTSHOP_GOODS;
import com.testshop.entity.TESTSHOP_GOODS;

public class TESTSHOP_GOODSDao {
	public static int insert(TESTSHOP_GOODS goods) {
		String sql = "insert into goods(GOODS_ID, GOODS_TYPE, GOODS_DESC, GOODS_TITLE, GOODS_PRICE, GOODS_COUNT, GOODS_IMAGES, GOODS_ADDRESS, GOODS_CONTACT, GOODS_PUBLISHER) value(?,?,?,?,?,?,?,?,?,?)";

		Object[] params1 = { null,
				goods.getGOODS_TYPE(),
				goods.getGOODS_DESC(),
				goods.getGOODS_TITLE(),
				goods.getGOODS_PRICE(),
				goods.getGOODS_COUNT(),
				goods.getGOODS_IMAGES(),
				goods.getGOODS_ADDRESS(),
				goods.getGOODS_CONTACT(),
				goods.getGOODS_PUBLISHER()
		};
		
		int count =0;
		Connection conn =Basedao.getconn();
		
		PreparedStatement ps =null;
		
		try{
			ps =conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			for(int i=0;i<params1.length; i++){
				ps.setObject(i+1,params1[i]);
			}
			count = ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			
			if(rs.next()) {
				sql = "insert into goodsrecm value(?, now(), ?, 0)";
				
				Object[] params2 = {
						rs.getInt(1),
						goods.getGOODS_TYPE(),
				};
				
				count = Basedao.executeIUD(sql, params2);
			}
			
			
			
		} catch(SQLException e){
			e.printStackTrace();
		}finally{
			Basedao.closeall(null,ps,conn);
		}

		
		return count;
	}
	
	public static int update(TESTSHOP_GOODS goods) {

		String sql = "update goods set GOODS_TYPE=?, GOODS_DESC=?, GOODS_TITLE=?, GOODS_STATE=?, GOODS_PRICE=?, GOODS_COUNT=?, GOODS_IMAGES=?, GOODS_ADDRESS=?, GOODS_CONTACT=?, GOODS_PUBLISHER=? where GOODS_ID = ?";

		Object[] params = { 
				goods.getGOODS_TYPE(),
				goods.getGOODS_DESC(),
				goods.getGOODS_TITLE(),
				goods.getGOODS_STATE(),
				goods.getGOODS_PRICE(),
				goods.getGOODS_COUNT(),
				goods.getGOODS_IMAGES(),
				goods.getGOODS_ADDRESS(),
				goods.getGOODS_CONTACT(),
				goods.getGOODS_PUBLISHER(),
				goods.getGOODS_ID()
		};
		
		return Basedao.executeIUD(sql, params);
	}
	
	public static int delete(String id) {
		String sql = "delete from goodsrecm where GOODSRECM_ID=?";
		
		Object[] params = {id};
		
		Basedao.executeIUD(sql, params);
		
		sql = "delete from goods where GOODS_ID=?";
		
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
				String sql = "select count(*) from goods where GOODS_TITLE like ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, "%" + keywords + "%");

			} else {
				String sql = "select count(*) from goods";
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
	 * 通过关键字查找商品列表
	 * @param cpage 当前页数
	 * @param count 显示个数
	 * @param keywords 搜索关键字
	 * @return 返回指定的商品集
	 */
	public static ArrayList<TESTSHOP_GOODS> selectAll(int cpage, int count, String keywords) {
		ArrayList<TESTSHOP_GOODS> list = new ArrayList<TESTSHOP_GOODS>();
		ResultSet rs = null;

		Connection conn = Basedao.getconn();

		PreparedStatement ps = null;

		try {
			if (keywords != null) {
				String sql = "select * from goods where GOODS_TITLE like ? order by GOODS_ID asc limit ?, ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, "%" + keywords + "%");
				ps.setInt(2, (cpage - 1) * count);
				ps.setInt(3, count);

			} else {
				String sql = "select * from goods order by GOODS_ID asc limit ?, ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, (cpage - 1) * count);
				ps.setInt(2, count);

			}

			rs = ps.executeQuery();

			while (rs.next()) {
				TESTSHOP_GOODS goods = new TESTSHOP_GOODS(
						rs.getString("GOODS_ID"),
						rs.getString("GOODS_TYPE"),
						rs.getString("GOODS_DESC"),
						rs.getString("GOODS_TITLE"),
						rs.getString("GOODS_STATE"),
						rs.getString("GOODS_PRICE"),
						rs.getString("GOODS_COUNT"),
						rs.getString("GOODS_IMAGES"),
						rs.getString("GOODS_ADDRESS"),
						rs.getString("GOODS_CONTACT"),
						rs.getString("GOODS_PUBLISHER")
				);
				list.add(goods);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return list;
	}
	
	/**
	 * 通过ID查找商品
	 * @param id 指定ID
	 * @return 返回商品实体
	 */
	public static TESTSHOP_GOODS selectByID(String id) {
		TESTSHOP_GOODS goods = null;
		ResultSet rs = null;

		Connection conn = Basedao.getconn();

		PreparedStatement ps = null;

		try {
			String sql = "select * from goods where GOODS_ID=?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);

			rs = ps.executeQuery();

			while (rs.next()) {
				goods = new TESTSHOP_GOODS(
						rs.getString("GOODS_ID"),
						rs.getString("GOODS_TYPE"),
						rs.getString("GOODS_DESC"),
						rs.getString("GOODS_TITLE"),
						rs.getString("GOODS_STATE"),
						rs.getString("GOODS_PRICE"),
						rs.getString("GOODS_COUNT"),
						rs.getString("GOODS_IMAGES"),
						rs.getString("GOODS_ADDRESS"),
						rs.getString("GOODS_CONTACT"),
						rs.getString("GOODS_PUBLISHER")
				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return goods;
	}
}
