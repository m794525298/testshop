package com.testshop.manage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import com.testshop.dao.UserDao;
import com.testshop.pojo.UserBean;
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
		
		UserBean user =new UserBean(null, username, account, password ,icon, email, stuNum, address, contact, identity, null);
		
		// 加入数据库的用户表
		int res= UserDao.admin_insert(user);

		//判然后重定向
		if(res == 0){
			response.sendRedirect("admin_douserselect");
		} else {
			PrintWriter out = response.getWriter();
			out.write("<script language='javascript'>");
			out.write("alert('添加用户失败');");
			out.write("window.history.go(-1)");
			out.write("</script>");
		}
		
		
	}

}
