package com.testshop.service;

import com.testshop.dao.CommentDao;
import com.testshop.pojo.CommentBean;
import com.testshop.pojo.UserBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.testshop.dao.UserDao;
import com.testshop.Interface.Comment;

public class CommentService implements Comment {
	final static int countEachPage = 10;

	@Override
	public boolean publishComment(CommentBean comment) {
		// TODO Auto-generated method stub
		int res = CommentDao.insertComment(comment);
		System.out.println(res);
		return res == 0 ? true : false;
	}
	
	private JSONObject getCommentJSON(ResultSet rs, int commentNum) {
		JSONObject json = new JSONObject();
		
		try {
			if (rs == null || !rs.next() || commentNum == 0) {
				json.put("totalPage","0");
				json.put("num","0");
				json.put("commentList", "[]");
			} else {
				int num;
				List<JSONObject> comments = new LinkedList<JSONObject>();
				
				for(num = 0, rs.previous(); rs.next(); ++num) {
					JSONObject comment = new JSONObject();
					comment.put("commentID", rs.getString("COMMENT_ID"));
					comment.put("time", rs.getString("COMMENT_TIME"));
					comment.put("content", rs.getString("COMMENT_CONTENT"));
					comment.put("goodsID",rs.getString("COMMENT_GOODS_ID"));
					UserBean publisher = UserDao.selectByID(rs.getString("COMMENT_PUBLISHER"));
					if(publisher != null) {
						comment.put("publisher", publisher.getMD5ID());
						comment.put("publisherName", publisher.getUsername());
						comment.put("icon", publisher.getIcon());
					}
					
					String parentId = rs.getString("COMMENT_PARENT");
					if(parentId != null) {						
						UserBean parent = UserDao.selectByID(parentId);
						if(parent != null) {
							comment.put("commentParentUserID", parent.getId());
							comment.put("commentParentUsername", parent.getUsername());
						} else {
							comment.put("commentParentUserID", "");
							comment.put("commentParentUsername", "");
						}
					} else {
						comment.put("commentParentUserID", "");
						comment.put("commentParentUsername", "");
					}
					
					comments.add(comment);
				}
				json.put("num", String.valueOf(num));
				json.put("commentList", comments);
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
	public JSONObject getGoodsComments(String goodsId, String page) {
		int commentNum = CommentDao.getGoodsCommentNum(goodsId);
		ResultSet rs = CommentDao.getGoodsComments(goodsId, page, countEachPage);

		return getCommentJSON(rs, commentNum);
	}
	
	@Override
	public JSONObject getUserGoodsComments(String userId, String page) {
		int commentNum = CommentDao.getUserGoodsCommentNum(userId);
		ResultSet rs = CommentDao.getUserGoodsComments(userId, page, countEachPage);

		return getCommentJSON(rs, commentNum);
	}

	@Override
	public JSONObject getUserReply(String userId, String page) {
		int commentNum = CommentDao.getUserReplyNum(userId);
		ResultSet rs = CommentDao.getUserReply(userId, page, countEachPage);

		return getCommentJSON(rs, commentNum);
	}
}
