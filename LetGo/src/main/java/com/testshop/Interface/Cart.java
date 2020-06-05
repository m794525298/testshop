package com.testshop.Interface;

import com.alibaba.fastjson.JSONObject;

public interface Cart {
	public JSONObject isCartExist(String userId, String goodsId);
	public JSONObject addToFavorite(String userId, String goodsId);
	public JSONObject removeFromFavorite(String userId, String goodsId);
	public JSONObject getUserCart(String userId, String page);
}
