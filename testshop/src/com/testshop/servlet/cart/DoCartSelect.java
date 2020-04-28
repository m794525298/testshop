package com.testshop.servlet.cart;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testshop.entity.TESTSHOP_CART;
import com.testshop.service.TESTSHOP_CARTDao;

/**
 * Servlet implementation class DocartSelect
 */
@WebServlet("/manage/admin_docartselect")
public class DoCartSelect extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		int cpage = 1;
		int count = 5;

		// 获取用户至定页面
		String cp = request.getParameter("page");
		// 接受关键字
		String keywords = request.getParameter("keywords");
		if(keywords != null) {
			keywords = new String(keywords.getBytes("iso8859-1"), "utf-8");
			request.setAttribute("keywords", keywords);
		}
		
		if (cp != null) {
			cpage = Integer.parseInt(cp);
		}
		int arr[] = TESTSHOP_CARTDao.totalPage(count, keywords);

		// 获取了所有的用户记录了
		ArrayList<TESTSHOP_CART> list = TESTSHOP_CARTDao.selectAll(cpage, count, keywords);

		// 放到请求对象
		request.setAttribute("cartlist", list);
		request.setAttribute("tsum", arr[0]);
		request.setAttribute("tpage", arr[1]);
		request.setAttribute("cpage", cpage);

		if (keywords != null) {
			request.setAttribute("search", "&keywords=" + keywords);
		}
		request.getRequestDispatcher("admin_cart.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

}
