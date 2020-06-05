package com.testshop.service;

import com.alibaba.fastjson.JSONObject;
import com.testshop.Interface.Goods;
import com.testshop.common.ImageUtils;
import com.testshop.dao.GoodsDao;
import com.testshop.dao.UserDao;
import com.testshop.pojo.GoodsBean;

import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoodsService implements Goods {

	@Override
    public JSONObject getGoodsDetail(String goodsID) {

		Map<String,String> map = GoodsDao.getDetailsByGoodsId(goodsID);
        if (map==null){
            return null;
        }
        JSONObject data = new JSONObject();
        data.put("goodsID",map.get("GOODS_ID"));
        data.put("title",map.get("GOODS_TITLE"));
        data.put("type",map.get("GOODS_TYPE"));
        data.put("desc",map.get("GOODS_DESC"));
        data.put("state",map.get("GOODS_STATE"));
        data.put("price",map.get("GOODS_PRICE"));
        data.put("count",map.get("GOODS_COUNT"));
        data.put("publisher",map.get("GOODS_PUBLISHER"));
        data.put("publisherName",map.get("USER_NAME"));
        data.put("contact",map.get("GOODS_CONTACT"));
        data.put("address",map.get("GOODS_ADDRESS"));
        data.put("img", ImageUtils.getImagePaths(goodsID,Integer.parseInt(map.get("GOODS_IMG_COUNT"))));
        return data;
    }
	
	@Override
    public boolean saveGoods(Map<String,String[]> data){
		
		if(!UserDao.isSeller(data.get("publisher")[0]))
			return false;
		
	    int imgCount = 0;
	    List<String> images = new ArrayList<>();
        for (int i = 1; i <6 ; i++) {
            String img = data.get(("img"+i))[0];
            if (!img.equals("")){
            	imgCount++;
                images.add(img);
            }
            System.out.println("imgCount: " + imgCount);
        }
        GoodsBean goodsBean = new GoodsBean(
                "",
                data.get("type")[0],
                data.get("desc")[0],
                data.get("title")[0],
                "0",
                data.get("price")[0],
                data.get("count")[0],
                data.get("address")[0],
                data.get("contact")[0],
                data.get("publisher")[0],
                String.valueOf(imgCount)
        );
        int id =  GoodsDao.insertGoods(goodsBean);
        if (id<0){
            return false;
        }


        return ImageUtils.saveGoodsImage(String.valueOf(id),images.toArray(new String[0]));
    }
	
	@Override
    public  List<Map<String,String>> getGoodsByTypeAndNum(String type, int num) {
          return GoodsDao.getGoodsByTypeAndNum(type,num);
    }

    @Override
    public boolean modifyGoods(Map<String, String[]> data) {
    	GoodsBean goods = GoodsDao.admin_selectByID(data.get("goodsID")[0]);
        GoodsBean goodsBean = new GoodsBean(
                data.get("goodsID")[0],
                data.get("type")[0],
                data.get("desc")[0],
                data.get("title")[0],
                data.get("state")[0],
                data.get("price")[0],
                data.get("count")[0],
                data.get("address")[0],
                data.get("contact")[0],
                data.get("publisher")[0],
                goods.getCount()    
        );
        int result = GoodsDao.updateGoods(goodsBean);
        return result==0;
    }

    @Override
    public JSONObject getGoodsListByUserId(String userId,String page) throws SQLException {
        List<Map<String, String>> result = new ArrayList<>();
        ResultSet rs = GoodsDao.getGoodsList(userId,page);
        int num = 0;
        if (rs!=null) {
            while (rs.next()) {
                Map<String, String> data = new HashMap<>();
                String goodsId = rs.getString("GOODS_ID");
                data.put("goodsID", goodsId);
                data.put("title", rs.getString("GOODS_TITLE"));
                data.put("type", rs.getString("GOODS_TYPE"));
                data.put("desc", rs.getString("GOODS_DESC"));
                data.put("count", rs.getString("GOODS_COUNT"));
                data.put("price", rs.getString("GOODS_PRICE"));
                data.put("state", rs.getString("GOODS_STATE"));
                data.put("cover", ImageUtils.getImagePaths(goodsId, 1).get(0));
                result.add(data);
                num++;
            }
        }
        JSONObject object = new JSONObject();
        object.put("goods",result);
        object.put("num",String.valueOf(num));
        int totalCount = GoodsDao.getGoodsNum(userId);
        object.put("totalPage", String.valueOf((totalCount % 20 == 0) ? totalCount / 20: totalCount / 20 + 1));
        return object;
    }

    @Override
    public boolean modifyGoodsState(String userId, String goodsId, String state) {
        return GoodsDao.modifyGoodsState(goodsId,userId,state);
    }
    
    @Override
    public JSONObject searchGoods(String page, String keywords, String type) throws UnsupportedEncodingException {

        int cpage = 1;
        int count = 20;

        // 获取用户至定页面
        String p = page;
        // 接受关键字
        if(keywords != null) {
            keywords = new String(Base64.getDecoder().decode(keywords));
        }
        if (p != null) {
            cpage = Integer.parseInt(p);
        }        
        
        List<Map<String,String>> list = GoodsDao.searchGoods(cpage, count, keywords,type);
        int goodsNum = GoodsDao.getSearchGoodsNum(cpage, count, keywords,type);
        JSONObject json = new JSONObject();
        json.put("totalPage",String.valueOf((goodsNum % count == 0) ? goodsNum / count : goodsNum / count + 1));
        json.put("num",String.valueOf(goodsNum));

        json.put("goods", list);

        return json;
    }
}
