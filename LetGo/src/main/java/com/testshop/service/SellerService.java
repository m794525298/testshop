package com.testshop.service;

import com.alibaba.fastjson.JSONObject;
import com.testshop.Interface.Seller;
import com.testshop.dao.UserDao;
import com.testshop.pojo.UserBean;

public class SellerService implements Seller {
	
	
    @Override
    public boolean isStuNumBind(String userID) {
        UserBean user = new UserBean();
        JSONObject json = new JSONObject();
        
        System.out.println("arr1");

        user = UserDao.selectByID(userID);
        if(user.getStuNum() == null || user.getStuNum().equals("")){
        	return false;
        }else {
            return true;
        }

    }
    
    @Override
	public JSONObject checkStuNum(String stuNum) {
    	JSONObject json = new JSONObject();
		json.put("exist", String.valueOf(UserDao.checkStuNum(stuNum)));	
		
		return json;
	}

    @Override
    public boolean bindStuNum(String userID,String stuNum,String address,String contact) {
        int result = UserDao.bindStuNum(userID,stuNum,address,contact);
        if(result == 0)return true;
        else return false;
    }
}
