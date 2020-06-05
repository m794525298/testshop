package com.testshop.controller;

import com.alibaba.fastjson.JSONObject;
import com.testshop.common.ServletResponse;
import com.testshop.service.SellerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/BindStuNum")
public class BindStuNumController extends HttpServlet {
    private SellerService service;

    public BindStuNumController() {
        super();
        this.service = new SellerService();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userID");
        String stuNum = req.getParameter("stuNum");
        String address = req.getParameter("address");
        String contact = req.getParameter("contact");

        boolean result = service.bindStuNum(userId,stuNum,address,contact);
        JSONObject js = new JSONObject();
        js.put("success", String.valueOf(result));
        ServletResponse.response(resp, js);
    }
}