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
import com.testshop.common.ServletResponse;
import com.testshop.service.RegsistService;


/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map<String, String[]> map;
	private RegsistService service;
 
    public SignUpController() {
        super();
        this.service = new RegsistService();
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
			json.put("success", "false");
		}else if (!map.containsKey("password") || map.get("password")[0].equals("")) {
			json.put("success", "false");
		}else if (!map.containsKey("email") || map.get("email")[0].equals("")) {
			json.put("success", "false");
		}else {
			String account = map.get("account")[0];
			String username = account;					// 默认username是account
			String password = map.get("password")[0];
			String email = map.get("email")[0];

			json = service.regsist(username, account, password, email);
		}

		ServletResponse.response(response, json);
	}
}
