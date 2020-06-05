package com.testshop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.testshop.common.ServletResponse;
import com.testshop.pojo.UserBean;
import com.testshop.service.UserService;

/**
 * Servlet implementation class UserNameController
 */
@WebServlet("/ChangeUserInfo")
public class ChangeUserInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService service;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeUserInfoController() {
        super();
        this.service = new UserService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject json = new JSONObject();
		
		String userMD5ID = request.getParameter("userID");
		String username = request.getParameter("username");
		String contact = request.getParameter("contact");
		String address = request.getParameter("address");
				
		UserBean user = new UserBean(null, username, null, null, null, null, null, address, contact, null, userMD5ID);
		
		json.put("success", String.valueOf(service.updatedUserInfo(user)));
				
		ServletResponse.response(response, json);
	}

}
