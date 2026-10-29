package com.kodewala.ecommerce.model;

public class Product {

	private int productId;
	private String productName;
	private String category;
	private double price;
	private int quantity;
	private String brand;

	/*
	  I used here Product Attributes private to protect the data and achieve
	  encapsulation.Other classes cannot directly change the price or quantity;
	  They access them through getters and setters.where I can also apply
	  validation.
	  Private → Data protect → Getter/Setter → Validation
	  
	 */

	public Product(int _productId, String _productName, String _category, double _price, int _quantity, String _brand) {
		super();
		this.productId = _productId;
		this.productName = _productName;
		this.category = _category;
		this.price = _price;
		this.quantity = _quantity;
		this.brand = _brand;

		setPrice(price);
		setQuantity(quantity);

	}
	// -- Getters and Setters

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price < 0) {
			throw new IllegalArgumentException("Price Can Not  be Negative");
		}
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if (quantity < 0) {
			throw new IllegalArgumentException("Quantity cannot be negative");
		}
		this.quantity = quantity;
	}
	/*
	 * “I added validation in the setters to prevent invalid product data, such as
	 * negative price or quantity. The same validation is also used during object
	 * creation.”
	 */

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Product ID: " + productId + "\n"
	            + "Product Name: " + productName + "\n"
	            + "Category: " + category + "\n"
	            + "Price: " + price + "\n"
	            + "Quantity: " + quantity + "\n"
	            + "Brand: " + brand;
	}

	
}
