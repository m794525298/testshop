package com.testshop.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testshop.entity.TESTSHOP_USER;
import com.testshop.service.TESTSHOP_USERDao;
/**
 * Servlet implementation class DoUserAdd
 */
@WebServlet("/manage/admin_douseradd")
public class DoUserAdd extends HttpServlet {
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String username = request.getParameter("USER_NAME");
		String account = request.getParameter("USER_ACCOUNT");
		String password = request.getParameter("USER_PASSWORD");
		String icon = request.getParameter("USER_ICON");
		String email = request.getParameter("USER_EMAIL");
		String stuNum = request.getParameter("USER_STUNUM");
		String address = request.getParameter("USER_ADDRESS");
		String contact = request.getParameter("USER_CONTACT");
		String identity = request.getParameter("USER_IDENTITY");
		
		TESTSHOP_USER u =new TESTSHOP_USER(null, username, account, password ,icon, email, stuNum, address, contact, identity);
		
		// 加入数据库的用户表
		int count= TESTSHOP_USERDao.insert(u);
		
		//判然后重定向
		if(count>0){
			response.sendRedirect("admin_douserselect");
		} else {
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alter('添加失败')");
			out.write("location.href='manage/admin_useradd.jsp'");

			out.write("</script>");
		}
		
		
	}

}
