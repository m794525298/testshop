package com.testshop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.testshop.common.ServletResponse;
import com.testshop.service.UserService;

/**
 * Servlet implementation class ForgetPasswordController
 */
@WebServlet("/ForgetPassword")
public class ForgetPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService service;
    public ForgetPasswordController() {
        super();
        this.service = new UserService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String newPassword = request.getParameter("newPassword");
		JSONObject json = new JSONObject();
		
		json.put("success", String.valueOf(service.updatedUserPasswordByEmail(email, newPassword)));
		
		ServletResponse.response(response, json);
	}

}
