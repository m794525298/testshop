package com.testshop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.testshop.service.LoginService;
import com.testshop.common.ServletResponse;
import com.testshop.dao.UserDao;
import com.testshop.pojo.UserBean;

/**
 * Servlet implementation class SignIn
 */
@WebServlet("/Login")
public class LoginController extends HttpServlet {
    private LoginService service;
    Map <String , String[]> map;
    public LoginController() {
        super();
        this.service = new LoginService();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	doPost(request, response);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		JSONObject json = new JSONObject();
		
		map = request.getParameterMap();
		if (!map.containsKey("account") || map.get("account")[0].equals("")) {
			json.put("match", "false");
		} else if (!map.containsKey("password") || map.get("password")[0].equals("")) {
			json.put("match", "false");
		} else {
			String account = map.get("account")[0];
			String password = map.get("password")[0];

			json = service.login(account, password);
		}
				
		ServletResponse.response(response, json);
		
		System.out.println(json.toJSONString());
	}

}
