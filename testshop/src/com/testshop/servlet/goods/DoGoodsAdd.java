package com.testshop.servlet.goods;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testshop.entity.TESTSHOP_GOODS;
import com.testshop.service.TESTSHOP_GOODSDao;
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
		
		String goodsName = request.getParameter("GOODSNAME");
		String goodsDesc = request.getParameter("GOODSDESC");
		String goodsImg = request.getParameter("GOODSIMG");
		String goodsPrice = request.getParameter("GOODSPRICE");
		String goodsCount = request.getParameter("GOODSCOUNT");
		String goodsType = request.getParameter("GOODSTYPE");
		String userID = request.getParameter("USERID");
		String userContact = request.getParameter("USERCONTACT");
		
		TESTSHOP_GOODS goods =new TESTSHOP_GOODS(null, goodsName, goodsDesc, goodsImg, goodsPrice, goodsCount, goodsType, userID, userContact);
		//加入数据库的用户表
		
		int count= TESTSHOP_GOODSDao.insert(goods);
		
		//判然后重定向
		if(count>0){
			response.sendRedirect("admin_dogoodsselect");
		} else {
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alter('添加失败')");
			out.write("location.href='manage/admin_goodsadd.jsp'");

			out.write("</script>");
		}
		
		
	}

}
