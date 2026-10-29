package com.kodewala.ecommerce.exception;

public class InsufficientStockException extends RuntimeException {
	public InsufficientStockException(String _message) {
		super(_message);
	}
}