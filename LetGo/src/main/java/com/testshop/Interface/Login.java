package com.testshop.Interface;

import com.alibaba.fastjson.JSONObject;

public interface Login {
	public JSONObject login(String account, String password);
}
