# ProductOrderManagementSystem
🛒 Java 21 E-Commerce Product &amp; Order Management System | 👨‍💼 Admin &amp; 🛍️ Customer Modules | 📦 Product Management | 💳 Order Processing | 💰 GST &amp; Discounts | 🔄 Inventory Management | ☕ Core Java, OOP, Collections &amp; Stream API



# 🛒 E-Commerce Product & Order Management System

### A Core Java Project | Java 21 | Product Management | Shopping Cart | Order Processing

A console-based **E-Commerce Product & Order Management System** developed using Java 21. This application simulates the core functionalities of an online shopping platform, allowing administrators to manage products and customers to browse products, manage shopping carts, place orders, and track their order history.

The project focuses on practical implementation of Core Java, Object-Oriented Programming (OOP), Java Collections Framework, Stream API, exception handling, and real-world e-commerce business logic.

## 📌 Table of Contents

- 📖 Project Overview
- 🎯 Project Objectives
- ✨ Key Features
- 👨‍💼 Admin Module
- 🛍️ Customer Module
- 📦 Product Management
- 🛒 Shopping Cart Management
- 💳 Order Management
- 💰 Business Rules
- 🔄 Application Workflow
- 🏗️ Project Architecture
- 📂 Project Structure
- 🧰 Technologies Used
- 🧠 Core Java Concepts Implemented
- ⚙️ Installation and Setup
- ▶️ How to Run the Application
- 🧪 Sample Use Case
- 🚀 Future Enhancements
- 👨‍💻 Author

---

## 📖 Project Overview

The E-Commerce Product & Order Management System is designed to demonstrate how an online shopping application's core operations can be implemented using Core Java.

The application provides two primary modules:

**1. Admin Module:** Allows administrators to add, view, search, update, and delete products, view registered customers, and monitor customer orders.

**2. Customer Module:** Allows customers to register, log in, browse products, search for products, add items to a shopping cart, place orders, view order history, and cancel eligible orders.

The application also implements essential business rules such as stock validation, inventory updates, GST calculation, delivery charges, Wednesday discounts, and order status management.

The project follows a modular architecture by separating model classes, repository operations, service-layer business logic, exception handling, and application entry points.

## 🎯 Project Objectives

- Build a practical Java-based e-commerce application.
- Understand how Core Java concepts are used in real-world applications.
- Implement OOP principles through separate classes and responsibilities.
- Manage products, customers, carts, and orders.
- Use Java Collections to manage application data.
- Apply Stream API for product searching and filtering where appropriate.
- Implement validation and custom exception handling.
- Understand the complete order placement and inventory update workflow.
- Write modular, readable, and maintainable Java code.


## ✨ Key Features

| Module | Features |
|---|---|
| 👨‍💼 Admin | Add, view, search, update, and delete products |
| 👥 Customer | Registration and login |
| 🔍 Product Search | Search by name, category, brand, and price |
| 🛒 Shopping Cart | Add, view, and remove cart items |
| 📦 Order Processing | Place orders and view order history |
| 💰 Price Calculation | GST, delivery charges, and applicable discounts |
| 📉 Inventory | Validate stock and update product quantity |
| ❌ Cancellation | Cancel eligible orders according to business rules |
| ⚠️ Exception Handling | Handle insufficient stock and invalid operations |
| 💾 Data Storage | Local data files for the file-based version |

---
## 👨‍💼 Admin Module

The Admin Module manages products, customers, and orders.

### Admin Menu

1. ➕ Add Product
2. 📦 View Products
3. 🔍 Search Product
4. ✏️ Update Product
5. 🗑️ Delete Product
6. 👥 View Customers
7. 📋 View All Orders
8. 🚪 Exit

### Admin Responsibilities

- Add new products with details such as product ID, name, category, brand, price, and quantity.
- View the available product catalogue.
- Search for products using different criteria.
- Update product details when required.
- Delete products from the catalogue.
- View registered customer information.
- Review orders placed by customers.

**Example:** An administrator adds an iPhone with a price of ₹70,000 and a stock quantity of 10. Customers can then view and purchase the product if sufficient stock is available.

---

## 🛍️ Customer Module

The Customer Module provides the main shopping experience.

### Customer Menu

1. 📝 Register
2. 🔐 Login
3. 📦 View Products
4. 🔍 Search Product
5. 🛒 Add Product to Cart
6. 👀 View Cart
7. ➖ Remove Product from Cart
8. 💳 Place Order
9. 📋 View My Orders
10. ❌ Cancel Order
11. 🚪 Logout

### Customer Responsibilities

- Register as a new customer.
- Log in to access shopping operations.
- Browse and search available products.
- Add products to the shopping cart.
- Review cart items and the total amount.
- Remove items before checkout.
- Place orders after stock validation.
- View previous orders.
- Cancel orders when the cancellation rules permit it.
- Log out to end the customer session.
## 📦 Product Management

Product Management handles the product catalogue and its operations.

Each product contains information such as:

- Product ID
- Product Name
- Category
- Brand
- Price
- Available Quantity

### Product Search

Customers and administrators can search products using supported criteria:

- 🔎 Product name
- 🏷️ Category
- 🏢 Brand
- 💰 Price

**Example:** A customer searches for the Electronics category and views products available for purchase.

---

## 🛒 Shopping Cart Management

The shopping cart temporarily stores products selected by a customer before checkout.

### Cart Operations

- Add a product to the cart.
- View cart items and quantities.
- Remove a product from the cart.
- Calculate the cart subtotal.
- Proceed to checkout.

### Important Business Rule

**Adding a product to the cart does not reduce inventory.**

Stock is validated during order placement, and inventory is reduced only after the order has been successfully placed.

**Example:**

- Initial iPhone stock: 10
- Customer adds 2 iPhones to the cart.
- Available stock remains: 10
- Customer successfully places the order.
- Updated stock: 8

This approach avoids reducing inventory simply because a customer added an item to their cart.

---

## 💳 Order Management

Order Management handles the complete order lifecycle, from checkout to order history and cancellation.

### Order Placement Process

1. The customer selects Place Order.
2. The application retrieves the cart items.
3. The application validates product availability and requested quantities.
4. The subtotal is calculated.
5. Applicable discounts are calculated.
6. GST and delivery charges are calculated according to the business rules.
7. The final order amount is calculated.
8. Inventory is reduced after successful order placement.
9. The order is saved with its details and status.
10. The cart is cleared after successful checkout.

### Order Information

An order can contain:

- Order ID
- Customer ID
- Cart items
- Total amount
- GST amount
- Order date
- Order status

### Order Status Management

The application uses order statuses to represent an order's current state.

- PLACED — Order has been placed.
- CONFIRMED — Order has been confirmed.
- `SHIPPED` — Order has been shipped.
- `DELIVERED` — Order has been delivered.
- `CANCELLED` — Order has been cancelled.

The available status transitions depend on the operations implemented in the application.

### Order Cancellation Rules

- If an order does not exist, display an appropriate error.
- If an order is already cancelled, do not cancel it again.
- A delivered order cannot be cancelled.
- Otherwise, change the order status to `CANCELLED`, subject to the application's cancellation rules.

---

## 💰 Business Rules and Price Calculation

The application demonstrates real-world pricing logic commonly found in e-commerce systems.

### 1. GST Calculation

The application uses an 18% GST rate.

**Formula:**

GST Amount = Applicable Taxable Amount × 18%

### 2. Delivery Charges

- Orders above ₹599 qualify for free delivery.
- Other eligible orders have a delivery charge of ₹49.

### 3. Wednesday Discount

- A 15% discount is applied on Wednesday when the eligible order amount is above ₹1,499.
- Otherwise, the Wednesday discount is not applied.

### 4. Stock Validation

The application checks whether sufficient product quantity is available before completing an order.

If the requested quantity exceeds the available stock, order placement is rejected and the application handles the insufficient-stock condition.

### 5. Inventory Update

After successful order placement, the purchased quantity is deducted from the available product stock.

### 6. Cart Clearing

After a successful order, the cart is cleared so that the same items are not accidentally submitted again through the existing cart.

*Note: The final amount depends on the exact order in which your implementation applies discounts, GST, and delivery charges.*

---

## 🔄 Application Workflow

The application follows this high-level flow:

```text
                    START
                      |
                 Main Menu
                      |
          +-----------+-----------+
          |           |           |
        Admin      Customer      Exit
          |           |
     Admin Menu   Customer Menu
          |           |
     +----+----+  Register / Login
     |         |        |
  Products   Orders  Browse Products
                        |
                    Search Product
                        |
                    Add to Cart
                        |
                     View Cart
                        |
                    Place Order
                        |
                   Validate Stock
                        |
               Calculate Final Amount
                        |
                  Place the Order
                        |
                 Update Inventory
                        |
                   Save Order
                        |
                    Clear Cart
                        |
                  View My Orders
                        |
                  Cancel if Eligible
```

---

## 🏗️ Project Architecture

The project uses a layered, modular structure to keep responsibilities separate.

### 1. Model Layer

Contains the classes representing the application's data.


- `Product.java`
- `Customer.java`
- `CartItem.java`
- `Order.java`

### 2. Repository Layer

Responsible for storing and retrieving application data.


- `ProductRepository.java`
- `CustomerRepository.java`
- `OrderRepository.java`

### 3. Service Layer

Contains business logic and coordinates application operations.

- `ProductService.java`
- `CustomerService.java`
- `CartService.java`
- `OrderService.java`

### 4. Exception Layer

Contains custom exception classes for specific error conditions.

- `InsufficientStockException.java`
-  ProductNotFoundException.java
-  CustomerNotFoundException.java 

### 5. Main Layer

Contains the application entry point and menu navigation.

- EcommerceApplication.java


This separation makes the code easier to understand, test, maintain, and extend.
---

## 📂 Project Structure

```text
E-Commerce-Product-Order-Management/
│
├── src/
│   └── com/
│       └── kodewala/
│           └── ecommerce/
│               │
│               ├── model/
│               │   ├── Product.java
│               │   ├── Customer.java
│               │   ├── CartItem.java
│               │   └── Order.java
│               │
│               ├── repository/
│               │   ├── ProductRepository.java
│               │   ├── CustomerRepository.java
│               │   └── OrderRepository.java
│               │
│               ├── service/
│               │   ├── ProductService.java
│               │   ├── CustomerService.java
│               │   ├── CartService.java
│               │   └── OrderService.java
│               │
│               ├── exception/
│               │   └── CustomerNotFoundException.java
                    └── ProductNotFoundException.java
                    └── InsufficientStockException.java
│               │
│               └── main/
│                   ├── EcommerceApplication.java
│                  
│
├── resources/
│   ├── data/
│   │   ├── products.txt
│   │   ├── customers.txt
│   │   └── orders.txt
│   │
│   └── application.properties
│
└── README.md
```

*The structure above represents the project layout shown in the project flowchart. Adjust directory names and files if your actual GitHub repository differs.*

---

## 🧰 Technologies Used

| Technology | Purpose |
|---|---|
| ☕ Java 21 | Application development |
| 🧱 Core Java | Application logic and programming fundamentals |
| 🧩 OOP | Organizing code into classes and objects |
| 📚 Collections Framework | Managing products, customers, cart items, and orders |
| 🔄 Stream API | Product searching and filtering where appropriate |
| ⚠️ Exception Handling | Handling errors and invalid operations |
| 📅 Date and Time API | Working with order dates and weekdays |
| 📄 File Handling | Local data storage, where implemented |
| 🖥️ Eclipse IDE | Development environment |
| 🐙 Git & GitHub | Version control and project hosting |

---

## 🧠 Core Java Concepts Implemented

This project provides practical examples of important Java concepts.

- **Classes and Objects:** Represent products, customers, cart items, and orders.
- **Encapsulation:** Keep fields private and expose controlled access through methods.
- **Collections Framework:** Use collections such as `ArrayList`, `HashMap`, and `HashSet` where appropriate.
- **Stream API:** Filter and search product data using operations such as `filter()` and `collect()`.
- **Exception Handling:** Handle invalid operations and unexpected conditions using `try`, `catch`, and custom exceptions.
- **Methods and Parameters:** Separate application operations into reusable methods.
- **Conditional Statements:** Apply stock checks, pricing rules, and order cancellation conditions.
- **Loops:** Iterate through products, cart items, and orders.
- **Date and Time API:** Determine order dates and apply weekday-based business rules.
- **Layered Design:** Separate data models, repositories, services, and application entry points.

These concepts help demonstrate how foundational Java knowledge can be applied to a practical application.

---

## ⚙️ Installation and Setup

### Prerequisites

Make sure you have:

- Java Development Kit (JDK) 21
- Eclipse IDE or another Java-compatible IDE
- Git installed (optional, for cloning the repository)



### Step 2: Open the Project

1. Open Eclipse IDE.
2. Select **File → Import**.
3. Choose the appropriate Java project import option.
4. Select the cloned project directory.
5. Make sure JDK 21 is configured for the project.

### Step 3: Check the Source Code

Verify the package structure, main classes, and required local data files.
### Step 4: Run the Application

Open the main application class and run it as a Java application.
*Use the actual main class and import method matching your repository setup.*

---

## ▶️ How to Use the Application

1. Start the application.
2. Select Admin, Customer, or Exit from the main menu.
3. As an administrator, manage products and view customers and orders.
4. As a customer, register or log in.
5. Browse or search products.
6. Add selected products to the cart.
7. Review cart items and quantities.
8. Place an order after stock validation.
9. Review your order history.
10. Cancel an eligible order if needed.
11. Log out to return to the main menu.

---

## 🧪 Sample Business Scenario

Suppose a customer wants to purchase two iPhones.

| Operation | Example |
|---|---|
| Initial stock | 10 units |
| Requested quantity | 2 units |
| Stock after adding to cart | 10 units |
| Stock after successful order | 8 units |

During checkout, the application validates stock and calculates the order amount according to its pricing rules. If the order succeeds, the inventory is updated and the order is saved.

If sufficient stock is unavailable, the application rejects the order and handles the error.

This scenario demonstrates the relationship between shopping cart management, business validation, order processing, and inventory control.

---
## 🚀 Future Enhancements

The following features can extend the project toward a more production-oriented backend application:

- 🗄️ Integrate MySQL using JDBC for persistent database storage.
- 🌐 Develop REST APIs using Spring Boot.
- 🔐 Implement secure authentication and role-based authorization.
- 🧪 Add unit and integration tests using JUnit and Mockito.
- 📝 Add logging for application events and errors.
- 🐳 Containerize the application using Docker.
- 🔄 Implement reliable transaction handling for order placement and inventory updates.
- 📊 Add sales reports and order analytics.

These are planned enhancements and are not claimed as completed features of the current Core Java version.

## 📚 Key Learning Outcomes
By developing this project, I practiced:

- Designing a modular Java application.
- Applying OOP principles to a practical use case.
- Managing related application data using Java collections.
- Implementing product search and filtering.
- Developing shopping cart and order management logic.
- Validating stock before processing orders.
- Applying discounts, taxes, and delivery charges.
- Handling application errors with exceptions.
- Separating business logic from data access operations.
- Understanding how an e-commerce application can evolve toward a database-backed backend system.
---
### 🏁 Project Status
**Core Java E-Commerce Application — Development and Testing**

