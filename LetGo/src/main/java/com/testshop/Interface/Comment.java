package com.testshop.Interface;

import com.alibaba.fastjson.JSONObject;
import com.testshop.pojo.CommentBean;

public interface Comment {
	public boolean publishComment(CommentBean comment);
	public JSONObject getGoodsComments(String goodsId, String page);
	public JSONObject getUserGoodsComments(String userId, String page);
	public JSONObject getUserReply(String userId, String page);
}
