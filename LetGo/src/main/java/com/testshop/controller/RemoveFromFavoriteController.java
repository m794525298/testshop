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
 * Servlet implementation class RemoveFromCartController
 */
@WebServlet("/RemoveFromFavorite")
public class RemoveFromFavoriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CartService service;
    Map <String , String[]> map;  
    
    public RemoveFromFavoriteController() {
        super();
        this.service = new CartService();
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
		JSONObject json = new JSONObject();
				
		map = request.getParameterMap();
		if (!map.containsKey("userID") || map.get("userID")[0].equals("")) {
			json.put("success", "false");
		} else if (!map.containsKey("goodsID") || map.get("goodsID")[0].equals("")) {
			json.put("success", "false");
		} else {
			String userId = map.get("userID")[0];
			String goodsId = map.get("goodsID")[0];
			
			json = service.removeFromFavorite(userId, goodsId);
		}
		
		ServletResponse.response(response, json);
	}
}
