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
import com.testshop.pojo.CommentBean;
import com.testshop.service.CommentService;

/**
 * Servlet implementation class publishCommentController
 */
@WebServlet("/PublishComment")
public class PublishCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map <String , String[]> map;
	private CommentService service;
	
    public PublishCommentController() {
        super();
		this.service = new CommentService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONObject json = new JSONObject();
		
		map =request.getParameterMap();
		if (!map.containsKey("goodsID") || map.get("goodsID")[0].equals("")) {
			json.put("success", "false");
		}else if (!map.containsKey("content") || map.get("content")[0].equals("")) {
			json.put("success", "false");
		}else if (!map.containsKey("publisher") || map.get("publisher")[0].equals("")) {
			json.put("success", "false");
		}else{
			System.out.println("arr1");
			String goodsId = map.get("goodsID")[0];
			String content = map.get("content")[0];
			String parentId = !map.get("parentUserID")[0].equals("") ? map.get("parentUserID")[0] : null;
			String publisherId = map.get("publisher")[0];
			
			CommentBean comment = new CommentBean(null, null, parentId, content, goodsId, publisherId, null);

			json.put("success", String.valueOf(service.publishComment(comment)));
		}
		
		ServletResponse.response(response, json);
	}

}
