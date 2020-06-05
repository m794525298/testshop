package com.testshop.controller;

import com.alibaba.fastjson.JSONObject;
import com.testshop.common.ServletResponse;
import com.testshop.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UserDetail")
public class UserDetailController extends HttpServlet{
    private UserService service;

    public UserDetailController() {
        super();
        this.service = new UserService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userID");
        resp.setContentType("text/html;charset=utf-8");
        JSONObject result = service.getUserDetail(userId);
        if (result!=null)
            ServletResponse.response(resp, result);
    }
}
