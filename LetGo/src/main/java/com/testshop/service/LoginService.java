package com.testshop.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.alibaba.fastjson.JSONObject;
import com.testshop.dao.UserDao;
import com.testshop.Interface.Login;

public class LoginService implements Login{

	@Override
	public JSONObject login(String account, String password) {

		JSONObject json = new JSONObject();
		
		ResultSet rs = UserDao.signIn(account, password);
		try {
			if (rs != null && rs.next()) {
				json.put("match", "true");
				json.put("userID", rs.getString("USER_MD5ID"));
				json.put("icon",rs.getString("USER_ICON"));
				json.put("username",rs.getString("USER_NAME"));
				json.put("account", rs.getString("USER_ACCOUNT"));
				json.put("email", rs.getString("USER_EMAIL"));
				json.put("stuNum", rs.getString("USER_STUNUM"));
				json.put("address", rs.getString("USER_ADDRESS"));
				json.put("contact", rs.getString("USER_CONTACT"));
				json.put("identity",rs.getString("USER_IDENTITY"));
			} else {
				json.put("match", "false");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			json.put("match", "false");
		}
		
		return json;
	}
	
}
