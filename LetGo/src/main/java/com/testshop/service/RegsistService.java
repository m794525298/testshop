package com.testshop.service;

import java.io.IOException;
import java.util.Random;
import java.util.Vector;

import com.alibaba.fastjson.JSONObject;
import com.testshop.Interface.Regsist;
import com.testshop.common.EmailSender;
import com.testshop.dao.UserDao;

public class RegsistService implements Regsist{

    public RegsistService() {
    	super();
    }

    @Override
    public boolean sendEmailCaptcha(String email) {
    	// TODO Auto-generated method stub
    	Random rand = new Random();
		String captcha = String.valueOf(rand.nextInt(900000) + 100000);
		
    	int res = UserDao.saveEmailCaptcha(email, captcha);
    	if(res == 0) {
			try {
				EmailSender.send(email, captcha);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
    	} else {
			return false;
		}
    	
    	return true;
    }
    
    public boolean isCaptchaCorrect(String email, String captcha) {
    	// TODO Auto-generated method stub
    	Random rand = new Random();
		
    	Vector<String> res = UserDao.getCaptcha(email);
    	
    	if(res != null) {
    		int size = res.size();
			for(int i = 0; i < size; ++i)
				if(captcha.equals(res.get(i)))
					return true;
    	}
    	
    	return false;
    }

	@Override
	public JSONObject regsist(String username, String account, String password, String email) {
		JSONObject json = new JSONObject();
		int code = UserDao.regsist(username, account, password, email);

		if (code == 0) {
			json.put("success","true");
		}else {
			json.put("success","false");
		}
		
		return json;
	}
}
