package com.testshop.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.testshop.service.TESTSHOP_USERDao;

/**
 * Servlet implementation class checkemail
 */
@WebServlet("/checkemail")
public class CheckEmail extends HttpServlet {
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

		String email = request.getParameter("email");

		PrintWriter out = response.getWriter();

		int count = TESTSHOP_USERDao.selectByEmail(email);
		if (count > 0)
			json.put("exist", "true");
		else {
			json.put("exist", "false");
		}
		
		out.println(json);
		out.flush();

		out.close();
	}

}
