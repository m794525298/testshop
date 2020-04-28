package com.testshop.servlet.goods;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xpath.internal.compiler.Keywords;
import com.testshop.service.TESTSHOP_GOODSDao;

/**
 * Servlet implementation class DoGoodsDelete
 */
@WebServlet("/manage/admin_dogoodsdelete")
public class DoGoodsDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		String goodsID = request.getParameter("id");
		

		int count = TESTSHOP_GOODSDao.delete(goodsID);

		// 判然后转发请求
		if (count == 0) {
		
			PrintWriter out = response.getWriter();

			out.write("<script>");
			out.write("alter('删除失败')");
			out.write("</script>");
		}
		
		String keywords = request.getParameter("keywords");
		if(keywords != null) {
			response.sendRedirect("admin_dogoodsselect?page=" + request.getParameter("page") + "&keywords=" + request.getParameter("keywords"));
		} else {
			response.sendRedirect("admin_dogoodsselect?page=" + request.getParameter("page"));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String ids[] = request.getParameterValues("id[]");
		
		if(ids != null)
			for(int i = 0; i < ids.length; ++i)
				TESTSHOP_GOODSDao.delete(ids[i]);
		
		String keywords = request.getParameter("keywords");
		if(keywords != null) {
			response.sendRedirect("admin_dogoodsselect?page=" + request.getParameter("page") + "&keywords=" + request.getParameter("keywords"));
		} else {
			response.sendRedirect("admin_dogoodsselect?page=" + request.getParameter("page"));
		}
	}

}
