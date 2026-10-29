package com.kodewala.ecommerce.model;

public class CartItem {

	private int productId;
	private String productName;
	private double price;
	private int quantity;
	private double totalPrice;

	public CartItem(int productId, String productName, double price, int quantity) {

		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;

		calculateTotalPrice();
	}

	public int getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	// Increase Quantity
	public void increaseQuantity() {
        quantity++;
        calculateTotalPrice();
	}

	// Decrease Quantity
	public void decreaseQuantity() {

		if (quantity > 1) {
			quantity--;
          calculateTotalPrice();
		}
	}

	// Calculate Total Price
	public void calculateTotalPrice() {
       totalPrice = price * quantity;
	}
}