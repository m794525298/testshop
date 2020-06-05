package com.testshop.pojo;

public class CommentBean {
	private String id;
	private String time;
	private String parentId;
	private String content;
	private String goodsId;
	private String publisherId;
	private String goodsPublisherId;
	
	public CommentBean(String id, String time, String parentId, String content, String goodsId, String publisherId,
			String goodsPublisherId) {
		super();
		this.id = id;
		this.time = time;
		this.parentId = parentId;
		this.content = content;
		this.goodsId = goodsId;
		this.publisherId = publisherId;
		this.goodsPublisherId = goodsPublisherId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}

	public String getGoodsPublisherId() {
		return goodsPublisherId;
	}

	public void setGoodsPublisherId(String goodsPublisherId) {
		this.goodsPublisherId = goodsPublisherId;
	}
}
