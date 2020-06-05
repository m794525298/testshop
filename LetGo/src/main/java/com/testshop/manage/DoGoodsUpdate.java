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

		String goodsId = request.getParameter("GOODSID");
		String type = request.getParameter("GOODS_TYPE");
		String desc = request.getParameter("GOODS_DESC");
		String title = request.getParameter("GOODS_TITLE");
		String state = request.getParameter("GOODS_STATE");
		String price = request.getParameter("GOODS_PRICE");
		String Count = request.getParameter("GOODS_COUNT");
		String images = request.getParameter("GOODS_IMAGES");
		String address = request.getParameter("GOODS_ADDRESS");
		String contact = request.getParameter("GOODS_CONTACT");
		String publisherId = request.getParameter("GOODS_PUBLISHER");
		
		GoodsBean goods =new GoodsBean(goodsId, type, desc, title, state, price, Count, address, contact, publisherId, null);

		// 加入数据库的商品表
		int res = GoodsDao.admin_update(goods);

		// 判然后重定向

		if (res == 0) {
			response.sendRedirect("admin_dogoodsselect?page="+request.getParameter("cpage")+"&keywords="+request.getParameter("keywords"));
		} else {
			PrintWriter out = response.getWriter();

			out.write("<script>");
			out.write("alert('修改商品信息失败');");
			out.write("window.history.go(-1)");

			out.write("</script>");
		}
	}

}
