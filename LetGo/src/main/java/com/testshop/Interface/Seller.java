package com.testshop.Interface;

import com.alibaba.fastjson.JSONObject;

public interface Seller {
	public boolean isStuNumBind(String userID);
	public JSONObject checkStuNum(String stuNum);
    public boolean bindStuNum(String userID, String stuNum,String address,String contact);
}
