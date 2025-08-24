package com.example.model;

public class CartItem {

	
	private int id;
	private int restuarantId;
	private String name;
	private int price;
	private int quantity;
	
	public CartItem() {
		// TODO Auto-generated constructor stub
	}

	public CartItem(int id, int restuarantId, String name, int price, int quantity) {
		super();
		this.id = id;
		this.restuarantId = restuarantId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRestuarantId() {
		return restuarantId;
	}

	public void setRestuarantId(int restuarantId) {
		this.restuarantId = restuarantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public int getPrice() {
//		return price;
//	}
	
	

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	
	
	
}
