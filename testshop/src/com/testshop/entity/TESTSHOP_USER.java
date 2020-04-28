package com.testshop.entity;

public class TESTSHOP_USER {
	private String USER_ID;
	private	String USER_NAME;
	private String USER_PASSWORD;
	private String USER_ACCOUNT;
	private String USER_IDENTITY;
	private String USER_EMAIL;
	private String USER_STUNUM;
	private String USER_ADDRESS;
	private String USER_ICON;
	
	public TESTSHOP_USER(String uSER_ID, String uSER_NAME, String uSER_PASSWORD, String uSER_ACCOUNT,
			String uSER_IDENTITY, String uSER_EMAIL, String uSER_STUNUM, String uSER_ADDRESS, String uSER_ICON) {
		super();
		USER_ID = uSER_ID;
		USER_NAME = uSER_NAME;
		USER_PASSWORD = uSER_PASSWORD;
		USER_ACCOUNT = uSER_ACCOUNT;
		USER_IDENTITY = uSER_IDENTITY;
		USER_EMAIL = uSER_EMAIL;
		USER_STUNUM = uSER_STUNUM;
		USER_ADDRESS = uSER_ADDRESS;
		USER_ICON = uSER_ICON;
	}
	
	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getUSER_NAME() {
		return USER_NAME;
	}
	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	public String getUSER_PASSWORD() {
		return USER_PASSWORD;
	}
	public void setUSER_PASSWORD(String uSER_PASSWORD) {
		USER_PASSWORD = uSER_PASSWORD;
	}
	public String getUSER_ACCOUNT() {
		return USER_ACCOUNT;
	}
	public void setUSER_ACCOUNT(String uSER_ACCOUNT) {
		USER_ACCOUNT = uSER_ACCOUNT;
	}
	public String getUSER_ICON() {
		return USER_ICON;
	}
	public void setUSER_ICON(String uSER_ICON) {
		USER_ICON = uSER_ICON;
	}
	public String getUSER_IDENTITY() {
		return USER_IDENTITY;
	}
	public void setUSER_IDENTITY(String uSER_IDENTITY) {
		USER_IDENTITY = uSER_IDENTITY;
	}
	public String getUSER_EMAIL() {
		return USER_EMAIL;
	}
	public void setUSER_EMAIL(String uSER_EMAIL) {
		USER_EMAIL = uSER_EMAIL;
	}
	public String getUSER_STUNUM() {
		return USER_STUNUM;
	}
	public void setUSER_STUNUM(String uSER_STUNUM) {
		USER_STUNUM = uSER_STUNUM;
	}
	public String getUSER_ADDRESS() {
		return USER_ADDRESS;
	}
	public void setUSER_ADDRESS(String uSER_ADDRESS) {
		USER_ADDRESS = uSER_ADDRESS;
	}
	

}
