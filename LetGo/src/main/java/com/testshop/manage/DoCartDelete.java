package com.testshop.manage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testshop.dao.CartDao;

/**
 * Servlet implementation class DoCartDelete
 */
@WebServlet("/manage/admin_docartdelete")
public class DoCartDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		String cartID = request.getParameter("id");
		

		int res = CartDao.admin_delete(cartID);

		// 判然后转发请求
		if (res > 0) {
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('删除失败');");
			out.write("</script>");
		}
		
		String keywords = request.getParameter("keywords");
		if(keywords != null) {
			response.sendRedirect("admin_docartselect?page=" + request.getParameter("page") + "&keywords=" + request.getParameter("keywords"));
		} else {
			response.sendRedirect("admin_docartselect?page=" + request.getParameter("page"));
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
				CartDao.admin_delete(ids[i]);
		
		String keywords = request.getParameter("keywords");
		if(keywords != null) {
			response.sendRedirect("admin_docartselect?page=" + request.getParameter("page") + "&keywords=" + request.getParameter("keywords"));
		} else {
			response.sendRedirect("admin_docartselect?page=" + request.getParameter("page"));
		}
	}

}
