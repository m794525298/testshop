
package com.testshop.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.alibaba.fastjson.JSONObject;
import com.testshop.service.UserService;
import com.testshop.common.ServletResponse;
import com.testshop.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class checkUsername
 */
@WebServlet("/CheckAccount")
public class CheckAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService service;
    public CheckAccountController() {
        super();
        this.service = new UserService();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		String account = request.getParameter("account");
		
		JSONObject json = service.checkAccount(account);
		
		ServletResponse.response(response, json);
	}
}
