package com.testshop.servlet.comment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testshop.entity.TESTSHOP_COMMENT;
import com.testshop.service.TESTSHOP_COMMENTDao;

/**
 * Servlet implementation class DoCommentUpdate
 */
@WebServlet("/manage/admin_docommentupdate")
public class DoCommentUpdate extends HttpServlet {
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

		String commentID = request.getParameter("COMMENTID");
		String userID = request.getParameter("USERID");
		String goodsID = request.getParameter("GOODSID");
		String commentParent = request.getParameter("COMMENTPARENT");
		String commentContent = request.getParameter("COMMENTCONTENT");
		String commentTime = request.getParameter("COMMENTTIME");

		TESTSHOP_COMMENT comment = new TESTSHOP_COMMENT(commentID, userID, goodsID, commentParent, commentContent, commentTime);
		// 加入数据库的用户表

		int count = TESTSHOP_COMMENTDao.update(comment);

		// 判然后重定向

		if (count > 0) {
			response.sendRedirect("admin_docommentselect?page="+request.getParameter("cpage")+"&keywords="+request.getParameter("keywords"));
		} else {
			PrintWriter out = response.getWriter();

			out.write("<script>");
			out.write("alter('用户修改失败')");
			out.write("location.href='manage/admin_tocommentupdate?id"+commentID+"'");

			out.write("</script>");
		}
	}

}
