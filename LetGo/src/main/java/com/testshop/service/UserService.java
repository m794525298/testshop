package com.testshop.service;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.testshop.Interface.User;
import com.testshop.common.Coder;
import com.testshop.dao.UserDao;
import com.testshop.pojo.CommentBean;
import com.testshop.pojo.UserBean;

public class UserService implements User{

	@Override
	public JSONObject checkAccount(String account) {
		JSONObject json = new JSONObject();
		json.put("exist", String.valueOf(UserDao.checkAccount(account)));
		
		return json;
	}

	@Override
	public JSONObject checkEmail(String email) {
		JSONObject json = new JSONObject();
		json.put("exist", String.valueOf(UserDao.checkEmail(email)));
		
		return json;
	}
	
	@Override
	public boolean updatedUserInfo(UserBean user) {
		int code = UserDao.updatedUserInfo(user);

		return (code == 0)? true : false;
	}
	
	@Override
	public boolean updatedPassword(String userId, String oldPassword, String newPassword) {
		if (UserDao.updatedPassword(userId, oldPassword, newPassword) == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public boolean updatedUserPasswordByEmail(String email, String newPassword) {
		if (UserDao.updatedUserPasswordByEmail(email, newPassword) == 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public JSONObject getUserInfo(String userID) {
		JSONObject json = new JSONObject();
		UserBean user = UserDao.selectByID(userID);
		if(user != null) {
			json.put("userID", user.getMD5ID());
			json.put("icon", user.getIcon());
			json.put("stuNum", user.getStuNum());
			json.put("username", user.getUsername());
			json.put("address", user.getAddress());
		}else
			return null;
		return json;
	}

	@Override
	public JSONObject getUserDetail(String userID) {
		JSONObject json = new JSONObject();
		UserBean user = UserDao.selectByID(userID);
		if(user != null) {
			json.put("userID", user.getId());
			json.put("icon", user.getIcon());
			json.put("account",user.getAccount());
			json.put("username", user.getUsername());
			json.put("identity",user.getIdentity());
			json.put("email",user.getEmail());
			json.put("stuNum", user.getStuNum());
			json.put("address", user.getAddress());
			json.put("contact",user.getContact());
		}else
			return null;
		return json;
	}

	@Override
	public boolean changeIcon(String userID, String img) {
		boolean res = UserDao.changeIcon(userID,img);
		return res;
	}
}
