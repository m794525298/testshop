package com.testshop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.testshop.common.EmailSender;

/**
 * Servlet implementation class GetEmailCaptcha
 */
@WebServlet("/getemailcaptcha")
public class GetEmailCaptcha extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		JSONObject json = new JSONObject();
		String email = request.getParameter("email");

		Random rand = new Random();
		String captcha = String.valueOf(rand.nextInt(900000) + 100000);
		
		PrintWriter out = response.getWriter();

		EmailSender.send(email, captcha);

		json.put("captcha", captcha);

		out.println(json);
		out.flush();

		out.close();
	}
}
