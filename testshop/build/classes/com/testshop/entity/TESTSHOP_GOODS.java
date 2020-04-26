package com.testshop.entity;

public class TESTSHOP_GOODS {
	
	private String GOODS_ID;
	private String GOODS_NAME;
	private String GOODS_INTRUDUCTION;
	private String GOODS_PRICE;
	private String GOODS_TYPE;
	private String GOODS_IMG;
	private String GOODS_CONTACT;
	private String USER_ID;
	private String GOODS_COUNT;
	
	
	
	public TESTSHOP_GOODS(String gOODS_ID, String gOODS_NAME,
			String gOODS_INTRUDUCTION, String gOODS_PRICE, String gOODS_TYPE,
			String gOODS_IMG, String gOODS_CONTACT, String uSER_ID,
			String gOODS_COUNT) {
		super();
		GOODS_ID = gOODS_ID;
		GOODS_NAME = gOODS_NAME;
		GOODS_INTRUDUCTION = gOODS_INTRUDUCTION;
		GOODS_PRICE = gOODS_PRICE;
		GOODS_TYPE = gOODS_TYPE;
		GOODS_IMG = gOODS_IMG;
		GOODS_CONTACT = gOODS_CONTACT;
		USER_ID = uSER_ID;
		GOODS_COUNT = gOODS_COUNT;
	}
	public String getGOODS_ID() {
		return GOODS_ID;
	}
	public void setGOODS_ID(String gOODS_ID) {
		GOODS_ID = gOODS_ID;
	}
	public String getGOODS_NAME() {
		return GOODS_NAME;
	}
	public void setGOODS_NAME(String gOODS_NAME) {
		GOODS_NAME = gOODS_NAME;
	}
	public String getGOODS_INTRUDUCTION() {
		return GOODS_INTRUDUCTION;
	}
	public void setGOODS_INTRUDUCTION(String gOODS_INTRUDUCTION) {
		GOODS_INTRUDUCTION = gOODS_INTRUDUCTION;
	}
	public String getGOODS_PRICE() {
		return GOODS_PRICE;
	}
	public void setGOODS_PRICE(String gOODS_PRICE) {
		GOODS_PRICE = gOODS_PRICE;
	}
	public String getGOODS_TYPE() {
		return GOODS_TYPE;
	}
	public void setGOODS_TYPE(String gOODS_TYPE) {
		GOODS_TYPE = gOODS_TYPE;
	}
	public String getGOODS_IMG() {
		return GOODS_IMG;
	}
	public void setGOODS_IMG(String gOODS_IMG) {
		GOODS_IMG = gOODS_IMG;
	}
	public String getGOODS_CONTACT() {
		return GOODS_CONTACT;
	}
	public void setGOODS_CONTACT(String gOODS_CONTACT) {
		GOODS_CONTACT = gOODS_CONTACT;
	}
	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getGOODS_COUNT() {
		return GOODS_COUNT;
	}
	public void setGOODS_COUNT(String gOODS_COUNT) {
		GOODS_COUNT = gOODS_COUNT;
	}
	
}
