package com.testshop.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.testshop.entity.TESTSHOP_USER;
import com.testshop.service.TESTSHOP_USERDao;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/signup")
public class SignUp extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		JSONObject json = new JSONObject();
		
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		String username = account;		// 默认username是account
		String icon = "default_icon";
		String identity = "2";			// 首次注册默认是买家

		TESTSHOP_USER user = new TESTSHOP_USER(null, username, account, password, icon, email, null, null, null, identity);
		
		PrintWriter out = response.getWriter();
		
		int count = TESTSHOP_USERDao.insert(user);

		if (count > 0)
			json.put("success", "true");
		else {
			json.put("success", "false");
		}
		
		out.println(json);
		out.flush();

		out.close();
	}
}
