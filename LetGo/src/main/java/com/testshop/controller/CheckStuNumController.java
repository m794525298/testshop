package com.testshop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.testshop.common.ServletResponse;
import com.testshop.service.SellerService;

/**
 * Servlet implementation class CheckStuNumController
 */
@WebServlet("/CheckStuNum")
public class CheckStuNumController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private SellerService service;

    public CheckStuNumController() {
        super();
        this.service = new SellerService();
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

		String stuNum = request.getParameter("stuNum");
		
		JSONObject json = service.checkStuNum(stuNum);
		
		ServletResponse.response(response, json);
	}

}
