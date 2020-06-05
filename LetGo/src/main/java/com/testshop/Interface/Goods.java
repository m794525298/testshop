package com.testshop.Interface;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface Goods {
	public JSONObject getGoodsDetail(String goodsID);
    public boolean saveGoods(Map<String,String[]> data);
    public List<Map<String,String>> getGoodsByTypeAndNum(String type, int num);
    public boolean modifyGoods(Map<String,String[]> data);
    public JSONObject getGoodsListByUserId(String userId,String page) throws SQLException;
    public boolean modifyGoodsState(String userId,String goodsId,String state);
    public JSONObject searchGoods(String page, String keyword, String type) throws UnsupportedEncodingException;
}
