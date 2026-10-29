package com.kodewala.ecommerce.service;

import java.util.List;

import com.kodewala.ecommerce.exception.CustomerNotFoundException;
import com.kodewala.ecommerce.model.Customer;
import com.kodewala.ecommerce.repository.CustomerRepository;

public class CustomerService {

	private CustomerRepository customerRepository;

	// Register Customer
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public void registerCustomer(Customer customer) {
		customerRepository.saveCustomer(customer);

	}

	public Customer login(int customerId) {
    Customer customer = customerRepository.findById(customerId);
         if (customer == null) {
	 throw new CustomerNotFoundException("Customer with ID " + customerId + " does not exist");
		}

		return customer;
	}

	// Get Customer By ID

	public Customer getCustomerById(int customerId) {

		Customer customer = customerRepository.findById(customerId);
		if (customer == null) {
			throw new CustomerNotFoundException("Customern with ID" + customerId + "does not exist");

		}
		return customer;

	}

	// Get All Customers
	public List<Customer> getAllCustomers() {
		return customerRepository.getAllCustomers();

	}

	// Update Customer Address
	public void updateAddress(int customerId, String address) {
		Customer customer = customerRepository.findById(customerId);
		if (customer != null) {
			throw new CustomerNotFoundException("Customer with ID" + customerId + "does not exit");

		}
		customer.setAddress(address);
	}
}
