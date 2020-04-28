package com.testshop.servlet.cart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testshop.entity.TESTSHOP_CART;
import com.testshop.service.TESTSHOP_CARTDao;

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

		String cartID = request.getParameter("CARTID");
		String userID = request.getParameter("USERID");
		String goodsID = request.getParameter("GOODSID");
		String goodsCount = request.getParameter("GOODSCOUNT");

		TESTSHOP_CART cart = new TESTSHOP_CART(cartID, userID, goodsID, goodsCount);
		// 加入数据库的用户表

		int count = TESTSHOP_CARTDao.update(cart);

		// 判然后重定向

		if (count > 0) {
			response.sendRedirect("admin_docartselect?page="+request.getParameter("cpage")+"&keywords="+request.getParameter("keywords"));
		} else {
			PrintWriter out = response.getWriter();

			out.write("<script>");
			out.write("alter('用户修改失败')");
			out.write("location.href='manage/admin_tocartupdate?id"+cartID+"'");

			out.write("</script>");
		}
	}

}
