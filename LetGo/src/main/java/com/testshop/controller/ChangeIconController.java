package com.testshop.controller;

import com.alibaba.fastjson.JSONObject;
import com.testshop.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class PasswordController
 */
@WebServlet("/ChangeIcon")
public class ChangeIconController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService service;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeIconController() {
        super();
        this.service = new UserService();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userID");
        String img = request.getParameter("icon");

        JSONObject rs = new JSONObject();
        if (service.changeIcon(userId,img)) {
            rs.put("success", true+"");
        }else {
            rs.put("success", false+"");
        }
        response.getWriter().write(rs.toJSONString());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}