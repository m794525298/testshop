package com.testshop.servlet.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testshop.entity.TESTSHOP_USER;
import com.testshop.service.TESTSHOP_USERDao;

/**
 * Servlet implementation class DoUserSelect
 */
@WebServlet("/manage/admin_douserselect")
public class DoUserSelect extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int cpage=1;
		int count =5;
		
		//获取用户至定页面
		
		String cp =request.getParameter("cp");
		
		if(cp!=null){
			
			cpage = Integer.parseInt(cp);
			
		}
		int arr[]=TESTSHOP_USERDao.totalPage(count);
		
		
		
		
		//获取了所有的用户记录了
		ArrayList<TESTSHOP_USER> list=TESTSHOP_USERDao.selectAll(cpage,  count);
		
		//放到请求对象
		
		request.setAttribute("userlist", list);
		request.setAttribute("tsum", arr[0]);
		request.setAttribute("tpage", arr[1]);
		request.setAttribute("cp", cpage);
		request.getRequestDispatcher("admin_user.jsp").forward(request, response);
		
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
