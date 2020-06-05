package com.testshop.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

public class ServletResponse extends HttpServlet{

	public static void response(HttpServletResponse response, JSONObject json) {
		// TODO Auto-generated constructor stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.println(json.toJSONString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(out != null) {
				out.flush();
				out.close();
			}
		}
	}
}
