package com.testshop.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.testshop.common.ServletResponse;
import com.testshop.service.CartService;

/**
 * Servlet implementation class ShowUserCart
 */
@WebServlet("/ShowUserCart")
public class ShowUserCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map <String , String[]> map;
	private CartService service;
    public ShowUserCartController() {
        super();
        this.service = new CartService();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONObject json = new JSONObject();

		map =request.getParameterMap();
		if(!map.containsKey("userID") || map.get("userID")[0].equals("")) {
			json.put("totalPage","0");
			json.put("num","0");
			json.put("Goods", "[]");
			System.out.println("23-23-2-3223-2-32");
		} else {
			String page = (!map.containsKey("page") || map.get("page")[0].equals(""))? "1" : map.get("page")[0];
			String userId = map.get("userID")[0];
			
			json = service.getUserCart(userId, page);

		}
		ServletResponse.response(response, json);
	}
}
