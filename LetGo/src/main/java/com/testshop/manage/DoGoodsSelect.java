package com.testshop.manage;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testshop.dao.GoodsDao;
import com.testshop.pojo.GoodsBean;

/**
 * Servlet implementation class DoGoodsSelect
 */
@WebServlet("/manage/admin_dogoodsselect")
public class DoGoodsSelect extends HttpServlet {

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
		System.out.println(keywords);
		if(keywords != null) {
			keywords = new String(keywords.getBytes("iso8859-1"), "utf-8");
			request.setAttribute("keywords", keywords);
		}
		
		if (cp != null) {
			cpage = Integer.parseInt(cp);
		}
		int arr[] = GoodsDao.admin_totalPage(count, keywords);
		
		// 获取了所有的用户记录了
		ArrayList<GoodsBean> list = GoodsDao.admin_selectAll(cpage, count, keywords);

		// 放到请求对象
		request.setAttribute("goodslist", list);
		request.setAttribute("tsum", arr[0]);
		request.setAttribute("tpage", arr[1]);
		request.setAttribute("cpage", cpage);
		
		if (keywords != null) {
			request.setAttribute("search", "&keywords=" + keywords);
		}
		request.getRequestDispatcher("admin_goods.jsp").forward(request, response);

	}
}
