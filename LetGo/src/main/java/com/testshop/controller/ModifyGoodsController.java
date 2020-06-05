package com.testshop.controller;

import com.alibaba.fastjson.JSONObject;
import com.testshop.common.ServletResponse;
import com.testshop.service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/ModifyGoods")
public class ModifyGoodsController extends HttpServlet {
    private GoodsService service;
    public ModifyGoodsController() {
        super();
        this.service = new GoodsService();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,String[]> data = req.getParameterMap();
        JSONObject result = new JSONObject();
        result.put("success",String.valueOf(service.modifyGoods(data)));
        ServletResponse.response(resp,result);
    }
}
