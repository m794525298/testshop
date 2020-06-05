package com.testshop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.testshop.common.ServletResponse;
import com.testshop.service.CommentService;

/**
 * Servlet implementation class getComments
 */
@WebServlet("/ShowGoodsComments")
public class ShowGoodsCommentsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map <String , String[]> map;
	private CommentService service;
    public ShowGoodsCommentsController() {
        super();
        this.service = new CommentService();
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
		if (!map.containsKey("goodsID") || map.get("goodsID")[0].equals("")) {
			json.put("totalPage","0");
			json.put("num","0");
			json.put("commentList", "[]");
		} else {
			String goodsId = map.get("goodsID")[0];
			String page = (!map.containsKey("page") || map.get("page")[0].equals(""))? "1" : map.get("page")[0];
	
			json = service.getGoodsComments(goodsId, page);
		}	
		ServletResponse.response(response, json);
	}

}
