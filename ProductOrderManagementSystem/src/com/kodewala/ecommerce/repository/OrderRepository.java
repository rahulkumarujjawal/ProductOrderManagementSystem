package com.kodewala.ecommerce.repository;

import java.util.ArrayList;
import java.util.List;

import com.kodewala.ecommerce.model.Order;

public class OrderRepository {

	private List<Order> orders = new ArrayList<Order>();

	// Save Order
	public void saveOrder(Order order) {
		orders.add(order);
	}

	// find Order By Id:-
	public Order findById(int orderId) {
		for (Order order : orders) {
			if (order.getOrderId() == orderId) {
				return order;

			}
		}
		return null;

	}

	// find Orders By Cutsomers Id
	public List<Order> findByCustomerId(int customerId) {
		List<Order> customersOrders = new ArrayList<Order>();
		for (Order order : orders) {
			if (order.getCustomerId() == customerId) {
				customersOrders.add(order);
			}

		}
		return customersOrders;

	}

	// get All Orders
	public List<Order> getAllOrders() {
		return orders;
	}

	// update Order Status
	public void updateOrderStatus(int orderId, String orderStatus) {
		Order order = findById(orderId);
		if (order != null) {
			order.setOrderStatus(orderStatus);
		}
	}
}
