package com.testshop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.testshop.dao.Basedao;
import com.testshop.entity.TESTSHOP_COMMENT;
import com.testshop.entity.TESTSHOP_GOODS;
import com.testshop.entity.TESTSHOP_COMMENT;

public class TESTSHOP_COMMENTDao {
	public static int insert(TESTSHOP_COMMENT comment) {

		String sql = "insert into comment value(?, now(), ?, ?, ?, ?, ?)";

		Object[] params = { null,
				comment.getCOMMENT_PARENT(),
				comment.getCOMMENT_CONTENT(),
				comment.getCOMMENT_GOODS_ID(),
				comment.getCOMMENT_PUBLISHER(),
				comment.getCOMMENT_GOODS_PUBLISHER()
		};

		return Basedao.exectuIUD(sql, params);
	}
	
	public static int update(TESTSHOP_COMMENT comment) {
		
		String sql = "update comment set COMMENT_TIME=?, COMMENT_PARENT=?, COMMENT_CONTENT=?, COMMENT_GOODS_ID=?, COMMENT_PUBLISHER , COMMENT_GOODS_PUBLUSHER where COMMENT_ID = ?";

		Object[] params = { 
				comment.getCOMMENT_TIME(),
				comment.getCOMMENT_PARENT(),
				comment.getCOMMENT_CONTENT(),
				comment.getCOMMENT_GOODS_ID(),
				comment.getCOMMENT_PUBLISHER(),
				comment.getCOMMENT_GOODS_PUBLISHER()
		};

		return Basedao.exectuIUD(sql, params);
	}
	
	public static int delete(String id) {
		String sql = "delete from comment where comment_ID=?";
		
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
				String sql = "select count(*) from comment where CAMMENT_PUBLISHER = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, keywords);

			} else {
				String sql = "select count(*) from comment";
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
	 * 通过关键字查找某用户ID评论列表
	 * @param cpage 当前页数
	 * @param count 显示个数
	 * @param keywords 搜索关键字
	 * @return 返回指定的评论集
	 */
	public static ArrayList<TESTSHOP_COMMENT> selectAll(int cpage, int count, String keywords) {
		ArrayList<TESTSHOP_COMMENT> list = new ArrayList<TESTSHOP_COMMENT>();
		ResultSet rs = null;

		Connection conn = Basedao.getconn();

		PreparedStatement ps = null;

		try {
			if (keywords != null && !keywords.isEmpty()) {
				String sql = "select * from comment where COMMENT_PUBLISHER=? order by comment_ID asc limit ?, ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, keywords);
				ps.setInt(2, (cpage - 1) * count);
				ps.setInt(3, count);

			} else {
				String sql = "select * from comment order by comment_ID asc limit ?, ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, (cpage - 1) * count);
				ps.setInt(2, count);
			}
			
			rs = ps.executeQuery();

			while (rs.next()) {
				TESTSHOP_COMMENT comment = new TESTSHOP_COMMENT(
						rs.getString("COMMENT_ID"),
						rs.getString("COMMENT_TIME"),
						rs.getString("COMMENT_PARENT"),
						rs.getString("COMMENT_CONTENT"),
						rs.getString("COMMENT_GOODS_ID"),
						rs.getString("COMMENT_PUBLISHER"),
						rs.getString("COMMENT_GOODS_PUBLISHER")	
				);
				list.add(comment);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return list;
	}
	
	/**
	 * 通过ID查找评论
	 * @param id 指定ID
	 * @return 返回评论实体
	 */
	public static TESTSHOP_COMMENT selectByID(String id) {
		TESTSHOP_COMMENT comment = null;
		ResultSet rs = null;

		Connection conn = Basedao.getconn();

		PreparedStatement ps = null;

		try {
			String sql = "select * from comment where comment_ID=?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);

			rs = ps.executeQuery();

			while (rs.next()) {
				comment = new TESTSHOP_COMMENT(
						rs.getString("COMMENT_ID"),
						rs.getString("COMMENT_TIME"),
						rs.getString("COMMENT_PARENT"),
						rs.getString("COMMENT_CONTENT"),
						rs.getString("COMMENT_GOODS_ID"),
						rs.getString("COMMENT_PUBLISHER"),
						rs.getString("COMMENT_GOODS_PUBLISHER")	
				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return comment;
	}
}
