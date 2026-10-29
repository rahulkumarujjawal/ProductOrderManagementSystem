package com.kodewala.ecommerce.main;

import java.util.List;
import java.util.Scanner;

import com.kodewala.ecommerce.exception.CustomerNotFoundException;
import com.kodewala.ecommerce.model.CartItem;
import com.kodewala.ecommerce.model.Customer;
import com.kodewala.ecommerce.model.Order;
import com.kodewala.ecommerce.model.Product;
import com.kodewala.ecommerce.repository.CustomerRepository;
import com.kodewala.ecommerce.repository.OrderRepository;
import com.kodewala.ecommerce.repository.ProductRepository;
import com.kodewala.ecommerce.service.CartService;
import com.kodewala.ecommerce.service.CustomerService;
import com.kodewala.ecommerce.service.OrderService;
import com.kodewala.ecommerce.service.ProductService;

public class EcommerceApplicationDriver {

	public static void printMainMenu() {
		
		System.out.println();
		System.out.println("┌──────────────────────────────────────────────────────────────┐");
		System.out.println("│                 E-COMMERCE APPLICATION                       │");
		System.out.println("├──────────────────────────────────────────────────────────────┤");
		System.out.println("│                         MAIN MENU                            │");
		System.out.println("├──────────────────────────────────────────────────────────────┤");
		System.out.println("│                                                              │");
		System.out.println("│[1]👨‍💼  Admin                                                  │");
		System.out.println("│[2]🛍️  Customer                                               │");
		System.out.println("│[3]🚪  Exit                                                   │");
		System.out.println("│                                                              │");
		System.out.println("└──────────────────────────────────────────────────────────────┘");
	}

	public static void printAdminMenu() {
		System.out.println();
		System.out.println("┌──────────────────────────────────────────────────────────────┐");
		System.out.println("│                        ADMIN MENU                            │");
		System.out.println("├──────────────────────────────────────────────────────────────┤");
		System.out.println("│                                                              │");
		System.out.println("│   [1] Add Product                                            │");
		System.out.println("│   [2] View Products                                          │");
		System.out.println("│   [3] Search Product                                         │");
		System.out.println("│   [4] Update Product                                         │");
		System.out.println("│   [5] Delete Product                                         │");
		System.out.println("│   [6] View Customers                                         │");
		System.out.println("│   [7] View All Orders                                        │");
		System.out.println("│   [8] Exit                                                   │");
		System.out.println("│                                                              │");
		System.out.println("└──────────────────────────────────────────────────────────────┘");
	}

	public static void printCustomerMenu() {
		System.out.println();
		System.out.println("┌──────────────────────────────────────────────────────────────┐");
		System.out.println("│                      CUSTOMER MENU                           │");
		System.out.println("├──────────────────────────────────────────────────────────────┤");
		System.out.println("│                                                              │");
		System.out.println("│   [1] Register Customer                                      │");
		System.out.println("│   [2] Login                                                  │");
		System.out.println("│   [3] View Products                                          │");
		System.out.println("│   [4] Search Product                                         │");
		System.out.println("│   [5] Add Product to Cart                                    │");
		System.out.println("│   [6] View Cart                                              │");
		System.out.println("│   [7] Remove Product from Cart                               │");
		System.out.println("│   [8] Place Order                                            │");
		System.out.println("│   [9] View My Orders                                         │");
		System.out.println("│  [10] Cancel Order                                           │");
		System.out.println("│  [11] Logout                                                 │");
		System.out.println("│                                                              │");
		System.out.println("└──────────────────────────────────────────────────────────────┘");
	}

	public static void displayProducts(List<Product> products) {

		if (products.isEmpty()) {
			System.out.println("No products found.");
			return;
		}

		System.out.println();

		System.out.println("┌──────────────────────────────────────────────┐");
		System.out.println("│               SEARCH RESULTS                 │");
		System.out.println("└──────────────────────────────────────────────┘");

		for (Product product : products) {

			System.out.println("----------------------------------------------");
			System.out.println("Product ID   : " + product.getProductId());
			System.out.println("Product Name : " + product.getProductName());
			System.out.println("Category     : " + product.getCategory());
			System.out.println("Price        : " + product.getPrice());
			System.out.println("Quantity     : " + product.getQuantity());
			System.out.println("Brand        : " + product.getBrand());
		}

		System.out.println("----------------------------------------------");
	}

	public static void main(String[] args) {

		ProductRepository productRepository = new ProductRepository();
		CustomerRepository customerRepository = new CustomerRepository();
		OrderRepository orderRepository = new OrderRepository();

		CustomerService customerService = new CustomerService(customerRepository);
		CartService cartService = new CartService();
		ProductService productService = new ProductService(productRepository);

		OrderService orderService = new OrderService(orderRepository, productRepository, cartService);

		// Start Application

		System.out.println("┌──────────────────────────────────────────────┐");
		System.out.println("│          🛒 E-COMMERCE APPLICATION           │");
		System.out.println("└──────────────────────────────────────────────┘");

		Scanner scanner = new Scanner(System.in);

		while (true) {

			printMainMenu();

			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();

			switch (choice) {

			// ADMIN

			case 1:
				while (true) {

					printAdminMenu();

					System.out.print("Enter your choice: ");

					int adminChoice = scanner.nextInt();
					switch (adminChoice) {

					// 1. ADD PRODUCT

					case 1:

						System.out.print("Enter Product ID: ");
						int productId = scanner.nextInt();

						scanner.nextLine();

						System.out.print("Enter Product Name: ");
						String productName = scanner.nextLine();

						System.out.print("Enter Category: ");
						String category = scanner.nextLine();

						System.out.print("Enter Price: ");
						double price = scanner.nextDouble();

						System.out.print("Enter Quantity: ");
						int quantity = scanner.nextInt();

						scanner.nextLine();

						System.out.print("Enter Brand: ");
						String brand = scanner.nextLine();

						Product product = new Product(productId, productName, category, price, quantity, brand);

						productService.addProducts(product);
						System.out.println("Product added successfully.");

						break;

					// 2. VIEW PRODUCTS

					case 2:

						System.out.println();

						System.out.println("┌──────────────────────────────────────────────┐");
						System.out.println("│        ALL PRODUCTS                          │");
						System.out.println("└──────────────────────────────────────────────┘");

						if (productService.getAllProducts().isEmpty()) {

							System.out.println("No products available.");

						} else {

							for (Product product2 : productService.getAllProducts()) {

								System.out.println("----------------------------------------------");

								System.out.println("Product ID   : " + product2.getProductId());
								System.out.println("Product Name : " + product2.getProductName());
								System.out.println("Category     : " + product2.getCategory());
								System.out.println("Price        : ₹" + product2.getPrice());
								System.out.println("Quantity     : " + product2.getQuantity());
								System.out.println("Brand        : " + product2.getBrand());
							}

							System.out.println("----------------------------------------------");
						}

						break;

					// 3. SEARCH PRODUCT

					case 3:

						System.out.println();
						System.out.println("┌──────────────────────────────────────────────────────────────┐");
						System.out.println("│                      SEARCH PRODUCT                          │");
						System.out.println("├──────────────────────────────────────────────────────────────┤");
						System.out.println("│                                                              │");
						System.out.println("│   [1] Search By Name                                         │");
						System.out.println("│   [2] Search By Category                                     │");
						System.out.println("│   [3] Search By Brand                                        │");
						System.out.println("│   [4] Search By Price Range                                  │");
						System.out.println("│                                                              │");
						System.out.println("└──────────────────────────────────────────────────────────────┘");

						System.out.print("Enter your choice: ");

						int searchChoice = scanner.nextInt();

						scanner.nextLine();

						switch (searchChoice) {

						case 1:

							System.out.print("Enter product name: ");
							String productName1 = scanner.nextLine();
							List<Product> productsByName = productService.searchByName(productName1);
							displayProducts(productsByName);
							break;

						case 2:

							System.out.print("Enter category: ");
							String category1 = scanner.nextLine();
							List<Product> productsByCategory = productService.searchByCategory(category1);
							displayProducts(productsByCategory);
							break;

						case 3:

							System.out.print("Enter brand: ");
							String brand1 = scanner.nextLine();
							List<Product> productsByBrand = productService.searchByBrand(brand1);
							displayProducts(productsByBrand);
							break;

						case 4:

							System.out.print("Enter minimum price: ");
							double minimumPrice = scanner.nextDouble();
							System.out.print("Enter maximum price: ");
							double maximumPrice = scanner.nextDouble();
							List<Product> productsByPrice = productService.searchByPriceRange(minimumPrice,
									maximumPrice);
							displayProducts(productsByPrice);
							break;
						default:
							System.out.println("Invalid search choice.");
						}

						break;

					// 4. UPDATE PRODUCT

					case 4:

						System.out.println();
						System.out.println("┌──────────────────────────────────────────────────────────────┐");
						System.out.println("│                       UPDATE PRODUCT                         │");
						System.out.println("├──────────────────────────────────────────────────────────────┤");
						System.out.println("│                                                              │");
						System.out.println("│   [1] Update Price                                           │");
						System.out.println("│   [2] Update Quantity                                        │");
						System.out.println("│   [3] Update Price & Quantity                                │");
						System.out.println("│                                                              │");
						System.out.println("└──────────────────────────────────────────────────────────────┘");

						System.out.print("Enter your choice: ");

						int updateChoice = scanner.nextInt();

						switch (updateChoice) {

						case 1:

							System.out.print("Enter Product ID: ");

							int updatePriceProductId = scanner.nextInt();

							System.out.print("Enter New Price: ");

							double newPrice = scanner.nextDouble();

							productService.updatePrice(updatePriceProductId, newPrice);

							System.out.println("Product price updated successfully.");

							break;

						case 2:

							System.out.print("Enter Product ID: ");

							int updateQuantityProductId = scanner.nextInt();

							System.out.print("Enter New Quantity: ");

							int newQuantity = scanner.nextInt();

							productService.updateQuantity(updateQuantityProductId, newQuantity);

							System.out.println("Product quantity updated successfully.");

							break;

						case 3:

							System.out.print("Enter Product ID: ");
							int updateProductId = scanner.nextInt();
							System.out.print("Enter New Price: ");
							double updatedPrice = scanner.nextDouble();
							System.out.print("Enter New Quantity: ");
							int updatedQuantity = scanner.nextInt();
							productService.updatePrice(updateProductId, updatedPrice);
							productService.updateQuantity(updateProductId, updatedQuantity);
							System.out.println("Product price and quantity updated successfully.");
							break;

						default:
							System.out.println("Invalid update choice.");
						}

						break;

					// 5. DELETE PRODUCT

					case 5:

						System.out.println();
						System.out.println("==============================================");
						System.out.println("              DELETE PRODUCT");
						System.out.println("==============================================");

						System.out.print("Enter Product ID: ");
						int deleteProductId = scanner.nextInt();
						productService.deleteProduct(deleteProductId);
						System.out.println("Product deleted successfully.");
						break;
					// 6. VIEW CUSTOMERS

					case 6:

						System.out.println();
						System.out.println("==============================================");
						System.out.println("              ALL CUSTOMERS");
						System.out.println("==============================================");

						if (customerService.getAllCustomers().isEmpty()) {
							System.out.println("No customers registered.");

						} else {

							for (Customer customer : customerService.getAllCustomers()) {
								System.out.println("----------------------------------------------");
								System.out.println("Customer ID : " + customer.getCustomerId());
								System.out.println("Name        : " + customer.getName());
								System.out.println("Email       : " + customer.getEmail());
								System.out.println("Mobile      : " + customer.getMobile());
								System.out.println("Address     : " + customer.getAddress());
							}
							System.out.println("----------------------------------------------");
						}

						break;

					// 7. VIEW ALL ORDERS

					case 7:

						System.out.println();
						System.out.println("==============================================");
						System.out.println("              ALL ORDERS");
						System.out.println("==============================================");

						if (orderService.getAllOrders().isEmpty()) {
							System.out.println("No orders available.");

						} else {

							for (Order order : orderService.getAllOrders()) {

								System.out.println("----------------------------------------------");
								System.out.println("Order ID     : " + order.getOrderId());
								System.out.println("Customer ID  : " + order.getCustomerId());
								System.out.println("Order Date   : " + order.getOrderDate());
								System.out.println("Status       : " + order.getOrderStatus());
								System.out.println("GST Amount   : " + order.getGstAmount());
								System.out.println("Total Amount : " + order.getTotalAmount());
								System.out.println("Products:");

								for (CartItem item : order.getCartItems()) {

									System.out.println("  " + item.getProductName() + " | Quantity: "
											+ item.getQuantity() + " | Price: ₹" + item.getPrice() + " | Total: ₹"
											+ item.getTotalPrice());
								}
							}

							System.out.println("----------------------------------------------");
						}

						break;

					// 8. EXIT ADMIN

					case 8:
						System.out.println("Returning to Main Menu...");
						break;

					default:
						System.out.println("Invalid Admin Choice.");
					}

					if (adminChoice == 8) {
						break;
					}
				}

				break;

			// CUSTOMER
			case 2:

				while (true) {

					printCustomerMenu();

					System.out.print("Enter your choice: ");

					int customerChoice = scanner.nextInt();

					switch (customerChoice) {

					case 1:
						System.out.println();
						System.out.println("==============================================");
						System.out.println(" REGISTER CUSTOMER");
						System.out.println("==============================================");

						System.out.print("Enter Customer ID: ");
						int customerId = scanner.nextInt();
						scanner.nextLine();

						System.out.print("Enter Customer Name: ");
						String name = scanner.nextLine();

						System.out.print("Enter Email: ");
						String email = scanner.nextLine();

						System.out.print("Enter Mobile: ");
						String mobile = scanner.nextLine();

						System.out.print("Enter Address: ");
						String address = scanner.nextLine();

						Customer customer = new Customer(customerId, name, email, mobile, address);
						customerService.registerCustomer(customer);
						
						
						System.out.println();
						System.out.println("==================================================");
						System.out.println("           🎉 REGISTRATION SUCCESS 🎉             ");
						System.out.println("==================================================");
						System.out.println();
						System.out.println("        🛒 Thank you for joining our store!       ");
						System.out.println("        👤 Your account has been created.         ");
						System.out.println();
						System.out.println("              🛍️ HAPPY SHOPPING! 🛍️              ");
						System.out.println();
						System.out.println("==================================================");
						System.out.println();
						
						
						

						break;

					case 2:

						System.out.println();
						System.out.println("==============================================");
						System.out.println("              CUSTOMER LOGIN");
						System.out.println("==============================================");

						boolean loginSuccessful = false;

						for (int attempt = 1; attempt <= 3; attempt++) {
							System.out.print("Enter Customer ID: ");
							int loginCustomerId = scanner.nextInt();

							try {

								Customer loggedInCustomer = customerService.login(loginCustomerId);
								System.out.println();
								System.out.println("Login successful!");
								System.out.println("Welcome " + loggedInCustomer.getName());
								loginSuccessful = true;
								break;

							} catch (CustomerNotFoundException e) {

								System.out.println();
								System.out.println("❌ Customer not found.");
								System.out.println("Attempt " + attempt + " of 3");
								if (attempt == 3) {
									System.out.println();
									System.out.println("Returning to Main Menu...");
									customerChoice = 11;

								}
							}
						}

						break;

					case 3:
						System.out.println();
						System.out.println("==============================================");
						System.out.println(" ALL PRODUCTS  ");
						System.out.println("==============================================");

						List<Product> products = productService.getAllProducts();
						displayProducts(products);
						break;

					case 4:

						System.out.println();
						System.out.println("┌──────────────────────────────────────────────────────────────┐");
						System.out.println("│                      SEARCH PRODUCT                          │");
						System.out.println("├──────────────────────────────────────────────────────────────┤");
						System.out.println("│                                                              │");
						System.out.println("│   [1] Search By Name                                         │");
						System.out.println("│   [2] Search By Category                                     │");
						System.out.println("│   [3] Search By Brand                                        │");
						System.out.println("│   [4] Search By Price Range                                  │");
						System.out.println("│                                                              │");
						System.out.println("└──────────────────────────────────────────────────────────────┘");

						System.out.print("Enter your choice: ");
						int searchChoice = scanner.nextInt();
						scanner.nextLine();

						List<Product> searchResults;
						switch (searchChoice) {
						case 1:
							System.out.println("Enter Product Name: ");
							String searchName = scanner.nextLine();
							searchResults = productService.searchByName(searchName);
							displayProducts(searchResults);
							break;

						case 2:

							System.out.print("Enter Category: ");
							String searchCategory = scanner.nextLine();
							searchResults = productService.searchByCategory(searchCategory);
							displayProducts(searchResults);
							break;

						case 3:
							System.out.print("Enter Brand: ");
							String searchBrand = scanner.nextLine();
							searchResults = productService.searchByBrand(searchBrand);
							displayProducts(searchResults);
							break;

						case 4:
							System.out.print("Enter Minimum Price: ");
							double minimumPrice = scanner.nextDouble();
							System.out.print("Enter Maximum Price: ");
							double maximumPrice = scanner.nextDouble();
							searchResults = productService.searchByPriceRange(minimumPrice, maximumPrice);

							displayProducts(searchResults);
							break;

						default:
							System.out.println("Invalid Search Choice");
						}
						break;

					case 5:

						System.out.println();
						System.out.println("==============================================");
						System.out.println(" ADD PRODUCT TO CART");
						System.out.println("==============================================");

						System.out.print("Enter Customer ID: ");
						int cartCustomerId = scanner.nextInt();

						System.out.print("Enter Product ID: ");
						int cartProductId = scanner.nextInt();

						System.out.print("Enter Quantity: ");
						int cartQuantity = scanner.nextInt();
						Product cartProduct = productService.getProductById(cartProductId);
						cartService.addToCart(cartCustomerId, cartProduct, cartQuantity);
						System.out.println();
						System.out.println("Product Added to cart Sucessfuly");
						break;

					case 6:

						System.out.println();
						System.out.println("==============================================");
						System.out.println("                MY CART");
						System.out.println("==============================================");

						System.out.print("Enter Customer ID: ");
						int viewCartCustomerId = scanner.nextInt();

						List<CartItem> cartItems = cartService.getCart(viewCartCustomerId);
						if (cartItems.isEmpty()) {
							System.out.println("Your cart is empty.");
						} else {

							System.out.println();
							System.out.println("--------------- CART ITEMS ----------------");

							for (CartItem cartItem : cartItems) {

								System.out.println("Product ID   : " + cartItem.getProductId());
								System.out.println("Product Name : " + cartItem.getProductName());
								System.out.println("Price        : " + cartItem.getPrice());
								System.out.println("Quantity     : " + cartItem.getQuantity());
								System.out.println("Total Price  : " + cartItem.getTotalPrice());

								System.out.println("--------------------------------------------");
							}

							double totalPrice = cartService.calculateCartSubtotal(viewCartCustomerId);
							System.out.println("Cart Subtotal : " + totalPrice);

						}

						break;
					case 7:

						System.out.println();
						System.out.println("==============================================");
						System.out.println("          REMOVE PRODUCT FROM CART");
						System.out.println("==============================================");

						System.out.print("Enter Customer ID: ");
						int removeCustomerId = scanner.nextInt();

						System.out.print("Enter Product ID: ");
						int removeProductId = scanner.nextInt();

						cartService.removeFromCart(removeCustomerId, removeProductId);

						System.out.println();
						System.out.println("Product removed from cart successfully.");

						break;

					case 8:

						System.out.println();
						System.out.println("==============================================");
						System.out.println("                PLACE ORDER");
						System.out.println("==============================================");

						System.out.print("Enter Customer ID: ");
						int orderCustomerId = scanner.nextInt();

						Order order = orderService.placeOrder(orderCustomerId);

						System.out.println();
						System.out.println("Order placed successfully!");
						System.out.println("Order ID     : " + order.getOrderId());
						System.out.println("Customer ID  : " + order.getCustomerId());
						System.out.println("Order Date   : " + order.getOrderDate());
						System.out.println("Order Status : " + order.getOrderStatus());
						System.out.println("Total Amount : " + order.getTotalAmount());

						break;

					case 9:

						System.out.println();
						System.out.println("==============================================");
						System.out.println("                MY ORDERS");
						System.out.println("==============================================");

						System.out.print("Enter Customer ID: ");
						int myOrdersCustomerId = scanner.nextInt();

						List<Order> myOrders = orderService.getCustomerOrders(myOrdersCustomerId);

						if (myOrders.isEmpty()) {

							System.out.println("No orders found for this customer.");

						} else {

							for (Order orders : myOrders) {

								System.out.println();
								System.out.println("----------------------------------------------");
								System.out.println("Order ID     : " + orders.getOrderId());
								System.out.println("Customer ID  : " + orders.getCustomerId());
								System.out.println("Order Date   : " + orders.getOrderDate());
								System.out.println("Order Status : " + orders.getOrderStatus());
								System.out.println("Total Amount : " + orders.getTotalAmount());

								System.out.println("Items:");

								for (CartItem cartItem : orders.getCartItems()) {

									System.out.println("  Product : " + cartItem.getProductName() + " | Quantity : "
											+ cartItem.getQuantity() + " | Price : " + cartItem.getPrice());
								}

								System.out.println("----------------------------------------------");
							}
						}

						break;

					case 10:

						System.out.println();
						System.out.println("==============================================");
						System.out.println("                CANCEL ORDER");
						System.out.println("==============================================");

						System.out.print("Enter Order ID: ");
						int cancelOrderId = scanner.nextInt();

						try {
							orderService.cancelOrder(cancelOrderId);
							System.out.println();
							System.out.println("Order cancelled successfully.");
						} catch (IllegalArgumentException e) {
							System.out.println();
							System.out.println("Unable to cancel order.");
							System.out.println("Reason: " + e.getMessage());
						}

						break;

					case 11:

						System.out.println();
						System.out.println("==============================================");
						System.out.println(" CUSTOMER LOGOUT");
						System.out.println("==============================================");
						System.out.println("Customer logged out successfully.");
						System.out.println("Returning to Main Menu...");
						break;

					default:
						System.out.println("Invalid Customer Choice.");
					}
					if (customerChoice == 11) {
						break;
					}
				}
				break;
			// EXIT APPLICATION
			case 3:
				System.out.println("Thank you for using E-Commerce Application.");
				scanner.close();
				return;
			default:
				System.out.println("Invalid choice. Please try again.");

			}
		}
	}
}