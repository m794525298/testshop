package com.testshop.controller;

import com.alibaba.fastjson.JSONObject;
import com.testshop.common.Coder;
import com.testshop.common.ServletResponse;
import com.testshop.service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/MainPage")
public class MainPageController extends HttpServlet {
    private GoodsService service;
    public MainPageController() {
        super();
        this.service = new GoodsService();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JSONObject result = new JSONObject();
        Map<String, List<Map<String,String>>> data = new HashMap<>();
        data.put("goods_study", service.getGoodsByTypeAndNum("1",6));
        data.put("goods_dailyuse", service.getGoodsByTypeAndNum("2",6));
        data.put("goods_eat", service.getGoodsByTypeAndNum("3",8));
        result.put("goods",data);
        ServletResponse.response(resp,result);
        
        System.out.println(Coder.encrypted("4"));
    }
}
