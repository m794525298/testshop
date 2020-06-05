package com.testshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import com.alibaba.fastjson.JSONObject;
import com.testshop.common.Coder;
import com.testshop.common.DataBaseConnector;
import com.testshop.common.ImageUtils;
import com.testshop.controller.SendEmailCaptchaController;
import com.testshop.pojo.UserBean;

public class UserDao {
	
	public static int admin_insert(UserBean user) {
		//0:成功 1:數据庫錯誤 2:已存在用戶
		
		int res = 0;
		ResultSet rs =null;
		PreparedStatement ps= null;
		
		try {
			Statement st = DataBaseConnector.getStatement();
			rs = st.executeQuery("Select USER_ID from user where USER_ACCOUNT='" + user.getAccount() + "' or " +"USER_EMAIL='" + user.getEmail() + "'");
			if (rs.next()) return 2;
			
			String sql = "insert into user(USER_NAME, USER_ACCOUNT, USER_PASSWORD, "
					+ "USER_ICON, USER_EMAIL, USER_STUNUM, USER_ADDRESS, USER_CONTACT, USER_IDENTITY) value(?,?,?,?,?,?,?,?,?)";
			
			ps = DataBaseConnector.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getAccount());
			ps.setString(3, Coder.encrypted(user.getPassword()));
			ps.setString(4, user.getIcon());
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getStuNum());
			ps.setString(7, user.getAddress());
			ps.setString(8, user.getContact());
			ps.setString(9, user.getIdentity());
			
			res = ps.executeUpdate();
			
			rs = ps.getGeneratedKeys();
			
			if (res > 0 && rs.next()) {
				sql="update user set USER_MD5ID='"+ Coder.encrypted(rs.getString(1)) + "' where USER_ID=" + rs.getString(1);	//sql语句
				res = st.executeUpdate(sql);
			}
			
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
	
	public static int admin_update(UserBean user) {
		//0:成功 1:數据庫錯誤 2:用户不存在
		
		int res = 0;
		PreparedStatement ps= null;
		
		try {
			String sql = "update user set USER_NAME=?, USER_ACCOUNT=?, USER_PASSWORD=?, USER_ICON=?, USER_EMAIL=?, "
					+ "USER_STUNUM = ?, USER_ADDRESS = ?, USER_CONTACT = ?, USER_IDENTITY=? where USER_ID=?";
			ps = DataBaseConnector.getPreparedStatement(sql);

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getAccount());
			ps.setString(3, Coder.encrypted(user.getPassword()));
			ps.setString(4, user.getIcon());
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getStuNum());
			ps.setString(7, user.getAddress());
			ps.setString(8, user.getContact());
			ps.setString(9, user.getIdentity());
			ps.setString(10, user.getId());
			
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
	
	public static int admin_delete(String id) {
		//0:成功 1:數据庫錯誤 2:用户不存在
		
		int res = 0;
		PreparedStatement ps= null;
		
		try {
			String sql = "delete from user where USER_ID=?";
			ps = DataBaseConnector.getPreparedStatement(sql);
			ps.setString(1 , id);
			
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
				String sql = "select count(*) from user where USER_NAME like ?";
				ps = DataBaseConnector.getPreparedStatement(sql);
				ps.setString(1, "%" + keywords + "%");
			} else {
				String sql = "select count(*) from user";
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
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
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
	public static ArrayList<UserBean> admin_selectAll(int cpage, int count, String keywords) {
		ArrayList<UserBean> list = new ArrayList<UserBean>();
		
		ResultSet rs = null;
		PreparedStatement ps = null;

		try {
			if (keywords != null) {
				String sql = "select * from user where USER_NAME like ? order by USER_ID asc limit ?, ?";
				ps = DataBaseConnector.getPreparedStatement(sql);
				ps.setString(1, "%" + keywords + "%");
				ps.setInt(2, (cpage - 1) * count);
				ps.setInt(3, count);

			} else {
				String sql = "select * from user order by USER_ID asc limit ?, ?";
				ps = DataBaseConnector.getPreparedStatement(sql);
				ps.setInt(1, (cpage - 1) * count);
				ps.setInt(2, count);
			}

			rs = ps.executeQuery();

			while (rs.next()) {
				UserBean user = new UserBean(
						rs.getString("USER_ID"),
						rs.getString("USER_NAME"),
						rs.getString("USER_ACCOUNT"),
						rs.getString("USER_PASSWORD"),
						rs.getString("USER_ICON"),
						rs.getString("USER_EMAIL"),
						rs.getString("USER_STUNUM"),
						rs.getString("USER_ADDRESS"),
						rs.getString("USER_CONTACT"),
						rs.getString("USER_IDENTITY"),
						rs.getString("USER_MD5ID")
				);
				list.add(user);
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
	 * 通过ID查找用户
	 * @param id 指定ID
	 * @return 返回用户实体
	 */
	public static UserBean admin_selectByID(String id) {

		ResultSet rs = null;
		UserBean user = null;
		PreparedStatement ps = null;
		
		try {
			String sql = "select * from user where USER_ID=?";
			ps = DataBaseConnector.getPreparedStatement(sql);
			ps.setString(1, id);

			rs = ps.executeQuery();

			while (rs.next()) {
				user = new UserBean(
						rs.getString("USER_ID"),
						rs.getString("USER_NAME"),
						rs.getString("USER_ACCOUNT"),
						rs.getString("USER_PASSWORD"),
						rs.getString("USER_ICON"),
						rs.getString("USER_EMAIL"),
						rs.getString("USER_STUNUM"),
						rs.getString("USER_ADDRESS"),
						rs.getString("USER_CONTACT"),
						rs.getString("USER_IDENTITY"),
						rs.getString("USER_MD5ID")
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

		return user;
	}
	
	public static UserBean admin_signIn(String account, String password) {
		
		ResultSet rs = null;
		UserBean user = null;
		PreparedStatement ps = null;
		try {
			String sql = "select * from user where USER_ACCOUNT=? and USER_PASSWORD=?";
			ps = DataBaseConnector.getPreparedStatement(sql);
			ps.setString(1, account);
			ps.setString(2, Coder.encrypted(password));
			rs = ps.executeQuery();
			
			
			if(rs.next()) {
				user = new UserBean(
						rs.getString("USER_ID"),
						rs.getString("USER_NAME"),
						rs.getString("USER_ACCOUNT"),
						rs.getString("USER_PASSWORD"),
						rs.getString("USER_ICON"),
						rs.getString("USER_EMAIL"),
						rs.getString("USER_STUNUM"),
						rs.getString("USER_ADDRESS"),
						rs.getString("USER_CONTACT"),
						rs.getString("USER_IDENTITY"),
						rs.getString("USER_MD5ID")
				);
			}
				
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return user;
	}
	
	public static UserBean selectByID(String id) 
	{

		ResultSet rs = null;
		UserBean user = null;
		PreparedStatement ps = null;
		
		try {
			String sql = "select * from user where USER_MD5ID=?";
			ps = DataBaseConnector.getPreparedStatement(sql);
			ps.setString(1, id);

			rs = ps.executeQuery();

			while (rs.next()) {
				user = new UserBean(
						rs.getString("USER_ID"),
						rs.getString("USER_NAME"),
						rs.getString("USER_ACCOUNT"),
						rs.getString("USER_PASSWORD"),
						rs.getString("USER_ICON"),
						rs.getString("USER_EMAIL"),
						rs.getString("USER_STUNUM"),
						rs.getString("USER_ADDRESS"),
						rs.getString("USER_CONTACT"),
						rs.getString("USER_IDENTITY"),
						rs.getString("USER_MD5ID")
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

		return user;
	}


	public static boolean checkAccount(String account) {
		
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			String sql = "Select USER_MD5ID from user where USER_ACCOUNT = ?";
			
			ps = DataBaseConnector.getPreparedStatement(sql);
			ps.setString(1, account);
			
			rs = ps.executeQuery();
			
			if (!rs.next()) return false;
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean checkEmail(String email) {
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			String sql = "Select USER_MD5ID from user where USER_EMAIL = ?";
			
			ps = DataBaseConnector.getPreparedStatement(sql);
			ps.setString(1, email);
			
			rs = ps.executeQuery();
			
			if (!rs.next()) return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public static int saveEmailCaptcha(String email, String captcha) {
		//0:成功	1:数据库错误
		
		int res = 0;
		PreparedStatement ps= null;
		try {
			String sql = "insert captcha(CAPTCHA_EMAIL, CAPTCHA_CAPTCHA) value(?, ?)";
			ps = DataBaseConnector.getConnection().prepareStatement(sql);

			ps.setString(1, email);
			ps.setString(2, captcha);
			
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
		
		return (res > 0) ? 0 : 1;
	}
	
	public static Vector<String> getCaptcha(String email) {
		//0:成功	1:数据库错误
		
		Vector<String> res = new Vector<String>();
		ResultSet rs = null;
		PreparedStatement ps= null;
		try {
			String sql = "select CAPTCHA_CAPTCHA from captcha where CAPTCHA_EMAIL=?";
			ps = DataBaseConnector.getConnection().prepareStatement(sql);

			ps.setString(1, email);
			
			rs = ps.executeQuery();
			
			for (int i = 0; rs.next(); ++i) {
				res.add(rs.getString(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
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

	public static int regsist(String account, String username, String password, String email) {
		// 0:成功, 1:数据库错误, 2:账号已存在 3:email已存在
		
		int res = 0;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			if(checkAccount(account))
				return 2;
			if(checkEmail(email))
				return 3;
			
			String sql="insert into user(USER_NAME, USER_ACCOUNT,USER_PASSWORD,USER_EMAIL) values(?,?,?,?) ";//sql语句

			ps= DataBaseConnector.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, username);
			ps.setString(2 , account);
			ps.setString(3 , Coder.encrypted(password));
			ps.setString(4 , email);
			res = ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			
			if (res > 0 && rs.next()) {
				Statement st = DataBaseConnector.getStatement();
				sql="update user set USER_MD5ID='"+ Coder.encrypted(rs.getString(1)) + "' where USER_ID=" + rs.getString(1);
				res = st.executeUpdate(sql);
				st.close();
			}
			
		} catch (SQLException e) {
			System.out.println(e);
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
		
		return (res > 0)? 0 : 1 ;
	}
	
	public static ResultSet signIn(String account, String password) {
		
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			String sql = "select * from user where USER_ACCOUNT=? and USER_PASSWORD=?";
			ps = DataBaseConnector.getPreparedStatement(sql);
			ps.setString(1, account);
			ps.setString(2, Coder.encrypted(password));
			rs = ps.executeQuery();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public static String getUsername(String userId) {
		//0:成功 1:數据庫錯誤
		
		String username = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			String sql="select USER_NAME from user where USER_MD5ID = ?";
			ps = DataBaseConnector.getPreparedStatement(sql);
			ps.setString(1, userId);
			rs = ps.executeQuery();
			if(rs.next())
				username = rs.getString("USER_NAME");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null)
					ps.close();
				if(rs != null)
					rs.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		return username;
	}
	
	public static int updatedUserInfo(UserBean user) {
		//0:成功 1:數据庫錯誤
		
		int res = 0;
		PreparedStatement ps = null;
		try {
			String sql="update user set USER_NAME = ?, USER_ADDRESS = ?, USER_CONTACT = ? where USER_MD5ID = ?";
			ps = DataBaseConnector.getPreparedStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getAddress());
			ps.setString(3, user.getContact());
			ps.setString(4, user.getMD5ID());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 1;
		} finally {
			try {
				if(ps != null)
					ps.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		return (res > 0) ? 0 : 1;
	}
	
	public static int updatedPassword(String userId, String oldPassword, String newPassword) {
		//0:成功 1:數据庫錯誤 2:账密不匹配
		
		int res = 0;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			String sql= "Select USER_ID from user where USER_MD5ID = ? And USER_PASSWORD = ?";
			ps = DataBaseConnector.getPreparedStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, Coder.encrypted(oldPassword));
			rs = ps.executeQuery();
			if (!rs.next())
				return 2;
			
			sql="update user set USER_PASSWORD = ? where USER_MD5ID = ?";
			ps = DataBaseConnector.getPreparedStatement(sql);
			ps.setString(1, Coder.encrypted(newPassword));
			ps.setString(2, userId);
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			return 1;
		} finally {
			try {
				if(ps != null)
					ps.close();
				if(rs != null)
					rs.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		return (res > 0) ? 0 : 1;
	}
	
	public static int updatedUserPasswordByEmail(String email,String newPassword) {
		//0:成功 1:數据庫錯誤 2:email不存在
		int res = 0;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			if (!checkEmail(email))
				return 2;
			
			String sql="update user set USER_PASSWORD = ? where USER_Email = ?";
			ps = DataBaseConnector.getPreparedStatement(sql);
			ps.setString(1, Coder.encrypted(newPassword));
			ps.setString(2, email);
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 1;
		} finally {
			try {
				if(ps != null)
					ps.close();
				if(rs != null)
					rs.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}				
		}
		
		return res > 0 ? 0 : 2;
	}
	
	public static boolean checkStuNum(String stuNum) {

		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			String sql = "Select USER_MD5ID from user where USER_STUNUM = ?";

			ps = DataBaseConnector.getPreparedStatement(sql);
			ps.setString(1, stuNum);

			rs = ps.executeQuery();

			if (!rs.next()) return false;
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static int bindStuNum(String userID, String stuNum, String address, String contact) {
		// 0:成功, 1:数据库错误, 2:学号已存在

		int res = 0;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			if(checkStuNum(stuNum))
				return 2;

			String sql = "update user set USER_STUNUM=?, USER_ADDRESS=?, USER_CONTACT=?, USER_IDENTITY=1 where USER_MD5ID=?";
			ps = DataBaseConnector.getPreparedStatement(sql);

			ps.setString(1, stuNum);
			ps.setString(2, address);
			ps.setString(3, contact);
			ps.setString(4, userID);

			res = ps.executeUpdate();		
				
		} catch (SQLException e) {
			System.out.println(e);
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

		return (res > 0)? 0 : 1 ;
	}

	public static boolean changeIcon(String userID,String img) {

		int res = 0;
		PreparedStatement ps = null;

		String icon = ImageUtils.saveIcon(Coder.encrypted(userID),img);
		try {
			String sql = "update user set USER_ICON=? where USER_MD5ID=?";
			ps = DataBaseConnector.getPreparedStatement(sql);
			ps.setString(1, icon);
			ps.setString(2, userID);
			res = ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public static boolean isSeller(String userId) {
		
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		try {
			String sql = "select USER_ID from user where USER_MD5ID=? and USER_IDENTITY=1";
			ps = DataBaseConnector.getPreparedStatement(sql);
			ps.setString(1, userId);
			rs = ps.executeQuery();
			
			if(rs.next())
				return true;
				
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return false;
	}
}