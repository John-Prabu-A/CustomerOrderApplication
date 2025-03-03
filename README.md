# Customer Order Management System

A Java application for managing customer orders, products, and inventory.

## Overview

This Customer Order Management System is a Java-based application designed to handle the core business logic for an e-commerce or retail operation. It allows businesses to manage customers, products, and process orders with inventory tracking.

## Features

- **Customer Management**: Store and retrieve customer information
- **Product Catalog**: Maintain products with pricing and inventory information
- **Order Processing**: Create orders, add items, and track order status
- **Inventory Management**: Automatically update stock levels when orders are placed
- **Order Lifecycle**: Track orders through stages (PENDING, CONFIRMED, SHIPPED, DELIVERED, CANCELED)

## System Architecture

The application follows a clean layered architecture:

- **Model Layer**: Core domain objects (Customer, Product, Order, OrderItem)
- **Repository Layer**: Data access and persistence
- **Service Layer**: Business logic and operations

## Class Structure

### Model Classes
- `Customer`: Stores customer details and order history
- `Product`: Manages product information including price and inventory
- `Order`: Tracks order status and items
- `OrderItem`: Links products to orders with quantity and price information

### Repository Classes
- `CustomerRepository`: Stores and retrieves customer data
- `ProductRepository`: Manages product inventory

### Service Layer
- `CustomerOrderService`: Handles business logic for creating customers, products, and orders

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- IntelliJ IDEA or any Java IDE

### Running the Application
1. Clone the repository
   ```
   git clone https://github.com/John-Prabu-A/CustomerOrderApplication.git
   ```
2. Open the project in your IDE
3. Run the `Main` class to see a demonstration of the system

## Sample Usage

```java
// Initialize repositories and service
CustomerRepository customerRepository = new CustomerRepository();
ProductRepository productRepository = new ProductRepository();
CustomerOrderService orderService = new CustomerOrderService(customerRepository, productRepository);

// Create a customer
Customer customer = orderService.createCustomer("John Doe", "john@example.com", "555-1234");

// Add products to catalog
Product laptop = orderService.createProduct("Laptop", 1200.00, 10);
Product headphones = orderService.createProduct("Headphones", 150.00, 30);

// Create an order
Order order = orderService.createOrder(customer.getId());

// Add items to the order
orderService.addItemToOrder(order, laptop.getId(), 1);
orderService.addItemToOrder(order, headphones.getId(), 2);

// Confirm and process the order
orderService.confirmOrder(order);
orderService.updateOrderStatus(order, Order.OrderStatus.SHIPPED);
```

## Future Enhancements

- Database integration with JDBC/JPA
- RESTful API for web/mobile applications
- User authentication and authorization
- Payment processing integration
- Shipping provider integration
- Email notifications for order status updates
- Reporting and analytics

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.
