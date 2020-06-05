package com.testshop.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.testshop.common.ServletResponse;
import com.testshop.dao.UserDao;
import com.testshop.service.UserService;

/**
 * Servlet implementation class checkemail
 */
@WebServlet("/CheckEmail")
public class CheckEmailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService service;
    public CheckEmailController() {
        super();
        this.service = new UserService();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		JSONObject json = new JSONObject();

		String email = request.getParameter("email");

		json = service.checkEmail(email);
		
		ServletResponse.response(response, json);
	}

}
