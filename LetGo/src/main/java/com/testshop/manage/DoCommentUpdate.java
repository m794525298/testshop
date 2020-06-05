package com.testshop.manage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testshop.dao.CommentDao;
import com.testshop.dao.GoodsDao;
import com.testshop.pojo.CommentBean;
import com.testshop.pojo.GoodsBean;

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
				
		GoodsBean goods = GoodsDao.admin_selectByID(goodsID);
		String goodsPublisher = goods.getPublisherId();

		CommentBean comment = new CommentBean(commentID, time, parent, content, goodsID, publisher, goodsPublisher);
		
		// 加入数据库的用户表
		int res = CommentDao.admin_update(comment);
		
		// 判然后重定向
		if (res == 0) {
			response.sendRedirect("admin_docommentselect?page="+request.getParameter("cpage")+"&keywords="+request.getParameter("keywords"));
		} else {
			PrintWriter out = response.getWriter();

			out.write("<script>");
			out.write("alert('评论信息修改失败');");
			out.write("window.history.go(-1)");

			out.write("</script>");
		}
	}

}
