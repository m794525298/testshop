package com.testshop.manage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testshop.dao.CommentDao;
import com.testshop.dao.GoodsDao;
import com.testshop.pojo.CommentBean;
import com.testshop.pojo.GoodsBean;

/**
 * Servlet implementation class DoCommentAdd
 */
@WebServlet("/manage/admin_docommentadd")
public class DoCommentAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String parentId = request.getParameter("COMMENT_PARENT");
		String content = request.getParameter("COMMENT_CONTENT");
		String goodsId = request.getParameter("COMMENT_GOODSID");
		String publisherId = request.getParameter("COMMENT_PUBLISHER");
		GoodsBean goods = GoodsDao.admin_selectByID(goodsId);
		String goodsPublisherId = null;
		if(goods != null)
			goodsPublisherId = goods.getPublisherId();
		
		CommentBean comment = new CommentBean(null, null, parentId, content, goodsId, publisherId, goodsPublisherId);
		// 加入数据库的用户表
		int res= CommentDao.admin_insert(comment);
		//判然后重定向
		if(res == 0){
			response.sendRedirect("admin_docommentselect");
		} else {
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			switch (res) {
			case 1:
				out.write("alert('数据库错误');");
				break;
			case 2:
				out.write("alert('商品不存在');");
				break;
			case 3:
				out.write("alert('该用户不存在');");
				break;
			case 4:
				out.write("alert('被@用户不存在');");
				break;
			case 5:
				out.write("alert('被@用户没有在此商品下评论过');");
				break;
			default:
				out.write("alert('添加失败');");
				break;
			}
			out.write("window.history.go(-1)");

			out.write("</script>");
		}	
	}

}
