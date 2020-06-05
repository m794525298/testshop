package com.testshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.testshop.common.Coder;
import com.testshop.common.DataBaseConnector;
import com.testshop.pojo.CartBean;

public class CartDao {
	public static int admin_insert(CartBean cart) {
		//0:成功 1:數据庫錯誤  2:已存在收藏 3:不存在用户 4:不存在商品
		
		int res = 0;
		ResultSet rs = null;
		Statement st = null;
		PreparedStatement ps= null;
		
		try {
			st = DataBaseConnector.getStatement();
			rs = st.executeQuery("Select CART_ID from cart where CART_USER_ID='" + Coder.encrypted(cart.getUserId()) + "' and " +"CART_GOODS_ID=" + cart.getGoodsId());
			if (rs.next()) return 2;
			
			rs = st.executeQuery("Select count(*) from user where USER_MD5ID=" + cart.getUserId());
			if(!rs.next())
				return 3;
			
			rs = st.executeQuery("Select count(*) from goods where GOODS_ID=" + cart.getGoodsId() + " and GOODS_STATE=0");
			if(!rs.next())
				return 4;
			
			String sql = "insert into cart(CART_USER_ID, CART_GOODS_ID) value(?, ?)";
			ps = DataBaseConnector.getConnection().prepareStatement(sql);
			ps.setString(1, Coder.encrypted(cart.getUserId()));
			ps.setString(2, cart.getGoodsId());
			res = ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 1;
		} finally {
			try {
				if(st != null)
					st.close();
				if(ps != null)
					ps.close();
				if(rs != null)
					rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return (res > 0) ? 0 : 1;
	}
	
	public static int admin_update(CartBean cart) {
		//0:成功 1:數据庫錯誤 2:已存在关注 3:用户不存在 4:不存在商品
		
		int res = 0;
		int count = 0;
		ResultSet rs = null;
		Statement st = null;
		PreparedStatement ps= null;
		try {
			st = DataBaseConnector.getStatement();
			rs = st.executeQuery("Select CART_ID from cart where CART_USER_ID='" + Coder.encrypted(cart.getUserId()) + "' and " +"CART_GOODS_ID=" + cart.getGoodsId());
			if (rs.next()) return 2;
			
			rs = st.executeQuery("Select count(*) from user where USER_ID=" + cart.getUserId());
			if(!rs.next())
				return 3;
			
			rs = st.executeQuery("Select count(*) from goods where GOODS_ID=" + cart.getGoodsId() + " and GOODS_STATE=0");
			if(!rs.next())
				return 4;
			
			String sql = "update cart set CART_USER_ID=?, CART_GOODS_ID=? where CART_ID = ?";
			ps = DataBaseConnector.getConnection().prepareStatement(sql);
			ps.setString(1, Coder.encrypted(cart.getUserId()));
			ps.setString(2, cart.getGoodsId());
			ps.setString(3, cart.getId());
			
			res = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			return 1;
		} finally {
			try {
				if(st != null)
					st.close();
				if(ps != null)
					ps.close();
				if(rs != null)
					rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		return (res > 0) ? 0 : 1;
	}
	
	public static int admin_delete(String id) {
		//0:成功 1:數据庫錯誤 2:关注不存在
		
		int res = 0;
		PreparedStatement ps= null;
		
		try {
			String sql = "delete from cart where CART_ID=?";
			ps = DataBaseConnector.getConnection().prepareStatement(sql);
			ps.setString(1 , id);
			
			res = ps.executeUpdate();	
		} catch (SQLException e) {
			return 1;
		} finally {
			try {
				if(ps != null)
					ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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

		int res = 0;
		ResultSet rs = null;
		Statement st = null;
		PreparedStatement ps = null;

		try {
			if (keywords != null && !keywords.isEmpty()) {
				String sql = "select count(*) from cart where CART_USER_ID = ?";
				ps = DataBaseConnector.getConnection().prepareStatement(sql);
				ps.setString(1, Coder.encrypted(keywords));

			} else {
				String sql = "select count(*) from cart";
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
	 * 通过关键字查找某用户ID购物车列表
	 * @param cpage 当前页数
	 * @param count 显示个数
	 * @param keywords 搜索关键字
	 * @return 返回指定的购物车集
	 */
	public static ArrayList<CartBean> admin_selectAll(int cpage, int count, String keywords) {
		ArrayList<CartBean> list = new ArrayList<CartBean>();
		ResultSet rs = null;

		PreparedStatement ps = null;

		try {
			if (keywords != null && !keywords.isEmpty()) {
				String sql = "select * from cart where CART_USER_ID=? order by CART_ID asc limit ?, ?";
				ps = DataBaseConnector.getConnection().prepareStatement(sql);
				ps.setString(1, Coder.encrypted(keywords));
				ps.setInt(2, (cpage - 1) * count);
				ps.setInt(3, count);

			} else {
				String sql = "select * from cart order by CART_ID asc limit ?, ?";
				ps = DataBaseConnector.getConnection().prepareStatement(sql);
				ps.setInt(1, (cpage - 1) * count);
				ps.setInt(2, count);

			}

			rs = ps.executeQuery();

			while (rs.next()) {
				CartBean cart = new CartBean(
						rs.getString("CART_ID"),
						rs.getString("CART_USER_ID"),
						rs.getString("CART_GOODS_ID")
				);
				list.add(cart);
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
	 * 通过ID查找购物车
	 * @param id 指定ID
	 * @return 返回购物车实体
	 */
	public static CartBean admin_selectByID(String id) {
		CartBean cart = null;
		ResultSet rs = null;
		PreparedStatement ps = null;

		try {
			String sql = "select * from cart where CART_ID=?";
			
			ps = DataBaseConnector.getConnection().prepareStatement(sql);
			ps.setString(1, id);

			rs = ps.executeQuery();

			while (rs.next()) {
				cart = new CartBean(
						rs.getString("CART_ID"),
						rs.getString("CART_USER_ID"),
						rs.getString("CART_GOODS_ID")
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

		return cart;
	}
	
	public static boolean isCartExist(String userId, String goodsId) {
		
		int res = 0;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			String sql = "select count(*) from cart where CART_USER_ID=? and CART_GOODS_ID = ?";
			ps = DataBaseConnector.getConnection().prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, goodsId);

			rs = ps.executeQuery();

			if (rs.next()) {
				res = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
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
		
		return (res > 0) ? true : false;
	}
	
	public static int insertCart(String userId, String goodsId) {
		//0:成功 1:數据庫錯誤  2:已存在收藏 3:不存在用户 4:不存在商品
		
		int res = 0;
		ResultSet rs = null;
		Statement st = DataBaseConnector.getStatement();
		PreparedStatement ps= null;
		
		try {
			if (isCartExist(userId, goodsId)) return 2;
			
			rs = st.executeQuery("Select count(*) from user where USER_MD5ID='" + userId+"'");
			if(!rs.next())
				return 3;
			
			rs = st.executeQuery("Select count(*) from goods where GOODS_ID=" + goodsId + " and GOODS_STATE=0");
			if(!rs.next())
				return 4;
			
			String sql = "insert into cart(CART_USER_ID, CART_GOODS_ID) value(?, ?)";
			ps = DataBaseConnector.getConnection().prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, goodsId);
			res = ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 1;
		} finally {
			try {
				if(st != null)
					st.close();
				if(ps != null)
					ps.close();
				if(rs != null)
					rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return (res > 0) ? 0 : 1;
	}
	
	public static int deleteCart(String userId, String goodsId) {
		//0:成功 1:數据庫錯誤  2:不存在收藏
		
		int res = 0;
		ResultSet rs = null;
		Statement st = null;
		PreparedStatement ps= null;
		
		try {
			if (!isCartExist(userId, goodsId)) return 2;
			
			String sql = "delete from cart where CART_USER_ID=? and CART_GOODS_ID=?";
			ps = DataBaseConnector.getConnection().prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, goodsId);
			res = ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 1;
		} finally {
			try {
				if(st != null)
					st.close();
				if(ps != null)
					ps.close();
				if(rs != null)
					rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return (res > 0) ? 0 : 2;
	}
	
	public static int getUserCartNum(String userId) {
		int commentNum = 0;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		try {
			String sql = "select count(*) from cart where CART_USER_ID=?";
			pstmt = DataBaseConnector.getConnection().prepareStatement(sql);
			pstmt.setString(1,  userId);
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
	
	public static ResultSet getUserCart(String userId, String page, int count) {
		
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "select * from cart where CART_USER_ID=?  limit ?, ?";
			pstmt = DataBaseConnector.getConnection().prepareStatement(sql);
			pstmt.setInt(2, (Integer.valueOf(page) - 1) * count);
			pstmt.setInt(3, count);
			pstmt.setString(1, userId);
	
			rs = pstmt.executeQuery();
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return rs;
	}
}
