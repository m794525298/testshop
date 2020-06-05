package com.testshop.pojo;

public class UserBean {
	private String id;
	private	String username;
	private String account;
	private String password;
	private String icon;
	private String email;
	private String stuNum;
	private String address;
	private String contact;
	private String identity;
	private String MD5ID;
	
	public UserBean(){
		super();
	}
	
	public UserBean(String id, String username, String account, String password, String icon, String email,
			String stuNum, String address, String contact, String identity, String mD5ID) {
		super();
		this.id = id;
		this.username = username;
		this.account = account;
		this.password = password;
		this.icon = icon;
		this.email = email;
		this.stuNum = stuNum;
		this.address = address;
		this.contact = contact;
		this.identity = identity;
		this.MD5ID = mD5ID;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStuNum() {
		return stuNum;
	}
	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getMD5ID() {
		return MD5ID;
	}
	public void setMD5ID(String mD5ID) {
		MD5ID = mD5ID;
	}
}
