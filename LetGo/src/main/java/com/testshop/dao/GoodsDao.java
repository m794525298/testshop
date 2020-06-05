package com.testshop.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.testshop.common.Coder;
import com.testshop.common.DataBaseConnector;
import com.testshop.common.ImageUtils;
import com.testshop.pojo.GoodsBean;

public class GoodsDao {
	
	public static int admin_insert(GoodsBean goods) {
		//0:成功 1:數据庫錯誤 2:用户不存在
		int res = 0;
		ResultSet rs =null;
		PreparedStatement ps= null;
		
		try {
			Statement st = DataBaseConnector.getStatement();
			ResultSet rs2 = st.executeQuery("select count(*) from user where USER_MD5ID='" + goods.getPublisherId() + "'");
			if(!rs2.next())
				return 2;
			
			String sql = "insert into goods value(?,?,?,?,?,?,?,?,?,?,?)";
			
			ps = DataBaseConnector.getPreparedStatement(sql);
			ps.setString(1, null);
			ps.setString(2, goods.getType());
			ps.setString(3, goods.getDesc());
			ps.setString(4, goods.getTitle());
			ps.setString(5, goods.getState());
			ps.setString(6, goods.getPrice());
			ps.setString(7, goods.getCount());
			ps.setString(8, goods.getAddress());
			ps.setString(9, goods.getContact());
			ps.setString(10, Coder.encrypted(goods.getPublisherId()));
			ps.setInt(11, 0);
	
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
		
		return (res > 0) ? 0 : 1 ;
	}
	
	public static int admin_update(GoodsBean goods) {
		//0:成功 1:數据庫錯誤 2:商品不存在
		
		int res = 0;
		PreparedStatement ps= null;
		
		try {
			String sql = "update goods set GOODS_TYPE=?, GOODS_DESC=?, GOODS_TITLE=?, GOODS_STATE=?, GOODS_PRICE=?, "
					+ "GOODS_COUNT=?, GOODS_ADDRESS=?, GOODS_CONTACT=?, GOODS_PUBLISHER=? where GOODS_ID=?";
			ps = DataBaseConnector.getPreparedStatement(sql);

			ps.setString(1, goods.getType());
			ps.setString(2, goods.getDesc());
			ps.setString(3, goods.getTitle());
			ps.setString(4, goods.getState());
			ps.setString(5, goods.getPrice());
			ps.setString(6, goods.getCount());
			ps.setString(7, goods.getAddress());			
			ps.setString(8, goods.getContact());			
			ps.setString(9, Coder.encrypted(goods.getPublisherId()));
			ps.setString(10, goods.getId());
			
			res = ps.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
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
	
	public static int admin_delete(String id) {
		//0:成功 1:數据庫錯誤 2:商品不存在
		
				int res = 0;
				PreparedStatement ps= null;
				
				try {
					String sql = "update goods set GOODS_STATE=1 where GOODS_ID=? and GOODS_STATE=0";
					ps = DataBaseConnector.getPreparedStatement(sql);
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

		ResultSet rs = null;
		PreparedStatement ps = null;

		try {
			if (keywords != null) {
				String sql = "select count(*) from goods where GOODS_TITLE like ?";
				ps = DataBaseConnector.getPreparedStatement(sql);
				ps.setString(1, "%" + keywords + "%");

			} else {
				String sql = "select count(*) from goods";
				ps = DataBaseConnector.getPreparedStatement(sql);
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	public static ArrayList<GoodsBean> admin_selectAll(int cpage, int count, String keywords) {
		ArrayList<GoodsBean> list = new ArrayList<GoodsBean>();
		
		ResultSet rs = null;
		PreparedStatement ps = null;

		try {
			if (keywords != null) {
				String sql = "select * from goods where GOODS_TITLE like ? order by GOODS_ID asc limit ?, ?";
				ps = DataBaseConnector.getPreparedStatement(sql);
				ps.setString(1, "%" + keywords + "%");
				ps.setInt(2, (cpage - 1) * count);
				ps.setInt(3, count);

			} else {
				String sql = "select * from goods order by GOODS_ID asc limit ?, ?";
				ps = DataBaseConnector.getPreparedStatement(sql);
				ps.setInt(1, (cpage - 1) * count);
				ps.setInt(2, count);

			}

			rs = ps.executeQuery();

			while (rs.next()) {
				GoodsBean goods = new GoodsBean(
						rs.getString("GOODS_ID"),
						rs.getString("GOODS_TYPE"),
						rs.getString("GOODS_DESC"),
						rs.getString("GOODS_TITLE"),
						rs.getString("GOODS_STATE"),
						rs.getString("GOODS_PRICE"),
						rs.getString("GOODS_COUNT"),
						rs.getString("GOODS_ADDRESS"),
						rs.getString("GOODS_CONTACT"),
						rs.getString("GOODS_PUBLISHER"),
						rs.getString("GOODS_IMG_COUNT")
				);
				list.add(goods);
			}
		} catch (Exception e) {
			e.printStackTrace();
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

		return list;
	}
	
	/**
	 * 通过ID查找商品
	 * @param id 指定ID
	 * @return 返回商品实体
	 */
	public static GoodsBean admin_selectByID(String id) {

		ResultSet rs = null;
		GoodsBean goods = null;
		PreparedStatement ps = null;

		try {
			String sql = "select * from goods where GOODS_ID=?";
			
			ps = DataBaseConnector.getPreparedStatement(sql);
			ps.setString(1, id);

			rs = ps.executeQuery();

			while (rs.next()) {
				goods = new GoodsBean(
						rs.getString("GOODS_ID"),
						rs.getString("GOODS_TYPE"),
						rs.getString("GOODS_DESC"),
						rs.getString("GOODS_TITLE"),
						rs.getString("GOODS_STATE"),
						rs.getString("GOODS_PRICE"),
						rs.getString("GOODS_COUNT"),
						rs.getString("GOODS_ADDRESS"),
						rs.getString("GOODS_CONTACT"),
						rs.getString("GOODS_PUBLISHER"),
						rs.getString("GOODS_IMG_COUNT")
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return goods;
	}
	
	public static Map<String,String> getDetailsByGoodsId(String goodsId){
        String sql ="select * from goods , user where GOODS_PUBLISHER = USER_MD5ID and GOODS_ID = ?";
        PreparedStatement ps = DataBaseConnector.getPreparedStatement(sql);
        try {
            ps.setString(1, goodsId);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return DataBaseConnector.getResultMap(rs);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
	public static int insertGoods(GoodsBean goods) {
       // -1:數据庫錯誤
        int res = -1;
        ResultSet rs =null;
        PreparedStatement ps= null;

        try {
            Statement st = DataBaseConnector.getStatement();
            ResultSet rs2 = st.executeQuery("select count(*) from user where USER_MD5ID='" + goods.getPublisherId() + "'");
            if(!rs2.next())
                return -1;

            String sql = "insert into goods value(?,?,?,?,?,?,?,?,?,?,?)";

            ps = DataBaseConnector.getConnection().prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, null);
            ps.setString(2, goods.getType());
            ps.setString(3, goods.getDesc());
            ps.setString(4, goods.getTitle());
            ps.setString(5, goods.getState());
            ps.setString(6, goods.getPrice());
            ps.setString(7, goods.getCount());
            ps.setString(8, goods.getAddress());
            ps.setString(9, goods.getContact());
            ps.setString(10, goods.getPublisherId());
            ps.setInt(11, Integer.parseInt(goods.getImageCount()));

            res = ps.executeUpdate();
            if (res>0){
                rs = ps.getGeneratedKeys();
                if (rs.next()){
                    res = rs.getInt(1);
                }else {
                    res =-1;
                }
            }

        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
            return -1;
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
        return res;

    }
	
	public static int updateGoods(GoodsBean goods) {
		//0:成功 1:數据庫錯誤 2:商品不存在
		
		int res = 0;
		PreparedStatement ps= null;
		
		try {
			String sql = "update goods set GOODS_TYPE=?, GOODS_DESC=?, GOODS_TITLE=?, GOODS_STATE=?, GOODS_PRICE=?, "
					+ "GOODS_COUNT=?, GOODS_ADDRESS=?, GOODS_CONTACT=?, GOODS_PUBLISHER=? where GOODS_ID=?";
			ps = DataBaseConnector.getPreparedStatement(sql);

			ps.setString(1, goods.getType());
			ps.setString(2, goods.getDesc());
			ps.setString(3, goods.getTitle());
			ps.setString(4, goods.getState());
			ps.setString(5, goods.getPrice());
			ps.setString(6, goods.getCount());
			ps.setString(7, goods.getAddress());			
			ps.setString(8, goods.getContact());			
			ps.setString(9, goods.getPublisherId());
			ps.setString(10, goods.getId());
			
			res = ps.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
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
	 *
	 * @param type 1：学习资料 2：生活用品 3：小食分享 4：电子器械 5：二次元区 6：其他
	 * @param num 查询的数量
	 * @return
	 */
   public static List<Map<String,String>> getGoodsByTypeAndNum(String type,int num){
		String sql = "select GOODS_ID, GOODS_TITLE, GOODS_PRICE from goods where GOODS_STATE = 0 AND GOODS_TYPE = ? limit 0,?";
		PreparedStatement ps = DataBaseConnector.getPreparedStatement(sql);
		List<Map<String,String>> result = new ArrayList<>();
		try {
			ps.setString(1, type);
			ps.setInt(2, num);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				Map<String,String> data = new HashMap<>();
				String goodsId = rs.getString("GOODS_ID");
				data.put("goodsID",goodsId);
				data.put("title",rs.getString("GOODS_TITLE"));
				data.put("price",rs.getString("GOODS_PRICE"));
				data.put("cover",ImageUtils.getImagePaths(goodsId,1).get(0));
				result.add(data);
			}
		}catch (Exception e){
			System.out.println(e.getMessage());
			return null;
		}
		return result;
	}
	public static int getGoodsNum(String userId) {
		int commentNum = 0;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		try {
			String sql = "select count(*) from goods where GOODS_PUBLISHER=?";
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
	public static ResultSet getGoodsList(String userId,String page){
   	String sql = "select * from goods where GOODS_PUBLISHER = ? limit ? , ?";
   	int rp = Integer.parseInt(page);
   	int baseCount = 20;
   	try {
			PreparedStatement ps = DataBaseConnector.getPreparedStatement(sql);
			ps.setString(1, userId);
			ps.setInt(2, 20 * (rp - 1));
			ps.setInt(3, 20 * rp - 1);
			ResultSet rs = ps.executeQuery();
			return rs;
		}catch (Exception e){
   		System.out.println(e.getMessage());
		}
   	return null;
	}
	public static boolean modifyGoodsState(String goodsId,String userId,String state){
		
		String sql = "update goods set GOODS_STATE = ? where GOODS_PUBLISHER = ? AND GOODS_ID = ?";
		PreparedStatement ps = DataBaseConnector.getPreparedStatement(sql);
		try {

   		ps.setString(1, state);
			ps.setString(2, userId);
			ps.setString(3, goodsId);
			int changeCount = ps.executeUpdate();
			return changeCount > 0;
		}catch (Exception e){
   		System.out.println(e.getMessage());
   		return false;
		}
	}
	
	public static int getSearchGoodsNum(int page, int count, String keywords, String type) {

		int goodsNum = 0;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		try {
			
			if (keywords == null)
				keywords = "";
			
			
			if(type != null) {
				String sql = "select count(*) from goods where GOODS_TITLE like ? AND GOODS_TYPE = ? order by GOODS_ID";
				ps = DataBaseConnector.getPreparedStatement(sql);
				ps.setString(1, "%" + keywords + "%");
				ps.setString(2, type);
			} else {
				String sql = "select count(*) from goods where GOODS_TITLE like ? order by GOODS_ID";
				ps = DataBaseConnector.getPreparedStatement(sql);
				ps.setString(1, "%" + keywords + "%");
			}
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				goodsNum = rs.getInt(1);
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

		return goodsNum;
	}
	
	public static List<Map<String,String>> searchGoods(int page, int count, String keywords, String type) {
		ArrayList<GoodsBean> list = new ArrayList<GoodsBean>();
		List<Map<String,String>> result = new ArrayList<>();
		ResultSet rs = null;
		PreparedStatement ps = null;
		if (keywords == null)
			keywords = "";
				
		try {
			if(type != null) {
				String sql = "select GOODS_ID, GOODS_TITLE, GOODS_PRICE from goods where GOODS_TITLE like ? AND GOODS_TYPE = ? order by GOODS_ID asc limit ?, ?";
				ps = DataBaseConnector.getPreparedStatement(sql);
				ps.setString(1, "%" + keywords + "%");
				ps.setString(2, type);
				ps.setInt(3, (page - 1) * count);
				ps.setInt(4, count);
			} else {
				System.out.println("arr2");
				String sql = "select GOODS_ID, GOODS_TITLE, GOODS_PRICE from goods where GOODS_TITLE like ? order by GOODS_ID asc limit ?, ?";
				ps = DataBaseConnector.getPreparedStatement(sql);
				ps.setString(1, "%" + keywords + "%");
				ps.setInt(2, (page - 1) * count);
				ps.setInt(3, count);
			}

			rs = ps.executeQuery();
			while (rs.next()){
				Map<String,String> data = new HashMap<>();
				String goodsId = rs.getString("GOODS_ID");
				data.put("goodsID",goodsId);
				data.put("title",rs.getString("GOODS_TITLE"));
				data.put("price",rs.getString("GOODS_PRICE"));
				data.put("cover", ImageUtils.getImagePaths(goodsId,1).get(0));
				result.add(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
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
		return result;
	}
}
