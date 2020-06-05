package com.testshop.controller;

import com.testshop.common.ServletResponse;
import com.testshop.service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/GoodsList")
public class GoodsListController extends HttpServlet {
    private GoodsService service;
    public GoodsListController() {
        super();
        this.service = new GoodsService();
    }  
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userID");
        String page = req.getParameter("page");
        try {
            ServletResponse.response(resp,service.getGoodsListByUserId(userId,page));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
