package com.testshop.entity;

public class TESTSHOP_COMMENT {
	private String COMMENT_ID;
	private String USER_ID;
	private String GOODS_ID;
	private String COMMENT_TOID;
	private String COMMENT_CONTENT;
	private String COMMENT_TIME;
	
	public TESTSHOP_COMMENT(String cOMMENT_ID, String uSER_ID, String gOODS_ID,
			String cOMMENT_TOID, String cOMMENT_CONTENT, String cOMMENT_TIME) {
		super();
		COMMENT_ID = cOMMENT_ID;
		USER_ID = uSER_ID;
		GOODS_ID = gOODS_ID;
		COMMENT_TOID = cOMMENT_TOID;
		COMMENT_CONTENT = cOMMENT_CONTENT;
		COMMENT_TIME = cOMMENT_TIME;
	}
	public String getCOMMENT_ID() {
		return COMMENT_ID;
	}
	public void setCOMMENT_ID(String cOMMENT_ID) {
		COMMENT_ID = cOMMENT_ID;
	}
	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getGOODS_ID() {
		return GOODS_ID;
	}
	public void setGOODS_ID(String gOODS_ID) {
		GOODS_ID = gOODS_ID;
	}
	public String getCOMMENT_TOID() {
		return COMMENT_TOID;
	}
	public void setCOMMENT_TOID(String cOMMENT_TOID) {
		COMMENT_TOID = cOMMENT_TOID;
	}
	public String getCOMMENT_CONTENT() {
		return COMMENT_CONTENT;
	}
	public void setCOMMENT_CONTENT(String cOMMENT_CONTENT) {
		COMMENT_CONTENT = cOMMENT_CONTENT;
	}
	public String getCOMMENT_TIME() {
		return COMMENT_TIME;
	}
	public void setCOMMENT_TIME(String cOMMENT_TIME) {
		COMMENT_TIME = cOMMENT_TIME;
	}

	
}
