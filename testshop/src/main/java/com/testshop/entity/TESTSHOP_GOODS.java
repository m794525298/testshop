package com.testshop.entity;

public class TESTSHOP_GOODS {
	
	private String GOODS_ID;
	private String GOODS_TYPE;
	private String GOODS_DESC;
	private String GOODS_TITLE;
	private String GOODS_STATE;
	private String GOODS_PRICE;
	private String GOODS_COUNT;
	private String GOODS_IMAGES;
	private String GOODS_ADDRESS;
	private String GOODS_CONTACT;
	private String GOODS_PUBLISHER;
	
	public TESTSHOP_GOODS(String gOODS_ID, String gOODS_TYPE, String gOODS_DESC, String gOODS_TITLE, String gOODS_STATE,
			String gOODS_PRICE, String gOODS_COUNT, String gOODS_IMAGES, String gOODS_ADDRESS,
			String gOODS_CONTACT, String gOODS_PUBLISHER) {
		super();
		GOODS_ID = gOODS_ID;
		GOODS_TYPE = gOODS_TYPE;
		GOODS_DESC = gOODS_DESC;
		GOODS_TITLE = gOODS_TITLE;
		GOODS_STATE = gOODS_STATE;
		GOODS_PRICE = gOODS_PRICE;
		GOODS_COUNT = gOODS_COUNT;
		GOODS_IMAGES = gOODS_IMAGES;
		GOODS_ADDRESS = gOODS_ADDRESS;
		GOODS_CONTACT = gOODS_CONTACT;
		GOODS_PUBLISHER = gOODS_PUBLISHER;
	}

	public String getGOODS_ID() {
		return GOODS_ID;
	}

	public void setGOODS_ID(String gOODS_ID) {
		GOODS_ID = gOODS_ID;
	}

	public String getGOODS_TYPE() {
		return GOODS_TYPE;
	}

	public void setGOODS_TYPE(String gOODS_TYPE) {
		GOODS_TYPE = gOODS_TYPE;
	}

	public String getGOODS_DESC() {
		return GOODS_DESC;
	}

	public void setGOODS_DESC(String gOODS_DESC) {
		GOODS_DESC = gOODS_DESC;
	}

	public String getGOODS_TITLE() {
		return GOODS_TITLE;
	}

	public void setGOODS_TITLE(String gOODS_TITLE) {
		GOODS_TITLE = gOODS_TITLE;
	}
	
	public String getGOODS_STATE() {
		return GOODS_STATE;
	}
	
	public void setGOODS_STATE(String gOODS_STATE) {
		GOODS_TITLE = gOODS_STATE;
	}

	public String getGOODS_PRICE() {
		return GOODS_PRICE;
	}

	public void setGOODS_PRICE(String gOODS_PRICE) {
		GOODS_PRICE = gOODS_PRICE;
	}

	public String getGOODS_COUNT() {
		return GOODS_COUNT;
	}

	public void setGOODS_COUNT(String gOODS_COUNT) {
		GOODS_COUNT = gOODS_COUNT;
	}

	public String getGOODS_IMAGES() {
		return GOODS_IMAGES;
	}

	public void setGOODS_IMAGES(String gOODS_IMAGES) {
		GOODS_IMAGES = gOODS_IMAGES;
	}

	public String getGOODS_ADDRESS() {
		return GOODS_ADDRESS;
	}

	public void setGOODS_ADDRESS(String gOODS_ADDRESS) {
		GOODS_ADDRESS = gOODS_ADDRESS;
	}

	public String getGOODS_CONTACT() {
		return GOODS_CONTACT;
	}

	public void setGOODS_CONTACT(String gOODS_CONTACT) {
		GOODS_CONTACT = gOODS_CONTACT;
	}

	public String getGOODS_PUBLISHER() {
		return GOODS_PUBLISHER;
	}

	public void setGOODS_PUBLISHER(String gOODS_PUBLISHER) {
		GOODS_PUBLISHER = gOODS_PUBLISHER;
	}
	
}
