package com.testshop.controller;

import com.alibaba.fastjson.JSONObject;
import com.testshop.common.ServletResponse;
import com.testshop.service.CommentService;
import com.testshop.service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/PublishGoods")
public class PublishGoodsController extends HttpServlet {
	
	private GoodsService service;
    public PublishGoodsController() {
        super();
        this.service = new GoodsService();
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,String[]> data = req.getParameterMap();
        boolean result = service.saveGoods(data);
        JSONObject object = new JSONObject();
        object.put("success",String.valueOf(result));
        ServletResponse.response(resp,object);
    }
}
