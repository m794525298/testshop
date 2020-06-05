package com.testshop.manage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testshop.dao.GoodsDao;
import com.testshop.pojo.GoodsBean;
/**
 * Servlet implementation class DoGoodsAdd
 */
@WebServlet("/manage/admin_dogoodsadd")
public class DoGoodsAdd extends HttpServlet {
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String type = request.getParameter("GOODS_TYPE");
		String desc = request.getParameter("GOODS_DESC");
		String title = request.getParameter("GOODS_TITLE");
		String state = request.getParameter("GOODS_STATE");
		String price = request.getParameter("GOODS_PRICE");
		String Count = request.getParameter("GOODS_COUNT");
		String address = request.getParameter("GOODS_ADDRESS");
		String contact = request.getParameter("GOODS_CONTACT");
		String publisherId = request.getParameter("GOODS_PUBLISHER");
		
		GoodsBean goods =new GoodsBean(null, type, desc, title, state, price, Count, address, contact, publisherId, null);
		
		//加入数据库的用户表
		int res= GoodsDao.admin_insert(goods);
		
		//判然后重定向
		if(res == 0){
			response.sendRedirect("admin_dogoodsselect");
		} else {
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('添加失败');");
			out.write("window.history.go(-1)");

			out.write("</script>");
		}
		
		
	}

}
