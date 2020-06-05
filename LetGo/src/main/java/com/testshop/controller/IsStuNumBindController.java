package com.testshop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.testshop.common.ServletResponse;
import com.testshop.service.SellerService;

/**
 * Servlet implementation class IsStuNumBindController
 */
@WebServlet("/IsStuNumBind")
public class IsStuNumBindController extends HttpServlet {
    private SellerService service;

    public IsStuNumBindController() {
        super();
        this.service = new SellerService();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    	String userId = req.getParameter("userID");

        boolean result = service.isStuNumBind(userId);
                
        JSONObject js = new JSONObject();
        js.put("found", String.valueOf(result));
        ServletResponse.response(resp, js);
    }
}
