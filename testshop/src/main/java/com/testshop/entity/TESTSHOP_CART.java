package com.testshop.entity;

public class TESTSHOP_CART {
	private String CART_ID;
	private String CART_USER_ID;
	private String CART_GOODS_ID;
	
	public TESTSHOP_CART(String cART_ID, String cART_USER_ID, String cART_GOODS_ID) {
		super();
		CART_ID = cART_ID;
		CART_USER_ID = cART_USER_ID;
		CART_GOODS_ID = cART_GOODS_ID;
	}

	public String getCART_ID() {
		return CART_ID;
	}

	public void setCART_ID(String cART_ID) {
		CART_ID = cART_ID;
	}

	public String getCART_USER_ID() {
		return CART_USER_ID;
	}

	public void setCART_USER_ID(String cART_USER_ID) {
		CART_USER_ID = cART_USER_ID;
	}

	public String getCART_GOODS_ID() {
		return CART_GOODS_ID;
	}

	public void setCART_GOODS_ID(String cART_GOODS_ID) {
		CART_GOODS_ID = cART_GOODS_ID;
	}
}
