package com.testshop.controller;

import com.alibaba.fastjson.JSONObject;
import com.testshop.service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;

@WebServlet("/SearchGoods")
public class SearchGoodsController extends HttpServlet {

    private GoodsService service;
    public SearchGoodsController() {
        super();
        this.service = new GoodsService();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        JSONObject json = new JSONObject();
        int cpage = 1;
        int count = 20;

        // 获取用户至定页面
        String page = request.getParameter("page");
        // 接受关键字
        String keywords = request.getParameter("keyword");
        
        //接受类别
        String type = request.getParameter("type");
        if(type == null || type == "null" || type == "")
        	type = null;

        json = service.searchGoods(page,keywords,type);
        response.getWriter().write(json.toJSONString());
        
    }
}