package com.testshop.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.testshop.common.Coder;
import com.testshop.common.DataBaseConnector;
import com.testshop.pojo.CommentBean;
import com.testshop.pojo.GoodsBean;

public class CommentDao {
	public static int admin_insert(CommentBean comment) {
		//0:成功 1:數据庫錯誤 2:商品不存在 3:用户不存在 4:被@用户不存在 5:被@用户没有在此帖子下评论过
		
		int res = 0;
		int count = 0;
		ResultSet rs =null;
		PreparedStatement ps= null;
		
		try {		
			Statement st1 = DataBaseConnector.getStatement();
			rs = st1.executeQuery("select GOODS_PUBLISHER from goods where GOODS_ID=" + comment.getGoodsId() + " and GOODS_STATE=0");
			if (!rs.next()) return 2;
			String goodsPublisherId = rs.getString(1);
			
			Statement st2 = DataBaseConnector.getStatement();
			rs = st2.executeQuery("select USER_ID from user where USER_ID='" + comment.getPublisherId() + "'");
			if (!rs.next())
				return 3;
		
			String parentId = null;
			if(!comment.getParentId().equals(""))
				parentId = Coder.encrypted(comment.getParentId());

			if(parentId != null) {
				Statement st3 = DataBaseConnector.getStatement();
				System.out.println(comment.getGoodsId());
				System.out.println(parentId);
				rs = st3.executeQuery("select USER_ID from user where USER_MD5ID='" + parentId + "'");
				if (!rs.next())
					return 4;
				rs = st3.executeQuery("select count(*) from comment where COMMENT_PUBLISHER='" 
										+ parentId + "' and COMMENT_GOODS_ID=" + comment.getGoodsId());
				if(rs.next())
					count = rs.getInt(1);
				if(count == 0)
					return 5;
			}
			
			String sql = "insert into comment(COMMENT_GOODS_ID, COMMENT_PARENT, COMMENT_CONTENT, COMMENT_PUBLISHER, COMMENT_GOODS_PUBLISHER) value(?,?,?,?,?)";
											 
			ps = DataBaseConnector.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, comment.getGoodsId());
			ps.setString(2, parentId);
			ps.setString(3, comment.getContent());
			ps.setString(4, Coder.encrypted(comment.getPublisherId()));
			ps.setString(5, goodsPublisherId);
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return 1;
		} finally {
			try {
				if(ps != null)
					ps.close();
				if(rs != null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return (res > 0) ? 0 : 1;
	}
	
	public static int admin_update(CommentBean comment) {
		//0:成功 1:數据庫錯誤 2:商品不存在 3:被@用户不存在 4:被@用户没有在此帖子下评论过
		
		int res = 0;
		int count = 0;
		ResultSet rs =null;
		PreparedStatement ps= null;
		
		try {		
			Statement st1 = DataBaseConnector.getStatement();
			rs = st1.executeQuery("select GOODS_PUBLISHER from goods where GOODS_ID=" + comment.getGoodsId() + " and GOODS_STATE=0");
			if (!rs.next()) return 2;
			String goodsPublisherId = rs.getString(1);
			
			String parentId = Coder.encrypted(comment.getParentId());
			if(parentId != null) {
				Statement st2 = DataBaseConnector.getStatement();
				rs = st2.executeQuery("select USER_ID from user where USER_MD5ID='" + comment.getParentId() + "'");
				if (!rs.next())
					return 3;
				rs = st2.executeQuery("select count(*) from comment where COMMENT_PARENT='" 
										+ parentId + "' and COMMENT_GOODS_ID=" + comment.getGoodsId());
				if(rs.next())
					count = rs.getInt(1);
				if(count == 0)
					return 4;
			}
			
			String sql = "update comment set COMMENT_GOODS_ID=?, COMMENT_PARENT=?, COMMENT_CONTENT=?, COMMENT_PUBLISHER=?, COMMENT_GOODS_PUBLISHER=? where COMMENT_ID=?";
											 
			ps = DataBaseConnector.getConnection().prepareStatement(sql);
			ps.setString(1, comment.getGoodsId());
			ps.setString(2, parentId);
			ps.setString(3, comment.getContent());
			ps.setString(4, Coder.encrypted(comment.getPublisherId()));
			ps.setString(5, goodsPublisherId);
			ps.setString(6, comment.getId());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return 1;
		} finally {
			try {
				if(ps != null)
					ps.close();
				if(rs != null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return (res > 0) ? 0 : 1;
	}
	
	public static int admin_delete(String id) {
		//0:成功 1:數据庫錯誤 2:评论不存在
		int res = 0;
		PreparedStatement ps= null;

		try {
			String sql = "delete from comment where comment_ID=?";
			ps = DataBaseConnector.getConnection().prepareStatement(sql);
			ps.setString(1, id);
			res = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return 1;
		}
		
		return (res > 0) ? 0 : 2;
	}

	/**
	 * 获取总记录数和总页数
	 * @param count		每页记录数
	 * @param keywords	搜索关键字
	 * @return
	 */
	public static int[] admin_totalPage(int count, String keywords) {
		int arr[] = { 0, 1 };

		
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			if (keywords != null && !keywords.isEmpty()) {
				String sql = "select count(*) from comment where CAMMENT_PUBLISHER = ?";
				ps = DataBaseConnector.getConnection().prepareStatement(sql);
				ps.setString(1, keywords);

			} else {
				String sql = "select count(*) from comment";
				ps = DataBaseConnector.getConnection().prepareStatement(sql);
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
			try {
				if(ps != null)
					ps.close();
				if(rs != null)
					rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
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
	public static ArrayList<CommentBean> admin_selectAll(int cpage, int count, String keywords) {
		ArrayList<CommentBean> list = new ArrayList<CommentBean>();
		ResultSet rs = null;

		

		PreparedStatement ps = null;

		try {
			if (keywords != null && !keywords.isEmpty()) {
				String sql = "select * from comment where COMMENT_PUBLISHER=? order by comment_ID asc limit ?, ?";
				ps = DataBaseConnector.getConnection().prepareStatement(sql);
				ps.setString(1, keywords);
				ps.setInt(2, (cpage - 1) * count);
				ps.setInt(3, count);

			} else {
				String sql = "select * from comment order by comment_ID asc limit ?, ?";
				ps = DataBaseConnector.getConnection().prepareStatement(sql);
				ps.setInt(1, (cpage - 1) * count);
				ps.setInt(2, count);
			}
			
			rs = ps.executeQuery();

			while (rs.next()) {
				CommentBean comment = new CommentBean(
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
			try {
				if(ps != null)
					ps.close();
				if(rs != null)
					rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		return list;
	}
	
	/**
	 * 通过ID查找评论
	 * @param id 指定ID
	 * @return 返回评论实体
	 */
	public static CommentBean admin_selectByID(String id) {
		CommentBean comment = null;
		ResultSet rs = null;

		PreparedStatement ps = null;

		try {
			String sql = "select * from comment where comment_ID=?";
			
			ps = DataBaseConnector.getConnection().prepareStatement(sql);
			ps.setString(1, id);

			rs = ps.executeQuery();

			while (rs.next()) {
				comment = new CommentBean(
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
			try {
				if(ps != null)
					ps.close();
				if(rs != null)
					rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		return comment;
	}
	
	public static CommentBean selectByID(String id) {
		CommentBean comment = null;
		ResultSet rs = null;

		PreparedStatement ps = null;

		try {
			String sql = "select * from comment where comment_ID=?";
			
			ps = DataBaseConnector.getConnection().prepareStatement(sql);
			ps.setString(1, id);

			rs = ps.executeQuery();

			while (rs.next()) {
				comment = new CommentBean(
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
			try {
				if(ps != null)
					ps.close();
				if(rs != null)
					rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		return comment;
	}
	
	public static int insertComment(CommentBean comment) {
		//0:成功 1:數据庫錯誤 2:商品不存在 3:被@用户不存在 4:被@用户没有在此帖子下评论过
		
		int res = 0;
		int count = 0;
		ResultSet rs =null;
		PreparedStatement ps= null;
		
		try {		
			Statement st1 = DataBaseConnector.getStatement();
			rs = st1.executeQuery("select GOODS_PUBLISHER from goods where GOODS_ID=" + Integer.valueOf(comment.getGoodsId()) + " and GOODS_STATE=0");
			if (!rs.next()) return 2;
			String goodsPublisherId = rs.getString(1);
			
			String parentId = comment.getParentId();
			if(comment.getParentId() != null) {
				Statement st2 = DataBaseConnector.getStatement();
				System.out.println(parentId);
				rs = st2.executeQuery("select USER_ID from user where USER_MD5ID='" + parentId + "'");
				if (!rs.next())
					return 3;
				rs = st2.executeQuery("select count(*) from comment where COMMENT_PUBLISHER='"
										+ parentId + "' and COMMENT_GOODS_ID=" + comment.getGoodsId());
				if(rs.next())
					count = rs.getInt(1);
				if(count == 0)
					return 4;
				

			}
			
			String sql = "insert into comment(COMMENT_GOODS_ID, COMMENT_PARENT, COMMENT_CONTENT, COMMENT_PUBLISHER, COMMENT_GOODS_PUBLISHER) value(?,?,?,?,?)";
											 
			ps = DataBaseConnector.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, comment.getGoodsId());
			ps.setString(2, parentId);
			ps.setString(3, comment.getContent());
			ps.setString(4, comment.getPublisherId());
			ps.setString(5, goodsPublisherId);
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return 1;
		} finally {
			try {
				if(ps != null)
					ps.close();
				if(rs != null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return (res > 0) ? 0 : 1;
	}

	public static int getGoodsCommentNum(String goodsId) {
		int commentNum = 0;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		try {
			String sql = "select count(*) from comment where COMMENT_GOODS_ID=?";
			pstmt = DataBaseConnector.getConnection().prepareStatement(sql);
			pstmt.setString(1,  goodsId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				commentNum = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(rs != null)
					rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		return commentNum;
	}

	public static ResultSet getGoodsComments(String goodsId, String page, int count) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
	
		try {
			String sql = "select * from comment where COMMENT_GOODS_ID=? limit ?, ?";
			pstmt = DataBaseConnector.getConnection().prepareStatement(sql);
			pstmt.setString(1,  goodsId);
			pstmt.setInt(2, (Integer.valueOf(page) - 1) * count);
			pstmt.setInt(3, count);
	
			rs = pstmt.executeQuery();
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return rs;
	}
	
	public static int getUserGoodsCommentNum(String userId) {
		int commentNum = 0;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		try {
			String sql = "select count(*) from comment where COMMENT_GOODS_PUBLISHER=? and COMMENT_PUBLISHER!=?";
			pstmt = DataBaseConnector.getConnection().prepareStatement(sql);
			pstmt.setString(1,  userId);
			pstmt.setString(2,  userId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				commentNum = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(rs != null)
					rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		return commentNum;
	}

	public static ResultSet getUserGoodsComments(String userId, String page, int count) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
	
		try {
			String sql = "select * from comment where COMMENT_GOODS_PUBLISHER=? and COMMENT_PUBLISHER!=? limit ?, ?";
			pstmt = DataBaseConnector.getConnection().prepareStatement(sql);
			pstmt.setString(1,  userId);
			pstmt.setString(2,  userId);
			pstmt.setInt(3, (Integer.valueOf(page) - 1) * count);
			pstmt.setInt(4, count);
	
			rs = pstmt.executeQuery();
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return rs;
	}
	
	public static int getUserReplyNum(String userId) {
		int commentNum = 0;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		try {
			String sql = "select count(*) from comment where COMMENT_PARENT=? and COMMENT_PUBLISHER!=?";
			pstmt = DataBaseConnector.getConnection().prepareStatement(sql);
			pstmt.setString(1,  userId);
			pstmt.setString(2,  userId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				commentNum = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(rs != null)
					rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		return commentNum;
	}

	public static ResultSet getUserReply(String userId, String page, int count) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
	
		try {
			String sql = "select * from comment where COMMENT_PARENT=? and COMMENT_PUBLISHER!=? limit ?, ?";
			pstmt = DataBaseConnector.getConnection().prepareStatement(sql);
			pstmt.setString(1,  userId);
			pstmt.setString(2,  userId);
			pstmt.setInt(3, (Integer.valueOf(page) - 1) * count);
			pstmt.setInt(4, count);
	
			rs = pstmt.executeQuery();
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return rs;
	}
}
