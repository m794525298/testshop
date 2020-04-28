package com.testshop.entity;

public class TESTSHOP_CART {
	private String CART_ID;
	private String USER_ID;
	private String GOODS_ID;
	private String GOODS_COUNT;
	
	
	public TESTSHOP_CART(String cART_ID, String uSER_ID, String gOODS_ID,
			String gOODS_COUNT) {
		super();
		CART_ID = cART_ID;
		USER_ID = uSER_ID;
		GOODS_ID = gOODS_ID;
		GOODS_COUNT = gOODS_COUNT;
	}
	public String getCART_ID() {
		return CART_ID;
	}
	public void setCART_ID(String cART_ID) {
		CART_ID = cART_ID;
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
	public String getGOODS_COUNT() {
		return GOODS_COUNT;
	}
	public void setGOODS_COUNT(String gOODS_COUNT) {
		GOODS_COUNT = gOODS_COUNT;
	}
	
}
