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
 * Servlet implementation class DoUserUpdate
 */
@WebServlet("/manage/admin_douserupdate")
public class DoUserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		String userID = request.getParameter("USERID");
		String userName = request.getParameter("USERNAME");
		String userAccount = request.getParameter("USERACCOUNT");
		String userPassword = request.getParameter("USERPASSWORD");
		String userIdentity = request.getParameter("USERIDENTITY");
		String userEmail = request.getParameter("USEREMAIL");
		String userStuNum = request.getParameter("USERSTUNUM");
		String userAddress = request.getParameter("USERADDRESS");
		String userIcon = request.getParameter("USERICON");

		TESTSHOP_USER u = new TESTSHOP_USER(userID, userName, userPassword, userAccount, userIdentity, userEmail,
				userStuNum, userAddress, userIcon);
		// 加入数据库的用户表

		int count = TESTSHOP_USERDao.update(u);

		// 判然后重定向

		if (count > 0) {
			response.sendRedirect("admin_douserselect?page="+request.getParameter("cpage")+"&keywords="+request.getParameter("keywords"));
		} else {
			PrintWriter out = response.getWriter();

			out.write("<script>");
			out.write("alter('用户修改失败')");
			out.write("location.href='manage/admin_touserupdate?id"+userID+"'");

			out.write("</script>");
		}
	}

}
