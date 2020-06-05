package com.testshop.manage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testshop.dao.CartDao;
import com.testshop.pojo.CartBean;

/**
 * Servlet implementation class DocartUpdate
 */
@WebServlet("/manage/admin_docartupdate")
public class DoCartUpdate extends HttpServlet {
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

		String cartId = request.getParameter("CARTID");
		String userId = request.getParameter("CART_USERID");
		String goodsId = request.getParameter("CART_GOODSID");

		CartBean cart = new CartBean(cartId, userId, goodsId);
		// 加入数据库的用户表

		int res = CartDao.admin_update(cart);

		// 判然后重定向
		if (res == 0) {
			response.sendRedirect("admin_docartselect?page="+request.getParameter("cpage")+"&keywords="+request.getParameter("keywords"));
		} else {
			PrintWriter out = response.getWriter();

			out.write("<script>");
			out.write("alert('收藏夹修改失败');");
			out.write("window.history.go(-1)");

			out.write("</script>");
		}
	}

}
