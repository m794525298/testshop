package com.testshop.pojo;

public class GoodsBean {
	
	private String id;
	private String type;
	private String desc;
	private String title;
	private String state;
	private String price;
	private String count;
	private String address;
	private String contact;
	private String publisherId;
	private String imageCount;
	
	public GoodsBean(String id, String type, String desc, String title, String state, String price, String count,
			String address, String contact, String publisherId, String imageCount) {
		super();
		this.id = id;
		this.type = type;
		this.desc = desc;
		this.title = title;
		this.state = state;
		this.price = price;
		this.count = count;
		this.address = address;
		this.contact = contact;
		this.publisherId = publisherId;
		this.imageCount = imageCount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
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

	public String getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}
	
	public String getImageCount() {
		return imageCount;
	}

	public void setImageCount(String imageCount) {
		this.imageCount = imageCount;
	}
}
