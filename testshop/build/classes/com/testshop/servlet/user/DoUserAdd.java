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
		
		String userid = request.getParameter("USERID");
		String username = request.getParameter("USERNAME");
		String userpassword = request.getParameter("USERPASSWORD");
		String useraccount = request.getParameter("USERACCOUNT");
		String useridentity = request.getParameter("USERIDENTITY");
		String useremail = request.getParameter("USEREMAIL");
		String userstunum = request.getParameter("USERSTUNUM");
		String useraddress = request.getParameter("USERADDRESS");
		String usericon = request.getParameter("USERICON");
		
		TESTSHOP_USER u =new TESTSHOP_USER(userid,username,userpassword,useraccount,useridentity,useremail,userstunum,useraddress,usericon);
		//加入数据库的用户表
		
		int count=TESTSHOP_USERDao.insert(u);
		
		
		
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
