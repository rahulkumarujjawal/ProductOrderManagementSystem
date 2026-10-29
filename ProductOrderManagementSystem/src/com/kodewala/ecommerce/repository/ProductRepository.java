package com.kodewala.ecommerce.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.kodewala.ecommerce.model.Product;

public class ProductRepository {
	private List<Product> products = new ArrayList<Product>();
	
	public ProductRepository() {

	    // =========================
	    // ELECTRONICS - 20
	    // =========================

	    products.add(new Product(101, "iPhone 16", "Electronics", 80000, 10, "Apple"));
	    products.add(new Product(102, "Samsung Galaxy S25", "Electronics", 70000, 15, "Samsung"));
	    products.add(new Product(103, "OnePlus 13", "Electronics", 65000, 12, "OnePlus"));
	    products.add(new Product(104, "Google Pixel 9", "Electronics", 75000, 8, "Google"));
	    products.add(new Product(105, "iPad Air", "Electronics", 60000, 10, "Apple"));
	    products.add(new Product(106, "Samsung Tablet", "Electronics", 35000, 12, "Samsung"));
	    products.add(new Product(107, "Sony Headphones", "Electronics", 12000, 20, "Sony"));
	    products.add(new Product(108, "JBL Earbuds", "Electronics", 5000, 25, "JBL"));
	    products.add(new Product(109, "Boat Bluetooth Speaker", "Electronics", 3500, 30, "Boat"));
	    products.add(new Product(110, "Sony Smart TV", "Electronics", 55000, 7, "Sony"));
	    products.add(new Product(111, "LG Smart TV", "Electronics", 48000, 9, "LG"));
	    products.add(new Product(112, "Canon Camera", "Electronics", 65000, 6, "Canon"));
	    products.add(new Product(113, "Nikon Camera", "Electronics", 70000, 5, "Nikon"));
	    products.add(new Product(114, "GoPro Camera", "Electronics", 40000, 8, "GoPro"));
	    products.add(new Product(115, "Apple Watch", "Electronics", 45000, 10, "Apple"));
	    products.add(new Product(116, "Samsung Smart Watch", "Electronics", 25000, 15, "Samsung"));
	    products.add(new Product(117, "Amazon Echo", "Electronics", 9000, 18, "Amazon"));
	    products.add(new Product(118, "Kindle", "Electronics", 13000, 12, "Amazon"));
	    products.add(new Product(119, "Power Bank", "Electronics", 2000, 30, "Mi"));
	    products.add(new Product(120, "Wireless Charger", "Electronics", 2500, 25, "Anker"));


	    // =========================
	    // FASHION - 20
	    // =========================

	    products.add(new Product(121, "Men T-Shirt", "Fashion", 799, 30, "Puma"));
	    products.add(new Product(122, "Women T-Shirt", "Fashion", 699, 25, "Nike"));
	    products.add(new Product(123, "Men Jeans", "Fashion", 1999, 20, "Levis"));
	    products.add(new Product(124, "Women Jeans", "Fashion", 2299, 18, "Levis"));
	    products.add(new Product(125, "Men Shoes", "Fashion", 2999, 15, "Nike"));
	    products.add(new Product(126, "Women Shoes", "Fashion", 2499, 18, "Adidas"));
	    products.add(new Product(127, "Men Jacket", "Fashion", 3499, 12, "Puma"));
	    products.add(new Product(128, "Women Jacket", "Fashion", 3999, 10, "H&M"));
	    products.add(new Product(129, "Men Shirt", "Fashion", 1499, 25, "Peter England"));
	    products.add(new Product(130, "Women Kurti", "Fashion", 1299, 20, "Biba"));
	    products.add(new Product(131, "Men Shorts", "Fashion", 999, 25, "Nike"));
	    products.add(new Product(132, "Women Skirt", "Fashion", 1199, 20, "Zara"));
	    products.add(new Product(133, "Men Hoodie", "Fashion", 1799, 15, "Puma"));
	    products.add(new Product(134, "Women Hoodie", "Fashion", 1899, 15, "H&M"));
	    products.add(new Product(135, "Sports Shoes", "Fashion", 3499, 12, "Adidas"));
	    products.add(new Product(136, "Formal Shoes", "Fashion", 2799, 14, "Bata"));
	    products.add(new Product(137, "Sunglasses", "Fashion", 1499, 20, "RayBan"));
	    products.add(new Product(138, "Leather Belt", "Fashion", 899, 25, "Allen Solly"));
	    products.add(new Product(139, "Leather Wallet", "Fashion", 999, 30, "WildHorn"));
	    products.add(new Product(140, "Cap", "Fashion", 499, 35, "Nike"));


	    // =========================
	    // HOME & KITCHEN - 20
	    // =========================

	    products.add(new Product(141, "Mixer Grinder", "Home & Kitchen", 2999, 15, "Philips"));
	    products.add(new Product(142, "Electric Kettle", "Home & Kitchen", 1499, 20, "Prestige"));
	    products.add(new Product(143, "Cookware Set", "Home & Kitchen", 3999, 10, "Prestige"));
	    products.add(new Product(144, "Pressure Cooker", "Home & Kitchen", 1999, 18, "Hawkins"));
	    products.add(new Product(145, "Dining Table", "Home & Kitchen", 18000, 5, "Woodland"));
	    products.add(new Product(146, "Office Chair", "Home & Kitchen", 8500, 8, "Green Soul"));
	    products.add(new Product(147, "Table Lamp", "Home & Kitchen", 1299, 20, "Philips"));
	    products.add(new Product(148, "Floor Lamp", "Home & Kitchen", 2499, 12, "IKEA"));
	    products.add(new Product(149, "Sofa Set", "Home & Kitchen", 35000, 4, "Urban Ladder"));
	    products.add(new Product(150, "Bookshelf", "Home & Kitchen", 7000, 8, "IKEA"));
	    products.add(new Product(151, "Bedside Table", "Home & Kitchen", 4500, 10, "Wakefit"));
	    products.add(new Product(152, "Bedsheet", "Home & Kitchen", 999, 25, "Bombay Dyeing"));
	    products.add(new Product(153, "Curtains", "Home & Kitchen", 1499, 20, "Home Centre"));
	    products.add(new Product(154, "Dinner Set", "Home & Kitchen", 2499, 15, "Milton"));
	    products.add(new Product(155, "Water Bottle", "Home & Kitchen", 699, 30, "Milton"));
	    products.add(new Product(156, "Lunch Box", "Home & Kitchen", 599, 35, "Cello"));
	    products.add(new Product(157, "Air Fryer", "Home & Kitchen", 6999, 8, "Philips"));
	    products.add(new Product(158, "Toaster", "Home & Kitchen", 1999, 12, "Morphy Richards"));
	    products.add(new Product(159, "Induction Cooktop", "Home & Kitchen", 2499, 15, "Prestige"));
	    products.add(new Product(160, "Vacuum Cleaner", "Home & Kitchen", 7999, 7, "Eureka"));


	    // =========================
	    // BOOKS - 20
	    // =========================

	    products.add(new Product(161, "Core Java Book", "Books", 799, 30, "S.Chand"));
	    products.add(new Product(162, "Java Programming", "Books", 999, 25, "McGraw Hill"));
	    products.add(new Product(163, "Effective Java", "Books", 1200, 15, "Pearson"));
	    products.add(new Product(164, "DSA Book", "Books", 899, 30, "McGraw Hill"));
	    products.add(new Product(165, "Data Structures in Java", "Books", 1099, 20, "Pearson"));
	    products.add(new Product(166, "Spring Boot Book", "Books", 1299, 18, "Packt"));
	    products.add(new Product(167, "Microservices Book", "Books", 1499, 15, "Packt"));
	    products.add(new Product(168, "SQL Book", "Books", 799, 25, "McGraw Hill"));
	    products.add(new Product(169, "Database Management", "Books", 999, 20, "Pearson"));
	    products.add(new Product(170, "System Design Book", "Books", 1599, 12, "OReilly"));
	    products.add(new Product(171, "Clean Code", "Books", 1199, 20, "Pearson"));
	    products.add(new Product(172, "Design Patterns", "Books", 1399, 15, "Pearson"));
	    products.add(new Product(173, "Python Programming", "Books", 899, 25, "BPB"));
	    products.add(new Product(174, "JavaScript Guide", "Books", 799, 20, "Packt"));
	    products.add(new Product(175, "Machine Learning Book", "Books", 1499, 15, "McGraw Hill"));
	    products.add(new Product(176, "Operating System Book", "Books", 999, 18, "Pearson"));
	    products.add(new Product(177, "Computer Networks", "Books", 1099, 20, "Pearson"));
	    products.add(new Product(178, "Novel - The Alchemist", "Books", 399, 30, "HarperCollins"));
	    products.add(new Product(179, "Novel - Harry Potter", "Books", 699, 25, "Bloomsbury"));
	    products.add(new Product(180, "Interview Preparation Book", "Books", 599, 30, "Arihant"));


	    // =========================
	    // BEAUTY & PERSONAL CARE - 20
	    // =========================

	    products.add(new Product(181, "Shampoo", "Beauty & Personal Care", 399, 30, "Dove"));
	    products.add(new Product(182, "Conditioner", "Beauty & Personal Care", 449, 25, "Dove"));
	    products.add(new Product(183, "Face Wash", "Beauty & Personal Care", 299, 35, "Nivea"));
	    products.add(new Product(184, "Face Cream", "Beauty & Personal Care", 499, 30, "Ponds"));
	    products.add(new Product(185, "Moisturizer", "Beauty & Personal Care", 599, 25, "Nivea"));
	    products.add(new Product(186, "Sunscreen", "Beauty & Personal Care", 699, 20, "Neutrogena"));
	    products.add(new Product(187, "Perfume", "Beauty & Personal Care", 1499, 15, "Fogg"));
	    products.add(new Product(188, "Deodorant", "Beauty & Personal Care", 399, 30, "Nivea"));
	    products.add(new Product(189, "Body Lotion", "Beauty & Personal Care", 449, 25, "Vaseline"));
	    products.add(new Product(190, "Body Wash", "Beauty & Personal Care", 499, 20, "Nivea"));
	    products.add(new Product(191, "Lip Balm", "Beauty & Personal Care", 199, 35, "Nivea"));
	    products.add(new Product(192, "Hair Oil", "Beauty & Personal Care", 299, 30, "Parachute"));
	    products.add(new Product(193, "Hair Serum", "Beauty & Personal Care", 699, 20, "L'Oreal"));
	    products.add(new Product(194, "Beard Oil", "Beauty & Personal Care", 499, 20, "Beardo"));
	    products.add(new Product(195, "Shaving Cream", "Beauty & Personal Care", 249, 30, "Gillette"));
	    products.add(new Product(196, "Razor", "Beauty & Personal Care", 399, 25, "Gillette"));
	    products.add(new Product(197, "Makeup Kit", "Beauty & Personal Care", 1999, 10, "Maybelline"));
	    products.add(new Product(198, "Lipstick", "Beauty & Personal Care", 599, 25, "Lakme"));
	    products.add(new Product(199, "Nail Polish", "Beauty & Personal Care", 299, 30, "Lakme"));
	    products.add(new Product(200, "Makeup Brush Set", "Beauty & Personal Care", 799, 15, "Swiss Beauty"));


	    // =========================
	    // GROCERY - 20
	    // =========================

	    products.add(new Product(201, "Rice 5kg", "Grocery", 499, 30, "India Gate"));
	    products.add(new Product(202, "Basmati Rice 5kg", "Grocery", 699, 25, "Daawat"));
	    products.add(new Product(203, "Sunflower Oil 1L", "Grocery", 149, 40, "Fortune"));
	    products.add(new Product(204, "Groundnut Oil 1L", "Grocery", 179, 35, "Fortune"));
	    products.add(new Product(205, "Wheat Flour 5kg", "Grocery", 299, 30, "Aashirvaad"));
	    products.add(new Product(206, "Sugar 5kg", "Grocery", 249, 35, "Madhur"));
	    products.add(new Product(207, "Salt 1kg", "Grocery", 30, 50, "Tata"));
	    products.add(new Product(208, "Tea 500g", "Grocery", 299, 30, "Tata"));
	    products.add(new Product(209, "Coffee 200g", "Grocery", 249, 30, "Nescafe"));
	    products.add(new Product(210, "Biscuits", "Grocery", 100, 50, "Parle"));
	    products.add(new Product(211, "Cookies", "Grocery", 150, 40, "Britannia"));
	    products.add(new Product(212, "Maggi", "Grocery", 150, 40, "Nestle"));
	    products.add(new Product(213, "Corn Flakes", "Grocery", 299, 25, "Kelloggs"));
	    products.add(new Product(214, "Oats", "Grocery", 199, 30, "Quaker"));
	    products.add(new Product(215, "Turmeric Powder", "Grocery", 120, 40, "Everest"));
	    products.add(new Product(216, "Chilli Powder", "Grocery", 130, 40, "MDH"));
	    products.add(new Product(217, "Garam Masala", "Grocery", 150, 35, "Everest"));
	    products.add(new Product(218, "Dry Fruits", "Grocery", 799, 15, "Happilo"));
	    products.add(new Product(219, "Peanut Butter", "Grocery", 299, 20, "Pintola"));
	    products.add(new Product(220, "Honey", "Grocery", 399, 20, "Dabur"));


	    // =========================
	    // SPORTS & FITNESS - 20
	    // =========================

	    products.add(new Product(221, "Cricket Bat", "Sports & Fitness", 2999, 15, "SG"));
	    products.add(new Product(222, "Cricket Ball", "Sports & Fitness", 499, 30, "SS"));
	    products.add(new Product(223, "Cricket Gloves", "Sports & Fitness", 1299, 20, "SG"));
	    products.add(new Product(224, "Football", "Sports & Fitness", 999, 25, "Nivia"));
	    products.add(new Product(225, "Football Shoes", "Sports & Fitness", 2499, 15, "Adidas"));
	    products.add(new Product(226, "Basketball", "Sports & Fitness", 1199, 20, "Spalding"));
	    products.add(new Product(227, "Tennis Racket", "Sports & Fitness", 1999, 12, "Yonex"));
	    products.add(new Product(228, "Tennis Ball", "Sports & Fitness", 399, 30, "Wilson"));
	    products.add(new Product(229, "Badminton Racket", "Sports & Fitness", 1499, 20, "Yonex"));
	    products.add(new Product(230, "Badminton Shuttle", "Sports & Fitness", 499, 30, "Yonex"));
	    products.add(new Product(231, "Dumbbells", "Sports & Fitness", 1999, 15, "Kore"));
	    products.add(new Product(232, "Yoga Mat", "Sports & Fitness", 799, 25, "Boldfit"));
	    products.add(new Product(233, "Skipping Rope", "Sports & Fitness", 399, 30, "Boldfit"));
	    products.add(new Product(234, "Gym Gloves", "Sports & Fitness", 599, 25, "Nivia"));
	    products.add(new Product(235, "Resistance Band", "Sports & Fitness", 499, 30, "Boldfit"));
	    products.add(new Product(236, "Treadmill", "Sports & Fitness", 35000, 5, "PowerMax"));
	    products.add(new Product(237, "Exercise Cycle", "Sports & Fitness", 18000, 6, "Reach"));
	    products.add(new Product(238, "Kettlebell", "Sports & Fitness", 2499, 12, "Kore"));
	    products.add(new Product(239, "Protein Shaker", "Sports & Fitness", 499, 25, "Boldfit"));
	    products.add(new Product(240, "Fitness Tracker", "Sports & Fitness", 2999, 15, "Fitbit"));


	    // =========================
	    // TOYS & GAMES - 20
	    // =========================

	    products.add(new Product(241, "Remote Car", "Toys & Games", 1299, 20, "Hot Wheels"));
	    products.add(new Product(242, "Toy Train", "Toys & Games", 999, 20, "Funskool"));
	    products.add(new Product(243, "Chess Set", "Toys & Games", 599, 30, "StonKraft"));
	    products.add(new Product(244, "Ludo Board", "Toys & Games", 299, 35, "Funskool"));
	    products.add(new Product(245, "Carrom Board", "Toys & Games", 2499, 10, "Synco"));
	    products.add(new Product(246, "Monopoly Game", "Toys & Games", 1999, 15, "Hasbro"));
	    products.add(new Product(247, "Scrabble", "Toys & Games", 1299, 18, "Mattel"));
	    products.add(new Product(248, "Building Blocks", "Toys & Games", 799, 25, "Lego"));
	    products.add(new Product(249, "Lego City Set", "Toys & Games", 2999, 12, "Lego"));
	    products.add(new Product(250, "Toy Gun", "Toys & Games", 499, 25, "Funskool"));
	    products.add(new Product(251, "Doll", "Toys & Games", 899, 20, "Barbie"));
	    products.add(new Product(252, "Teddy Bear", "Toys & Games", 699, 25, "Hamleys"));
	    products.add(new Product(253, "Remote Helicopter", "Toys & Games", 1999, 12, "Syma"));
	    products.add(new Product(254, "Puzzle Game", "Toys & Games", 399, 30, "Funskool"));
	    products.add(new Product(255, "Rubik Cube", "Toys & Games", 299, 35, "Rubik"));
	    products.add(new Product(256, "Board Game", "Toys & Games", 999, 20, "Funskool"));
	    products.add(new Product(257, "Toy Kitchen Set", "Toys & Games", 1199, 15, "Funskool"));
	    products.add(new Product(258, "Toy Doctor Set", "Toys & Games", 899, 18, "Funskool"));
	    products.add(new Product(259, "Remote Robot", "Toys & Games", 2499, 10, "Robobloq"));
	    products.add(new Product(260, "Magic Kit", "Toys & Games", 499, 25, "Funskool"));


	    // =========================
	    // COMPUTERS & ACCESSORIES - 20
	    // =========================

	    products.add(new Product(261, "Mechanical Keyboard", "Computers & Accessories", 2999, 20, "Redragon"));
	    products.add(new Product(262, "Wireless Keyboard", "Computers & Accessories", 1499, 25, "Logitech"));
	    products.add(new Product(263, "Wireless Mouse", "Computers & Accessories", 999, 30, "Logitech"));
	    products.add(new Product(264, "Gaming Mouse", "Computers & Accessories", 1999, 20, "Razer"));
	    products.add(new Product(265, "Gaming Keyboard", "Computers & Accessories", 3999, 15, "Razer"));
	    products.add(new Product(266, "24 Inch Monitor", "Computers & Accessories", 12000, 12, "Dell"));
	    products.add(new Product(267, "27 Inch Monitor", "Computers & Accessories", 18000, 10, "LG"));
	    products.add(new Product(268, "32 Inch Monitor", "Computers & Accessories", 25000, 8, "Samsung"));
	    products.add(new Product(269, "1TB SSD", "Computers & Accessories", 6999, 15, "Samsung"));
	    products.add(new Product(270, "512GB SSD", "Computers & Accessories", 3999, 20, "Crucial"));
	    products.add(new Product(271, "1TB Hard Disk", "Computers & Accessories", 4999, 15, "WD"));
	    products.add(new Product(272, "USB Hub", "Computers & Accessories", 999, 25, "TP-Link"));
	    products.add(new Product(273, "Webcam", "Computers & Accessories", 1999, 20, "Logitech"));
	    products.add(new Product(274, "Laptop Stand", "Computers & Accessories", 1299, 25, "Portronics"));
	    products.add(new Product(275, "Cooling Pad", "Computers & Accessories", 999, 20, "Zebronics"));
	    products.add(new Product(276, "HDMI Cable", "Computers & Accessories", 499, 35, "AmazonBasics"));
	    products.add(new Product(277, "Ethernet Cable", "Computers & Accessories", 299, 40, "TP-Link"));
	    products.add(new Product(278, "WiFi Router", "Computers & Accessories", 2499, 15, "TP-Link"));
	    products.add(new Product(279, "Printer", "Computers & Accessories", 8999, 8, "HP"));
	    products.add(new Product(280, "USB Flash Drive", "Computers & Accessories", 699, 30, "SanDisk"));


	    // =========================
	    // AUTOMOTIVE - 20
	    // =========================

	    products.add(new Product(281, "Car Seat Cover", "Automotive", 2999, 15, "AutoFurnish"));
	    products.add(new Product(282, "Car Floor Mat", "Automotive", 1999, 20, "3D Mats"));
	    products.add(new Product(283, "Car Phone Holder", "Automotive", 699, 25, "Portronics"));
	    products.add(new Product(284, "Car Air Freshener", "Automotive", 299, 35, "Godrej"));
	    products.add(new Product(285, "Car Vacuum Cleaner", "Automotive", 2499, 12, "Black+Decker"));
	    products.add(new Product(286, "Car Cleaning Kit", "Automotive", 999, 20, "Wavex"));
	    products.add(new Product(287, "Bike Cover", "Automotive", 699, 25, "Rynox"));
	    products.add(new Product(288, "Car Cover", "Automotive", 1499, 20, "AmazonBasics"));
	    products.add(new Product(289, "Bike Helmet", "Automotive", 1999, 15, "Vega"));
	    products.add(new Product(290, "Car Helmet", "Automotive", 2499, 12, "Studds"));
	    products.add(new Product(291, "Engine Oil 1L", "Automotive", 599, 30, "Castrol"));
	    products.add(new Product(292, "Engine Oil 4L", "Automotive", 1999, 20, "Mobil"));
	    products.add(new Product(293, "Bike Engine Oil", "Automotive", 499, 25, "Motul"));
	    products.add(new Product(294, "Car Polish", "Automotive", 399, 30, "3M"));
	    products.add(new Product(295, "Tyre Inflator", "Automotive", 1999, 15, "AmazonBasics"));
	    products.add(new Product(296, "Car Jumper Cable", "Automotive", 899, 20, "Michelin"));
	    products.add(new Product(297, "LED Headlight", "Automotive", 2499, 12, "Philips"));
	    products.add(new Product(298, "Bike LED Light", "Automotive", 999, 20, "Hella"));
	    products.add(new Product(299, "Car Dashboard Camera", "Automotive", 5999, 10, "70mai"));
	    products.add(new Product(300, "Car Emergency Kit", "Automotive", 1499, 15, "AutoSafe"));
	}
	

	// add Product
	public void addProducts(Product _product) {
		products.add(_product);

	}

	public List<Product> getAllProducts() {
		return products;
	}

 // find by Product Id
	public Product findById(int productId) {
		
		for (Product product : products) {
			if (product.getProductId() == productId) {
				return product;
			}
		}
		return null;
	}

	// deleteProduct
	public void deleteProduct(int productId) {
		Product product = findById(productId);
		if (product != null) {
			products.remove(product);
		}
	}

	// Update Product
	public void updateProduct(Product updateProduct) {
		Product existingProduct = findById(updateProduct.getProductId());
		if (existingProduct != null) {

			existingProduct.setProductName(updateProduct.getProductName());
			existingProduct.setCategory(updateProduct.getCategory());
			existingProduct.setPrice(updateProduct.getPrice());
			existingProduct.setQuantity(updateProduct.getQuantity());
			existingProduct.setBrand(updateProduct.getBrand());
		}
	}
}

/*
 * this is a repository class --> this class responsibility: for Product data-->
 * ↓ Store Find  add ,Update, Delete Retrieve
 * 
 */
