package com.testshop.servlet.comment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testshop.entity.TESTSHOP_COMMENT;
import com.testshop.entity.TESTSHOP_GOODS;
import com.testshop.service.TESTSHOP_COMMENTDao;
import com.testshop.service.TESTSHOP_GOODSDao;

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
		String time = request.getParameter("COMMENT_TIME");
		String parent = request.getParameter("COMMENT_PARENT");
		String content = request.getParameter("COMMENT_CONTENT");
		String goodsID = request.getParameter("COMMENT_GOODSID");
		String publisher = request.getParameter("COMMENT_PUBLISHER");
		
		TESTSHOP_GOODS goods = TESTSHOP_GOODSDao.selectByID(goodsID);
		String goodsPublisher = goods.getGOODS_PUBLISHER();

		TESTSHOP_COMMENT comment = new TESTSHOP_COMMENT(commentID, time, parent, goodsID, content, publisher, goodsPublisher);
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
