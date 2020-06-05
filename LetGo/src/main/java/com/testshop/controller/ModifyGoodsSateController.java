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

@WebServlet("/ModifyGoodsState")
public class ModifyGoodsSateController extends HttpServlet {
    private GoodsService service;
    public ModifyGoodsSateController() {
        super();
        this.service = new GoodsService();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JSONObject object = new JSONObject();
        String goodsId = req.getParameter("goodsID");
        String userId = req.getParameter("userID");
        String state  = req.getParameter("state");
        object.put("success",String.valueOf(service.modifyGoodsState(userId,goodsId,state)));
        ServletResponse.response(resp,object);
    }
}
