package com.testshop.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.testshop.common.ServletResponse;
import com.testshop.pojo.GoodsBean;
import com.testshop.service.GoodsService;
import com.testshop.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GoodsDetail")
public class GoodsDetailController extends HttpServlet {
	
	 private GoodsService service;
    public GoodsDetailController() {
        super();
        this.service = new GoodsService();
    }
	    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String goodsId = req.getParameter("goodsID");
        JSONObject result = service.getGoodsDetail(goodsId);
        if (result!=null)
            ServletResponse.response(resp, result);
    }
}
