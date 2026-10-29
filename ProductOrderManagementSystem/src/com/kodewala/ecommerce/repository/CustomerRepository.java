package com.kodewala.ecommerce.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kodewala.ecommerce.model.Customer;

public class CustomerRepository {

	private Map<Integer, Customer> customers = new HashMap<>();

	// Save Customer
	public void saveCustomer(Customer customer) {
		customers.put(customer.getCustomerId(), customer);
	}

	// Find Customer By ID
	public Customer findById(int customerId) {
		return customers.get(customerId);
	}

	// Get All Customers
	public List<Customer> getAllCustomers() {
		return new ArrayList<>(customers.values());
	}

	// Update Customer
	public void updateCustomer(Customer customer) {
		customers.put(customer.getCustomerId(), customer);
	}
}
