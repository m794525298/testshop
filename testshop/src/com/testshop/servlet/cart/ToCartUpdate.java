package com.testshop.servlet.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testshop.entity.TESTSHOP_CART;
import com.testshop.service.TESTSHOP_CARTDao;

/**
 * Servlet implementation class TocartUpdate
 */
@WebServlet("/manage/admin_tocartupdate")
public class ToCartUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		
		// 通过ID到数据里查找
		TESTSHOP_CART cart = TESTSHOP_CARTDao.selectByID(id);
		
		request.setAttribute("cart", cart);
		request.setAttribute("cpage", request.getParameter("page"));
		request.setAttribute("keywords", request.getParameter("keywords"));
		request.getRequestDispatcher("admin_cartmodify.jsp").forward(request, response);
	}

}
