package com.kodewala.ecommerce.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kodewala.ecommerce.model.CartItem;
import com.kodewala.ecommerce.model.Product;

public class CartService {

	private Map<Integer, List<CartItem>> carts = new HashMap<Integer, List<CartItem>>();

	// Add Product To Cart
	public void addToCart(int customerId, Product product, int quantity) {

		List<CartItem> cartItems = carts.get(customerId);
         if (cartItems == null) {

			cartItems = new ArrayList<CartItem>();

			carts.put(customerId, cartItems);
		}

		CartItem existingCartItem = null;

		for (CartItem cartItem : cartItems) {

			if (cartItem.getProductId() == product.getProductId()) {

				existingCartItem = cartItem;

				break;
			}
		}

		if (existingCartItem != null) {

			for (int i = 0; i < quantity; i++) {

				existingCartItem.increaseQuantity();
			}

		} else {

			CartItem cartItem = new CartItem(product.getProductId(), product.getProductName(), product.getPrice(),
					quantity);

			cartItems.add(cartItem);
		}
	}

	// Remove Product From Cart
	public void removeFromCart(int customerId, int productId) {

		List<CartItem> cartItems = carts.get(customerId);

		if (cartItems != null) {

			cartItems.removeIf(cartItem -> cartItem.getProductId() == productId);
		}
	}

	// Increase Product Quantity
	public void increaseQuantity(int customerId, int productId) {

		List<CartItem> cartItems = carts.get(customerId);

		if (cartItems != null) {

			for (CartItem cartItem : cartItems) {

				if (cartItem.getProductId() == productId) {

					cartItem.increaseQuantity();

					break;
				}
			}
		}
	}

	// Decrease Product Quantity
	public void decreaseQuantity(int customerId, int productId) {

		List<CartItem> cartItems = carts.get(customerId);

		if (cartItems != null) {

			for (CartItem cartItem : cartItems) {

				if (cartItem.getProductId() == productId) {

					cartItem.decreaseQuantity();

					break;
				}
			}
		}
	}

	// Get Customer Cart
	public List<CartItem> getCart(int customerId) {

		List<CartItem> cartItems = carts.get(customerId);

		if (cartItems == null) {

			return new ArrayList<CartItem>();
		}

		return cartItems;
	}

	// Calculate Cart Subtotal
	public double calculateCartSubtotal(int customerId) {

		double subtotal = 0;

		List<CartItem> cartItems = getCart(customerId);

		for (CartItem cartItem : cartItems) {

			subtotal += cartItem.getTotalPrice();
		}

		return subtotal;
	}

	// Clear Customer Cart
	public void clearCart(int customerId) {

		carts.remove(customerId);
	}
}