package com.kodewala.ecommerce.model;

import java.time.LocalDate;
import java.util.List;

public class Order {

	private int orderId;
	private int customerId;
	private List<CartItem> cartItems;

	private double totalAmount;
	private double gstAmount;

	private String orderStatus;
	private LocalDate orderDate;

	public Order(int orderId, int customerId, List<CartItem> cartItems, double totalAmount, double gstAmount,
			String orderStatus, LocalDate orderDate) {

		this.orderId = orderId;
		this.customerId = customerId;
		this.cartItems = cartItems;
		this.totalAmount = totalAmount;
		this.gstAmount = gstAmount;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getGstAmount() {
		return gstAmount;
	}

	public void setGstAmount(double gstAmount) {
		this.gstAmount = gstAmount;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {

		return "Order [orderId=" + orderId + ", customerId=" + customerId + ", cartItems=" + cartItems
				+ ", totalAmount=" + totalAmount + ", gstAmount=" + gstAmount + ", orderStatus=" + orderStatus
				+ ", orderDate=" + orderDate + "]";
	}
}