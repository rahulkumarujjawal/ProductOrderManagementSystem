package com.kodewala.ecommerce.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.kodewala.ecommerce.exception.InsufficientStockException;
import com.kodewala.ecommerce.model.CartItem;
import com.kodewala.ecommerce.model.Order;
import com.kodewala.ecommerce.model.Product;
import com.kodewala.ecommerce.repository.OrderRepository;
import com.kodewala.ecommerce.repository.ProductRepository;

public class OrderService {

	private OrderRepository orderRepository;
	private ProductRepository productRepository;
	private CartService cartService;

	private int orderIdCounter = 1000;

	private static final double gstRate = 0.18;
	private static final double deliveryCharge = 49;
	private static final double freedeliveryLimit = 599;

	private static final double wednesdayDiscountLimit = 1499;
	private static final double wednesdayDiscountRate = 0.15;

	private Set<String> allowedOrderStatuses = new HashSet<>(
			List.of("PLACED", "CONFIRMED", "SHIPPED", "DELIVERED", "CANCELLED"));

	// Constructor
	public OrderService(OrderRepository orderRepository, ProductRepository productRepository, CartService cartService) {

		this.orderRepository = orderRepository;
		this.productRepository = productRepository;
		this.cartService = cartService;
	}

	// 1. PLACE ORDER

	public Order placeOrder(int customerId) {

		List<CartItem> cartItems = cartService.getCart(customerId);

		if (cartItems.isEmpty()) {
			throw new IllegalArgumentException("Cart is empty. Cannot place order.");
		}

		// Check stock
		validateStock(cartItems);

		// Step 2: Calculate subtotal
		double subtotal = calculateSubtotal(customerId);

		// Calculate Wednesday discount
		double discount = calculateWednesdayDiscount(subtotal);

		// Amount after discount
		double amountAfterDiscount = subtotal - discount;

		// Calculate delivery charge
		double deliveryCharge = calculateDeliveryCharge(amountAfterDiscount);

		// Calculate GST
		double gstAmount = calculateGst(amountAfterDiscount);

		// Final totalamount
		double totalAmount = amountAfterDiscount + deliveryCharge + gstAmount;

		// Generate unique orderID
		int orderId = generateOrderId();

		// Copy cart items into order
		List<CartItem> orderItems = new ArrayList<>(cartItems);

		// Create Order object
		Order order = new Order(orderId, customerId, orderItems, totalAmount, gstAmount, "PLACED", LocalDate.now());

		// Reduce inventory
		reduceInventory(cartItems);

		// Save order
		orderRepository.saveOrder(order);

		// Clear cart
		cartService.clearCart(customerId);

		return order;
	}

	// 2. CALCULATE SUBTOTAL

	public double calculateSubtotal(int customerId) {

		return cartService.calculateCartSubtotal(customerId);
	}

	// 3. WEDNESDAY DISCOUNT

	public double calculateWednesdayDiscount(double subtotal) {

		LocalDate today = LocalDate.now();

		if (today.getDayOfWeek() == DayOfWeek.WEDNESDAY && subtotal > wednesdayDiscountLimit) {

			return subtotal * wednesdayDiscountRate;
		}

		return 0;
	}

	// 4. DELIVERY CHARGE

	public double calculateDeliveryCharge(double amount) {
		if (amount > freedeliveryLimit) {
			return 0;
		}
		return deliveryCharge;
	}

	// 5. GST CALCULATION

	public double calculateGst(double amount) {
		return amount * gstRate;
	}

	// 6. GRAND TOTAL

	public double calculateGrandTotal(int customerId) {

		double subtotal = calculateSubtotal(customerId);

		double discount = calculateWednesdayDiscount(subtotal);

		double amountAfterDiscount = subtotal - discount;

		double deliveryCharge = calculateDeliveryCharge(amountAfterDiscount);

		double gstAmount = calculateGst(amountAfterDiscount);

		double totalAmount = amountAfterDiscount + deliveryCharge + gstAmount;

		return totalAmount;
	}

	// 7. VALIDATE STOCK

	public void validateStock(List<CartItem> cartItems) {

		for (CartItem cartItem : cartItems) {
			Product product = productRepository.findById(cartItem.getProductId());
              if (product == null) {
    throw new IllegalArgumentException("Product not found: " + cartItem.getProductId());
			}

			if (cartItem.getQuantity() > product.getQuantity()) {
           throw new InsufficientStockException("Insufficient stock for product : " + product.getProductName()
						+ "Available stock: " + product.getQuantity() + "Requested :" + cartItem.getQuantity());
			}
		}
	}

	// 8. REDUCE INVENTORY

	public void reduceInventory(List<CartItem> cartItems) {

		for (CartItem cartItem : cartItems) {

			Product product = productRepository.findById(cartItem.getProductId());
			int remainingQuantity = product.getQuantity() - cartItem.getQuantity();
			product.setQuantity(remainingQuantity);

		}
	}

	// 9. GENERATE UNIQUE ORDER ID

	private int generateOrderId() {
		orderIdCounter++;
		while (orderRepository.findById(orderIdCounter) != null) {
			orderIdCounter++;
		}
		return orderIdCounter;
	}

	// 10. GET ORDER BY ID

	public Order getOrderById(int orderId) {
		return orderRepository.findById(orderId);

	}

	public List<Order> getAllOrders() {
		return orderRepository.getAllOrders();
	}

	// 11. GET CUSTOMER ORDERS

	public List<Order> getCustomerOrders(int customerId) {
		return orderRepository.findByCustomerId(customerId);

	}

	// 12. CANCEL ORDER

	public void cancelOrder(int orderId) {
		Order order = orderRepository.findById(orderId);

		if (order == null) {
       throw new IllegalArgumentException("Order not found: " + orderId);
		}

		if ("CANCELLED".equals(order.getOrderStatus())) {
          throw new IllegalArgumentException("Order is already cancelled.");
		}

		if ("DELIVERED".equals(order.getOrderStatus())) {
          throw new IllegalArgumentException("Delivered order cannot be cancelled.");
		}

		order.setOrderStatus("CANCELLED");
	}

	// 13. UPDATE ORDER STATUS

	public void updateOrderStatus(int orderId, String orderStatus) {

		if (!allowedOrderStatuses.contains(orderStatus)) {
			throw new IllegalArgumentException("Invalid order status: " + orderStatus);

		}

		Order order = orderRepository.findById(orderId);

		if (order == null) {

			throw new IllegalArgumentException("Order not found: " + orderId);
		}

		orderRepository.updateOrderStatus(orderId, orderStatus);
	}

	// 14. PRINT BILL

	public void printBill(int customerId) {

		List<CartItem> cartItems = cartService.getCart(customerId);

		if (cartItems.isEmpty()) {

			System.out.println("Cart is empty.");

			return;
		}

		double subtotal = calculateSubtotal(customerId);

		double discount = calculateWednesdayDiscount(subtotal);

		double amountAfterDiscount = subtotal - discount;

		double deliveryCharge = calculateDeliveryCharge(amountAfterDiscount);

		double gstAmount = calculateGst(amountAfterDiscount);

		double grandTotal = amountAfterDiscount + deliveryCharge + gstAmount;

		System.out.println();
		System.out.println("==============================================");
		System.out.println("                    BILL");
		System.out.println("==============================================");

		for (CartItem cartItem : cartItems) {

			System.out.println(cartItem.getProductName() + " | Quantity: " + cartItem.getQuantity() + " | Price: ₹"
					+ cartItem.getPrice() + " | Total: ₹" + cartItem.getTotalPrice());
		}

		System.out.println("----------------------------------------------");

		System.out.println("Subtotal           : " + subtotal);
		System.out.println("Wednesday Discount : " + discount);
		System.out.println("After Discount     : " + amountAfterDiscount);
		System.out.println("Delivery Charge    : " + deliveryCharge);
		System.out.println("GST (18%)          : " + gstAmount);

		System.out.println("----------------------------------------------");
		System.out.println("Grand Total        : " + grandTotal);
		System.out.println("==============================================");
	}
}
