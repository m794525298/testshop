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
 * Servlet implementation class DoCartAdd
 */
@WebServlet("/manage/admin_docartadd")
public class DoCartAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String userId = request.getParameter("CART_USERID");
		String goodsId = request.getParameter("CART_GOODSID");
		
		CartBean cart = new CartBean(null, userId, goodsId);
		
		// 加入数据库的用户表
		int res= CartDao.admin_insert(cart);
		
		System.out.println(res);
		
		//判然后重定向
		if(res == 0){
			response.sendRedirect("admin_docartselect");
		} else {
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('添加收藏夹失败');");
			out.write("window.history.go(-1)");

			out.write("</script>");
		}	
	}

}
