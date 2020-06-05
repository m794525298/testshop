package com.testshop.Interface;

import com.alibaba.fastjson.JSONObject;
import com.testshop.pojo.UserBean;

public interface Regsist {
	public boolean sendEmailCaptcha(String email);
	public JSONObject regsist(String username,String account,String password,String email);
}
