package com.testshop.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.testshop.Interface.Cart;
import com.testshop.common.ImageUtils;
import com.testshop.dao.CartDao;
import com.testshop.dao.CommentDao;
import com.testshop.dao.GoodsDao;
import com.testshop.dao.UserDao;
import com.testshop.pojo.GoodsBean;
import com.testshop.pojo.UserBean;

public class CartService implements Cart {
	final static int countEachPage = 10;

	@Override
	public JSONObject isCartExist(String userId, String goodsId) {
		JSONObject json = new JSONObject();
		
		json.put("exist", String.valueOf(CartDao.isCartExist(userId, goodsId)));
		
		return json;
	}

	@Override
	public JSONObject addToFavorite(String userId, String goodsId) {
		JSONObject json = new JSONObject();
		
		json.put("success", (CartDao.insertCart(userId, goodsId) > 0) ? "true" : "false");
		
		return json;
	}

	@Override
	public JSONObject removeFromFavorite(String userId, String goodsId) {
		JSONObject json = new JSONObject();
		
		json.put("success", (CartDao.deleteCart(userId, goodsId) == 0) ? "true" : "false");
		
		return json;
	}
	
	private JSONObject getCartJSON(ResultSet rs, int commentNum) {
		JSONObject json = new JSONObject();
		
		try {
			if (rs == null || !rs.next() || commentNum == 0) {
				json.put("totalPage","0");
				json.put("num","0");
				json.put("goodsList", "[]");
			} else {
				int num;
				List<JSONObject> carts = new LinkedList<JSONObject>();
				
				for(num = 0, rs.previous(); rs.next(); ++num) {
					JSONObject cart = new JSONObject();
					GoodsBean goods = GoodsDao.admin_selectByID(rs.getString("CART_GOODS_ID"));
					if(goods != null) {
						cart.put("goodsID", goods.getId());
						cart.put("cover", ImageUtils.getImagePaths(goods.getId(), 1).get(0));
						cart.put("title", goods.getTitle());
						cart.put("desc", goods.getDesc());
						cart.put("price", goods.getPrice());
					}
					
					carts.add(cart);
				}
				json.put("num", String.valueOf(num));
				json.put("goodsList", carts);
				int totalPage = (commentNum % countEachPage == 0) ? (commentNum / countEachPage) : (commentNum / countEachPage + 1);
				json.put("totalPage", String.valueOf(totalPage));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return json;
	}
	
	@Override
	public JSONObject getUserCart(String userId, String page) {
		int commentNum = CartDao.getUserCartNum(userId);
		ResultSet rs = CartDao.getUserCart(userId, page, countEachPage);
		return getCartJSON(rs, commentNum);
	}
}
