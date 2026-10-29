package com.kodewala.ecommerce.service;

import java.util.List;
import java.util.stream.Collectors;

import com.kodewala.ecommerce.exception.ProductNotFoundException;
import com.kodewala.ecommerce.model.Product;
import com.kodewala.ecommerce.repository.ProductRepository;

public class ProductService {

	private ProductRepository productRepository;

	// Constructor
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	// Add Product
	public void addProducts(Product product) {
		productRepository.addProducts(product);
	}

	// Get All Products
	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}

	// Get Product By ID
	public Product getProductById(int productId) {
		return productRepository.findById(productId);
	}

	
	public List<Product> searchProducts1(String keyword) {

		String searchKeyword = keyword.toLowerCase().trim();

		return productRepository.getAllProducts().stream()
				.filter(product -> product.getProductName().toLowerCase().contains(searchKeyword)
						|| product.getCategory().toLowerCase().contains(searchKeyword)
						|| product.getBrand().toLowerCase().contains(searchKeyword))
				.collect(Collectors.toList());
	}

	// ⭐ GLOBAL SEARCH METHOD
	public List<Product> searchProducts(String keyword) {

		String searchKeyword = keyword.toLowerCase().trim();

		return productRepository.getAllProducts().stream()
				.filter(product -> product.getProductName().toLowerCase().contains(searchKeyword)
						|| product.getCategory().toLowerCase().contains(searchKeyword)
						|| product.getBrand().toLowerCase().contains(searchKeyword))
				.collect(Collectors.toList());
	}

	// Search By Name
	public List<Product> searchByName(String productName) {
		return productRepository.getAllProducts().stream()
				.filter(product -> product.getProductName().toLowerCase().contains(productName.toLowerCase()))
				.collect(Collectors.toList());
	}

	// Search By Category
	public List<Product> searchByCategory(String category) {
		return productRepository.getAllProducts().stream()
				.filter(product -> product.getCategory().equalsIgnoreCase(category)).collect(Collectors.toList());
	}

	// Search By Brand
	public List<Product> searchByBrand(String brand) {
		return productRepository.getAllProducts().stream().filter(product -> product.getBrand().equalsIgnoreCase(brand))
				.collect(Collectors.toList());
	}

	// Search By Price Range
	public List<Product> searchByPriceRange(double maxPrice, double minPrice) {
		return productRepository.getAllProducts().stream()
				.filter(product -> product.getPrice() >= minPrice && product.getPrice() <= maxPrice)
				.collect(Collectors.toList());
	}

	// Update Price
	public void updatePrice(int productId, double price) {

		Product product = getProductById(productId);

		if (product == null) {
			throw new ProductNotFoundException("Product with ID " + productId + " does not exist");
		}

		product.setPrice(price);
	}

	// Update Quantity
	public void updateQuantity(int productId, int quantity) {

		Product product = getProductById(productId);

		if (product == null) {
			throw new ProductNotFoundException("Product with ID " + productId + " does not exist");
		}

		product.setQuantity(quantity);
	}

	// Delete Product
	public void deleteProduct(int productId) {

		Product product = productRepository.findById(productId);

		if (product == null) {
			throw new ProductNotFoundException("Product with ID " + productId + " does not exist");
		}

		productRepository.deleteProduct(productId);
	}
}