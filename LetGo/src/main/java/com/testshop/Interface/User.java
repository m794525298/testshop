package com.testshop.Interface;

import com.alibaba.fastjson.JSONObject;
import com.testshop.pojo.UserBean;

public interface User {
	public JSONObject checkAccount(String account);
	public JSONObject checkEmail(String email);
	public boolean updatedUserInfo(UserBean user);
	public boolean updatedPassword(String id, String oldPassword, String newPassword);
	public boolean updatedUserPasswordByEmail(String email, String newPassword);
	public JSONObject getUserInfo(String userID);
	public JSONObject getUserDetail(String userID);
	public boolean changeIcon(String userID,String img);
}
