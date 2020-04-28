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
 * Servlet implementation class DoGoodsUpdate
 */
@WebServlet("/manage/admin_dogoodsupdate")
public class DoGoodsUpdate extends HttpServlet {
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

		String goodsID = request.getParameter("GOODSID");
		String goodsName = request.getParameter("GOODSNAME");
		String goodsDesc = request.getParameter("GOODSDESC");
		String goodsImg = request.getParameter("GOODSIMG");
		String goodsPrice = request.getParameter("GOODSPRICE");
		String goodsCount = request.getParameter("GOODSCOUNT");
		String goodsType = request.getParameter("GOODSTYPE");
		String userID = request.getParameter("USERID");
		String userContact = request.getParameter("USERCONTACT");

		TESTSHOP_GOODS goods =new TESTSHOP_GOODS(goodsID, goodsName, goodsDesc, goodsImg, goodsPrice, goodsCount, goodsType, userID, userContact);

		// 加入数据库的商品表
		int count = TESTSHOP_GOODSDao.update(goods);

		// 判然后重定向

		if (count > 0) {
			response.sendRedirect("admin_dogoodsselect?page="+request.getParameter("cpage")+"&keywords="+request.getParameter("keywords"));
		} else {
			PrintWriter out = response.getWriter();

			out.write("<script>");
			out.write("alter('用户修改失败')");
			out.write("location.href='manage/admin_togoodsupdate?id"+goodsID+"'");

			out.write("</script>");
		}
	}

}
