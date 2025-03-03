package com.orderapp;

import com.orderapp.model.Customer;
import com.orderapp.model.Order;
import com.orderapp.model.Product;
import com.orderapp.repository.CustomerRepository;
import com.orderapp.repository.ProductRepository;
import com.orderapp.service.CustomerOrderService;

public class Main {
    public static void main(String[] args) {
        // Initialize repositories
        CustomerRepository customerRepository = new CustomerRepository();
        ProductRepository productRepository = new ProductRepository();

        // Initialize service
        CustomerOrderService orderService = new CustomerOrderService(customerRepository, productRepository);

        // Create customers
        Customer customer1 = orderService.createCustomer("John Doe", "john@example.com", "555-1234");
        Customer customer2 = orderService.createCustomer("Jane Smith", "jane@example.com", "555-5678");

        // Create products
        Product product1 = orderService.createProduct("Laptop", 1200.00, 10);
        Product product2 = orderService.createProduct("Smartphone", 800.00, 20);
        Product product3 = orderService.createProduct("Headphones", 150.00, 30);

        // Create an order for customer 1
        Order order1 = orderService.createOrder(customer1.getId());

        // Add items to the order
        orderService.addItemToOrder(order1, product1.getId(), 1);
        orderService.addItemToOrder(order1, product3.getId(), 2);

        // Confirm the order
        orderService.confirmOrder(order1);

        // Create an order for customer 2
        Order order2 = orderService.createOrder(customer2.getId());

        // Add items to the order
        orderService.addItemToOrder(order2, product2.getId(), 1);
        orderService.addItemToOrder(order2, product3.getId(), 1);

        // Confirm the order
        orderService.confirmOrder(order2);

        // Update order status
        orderService.updateOrderStatus(order1, Order.OrderStatus.SHIPPED);

        // Print customer information with their orders
        System.out.println("Customer 1: " + customer1);
        System.out.println("Orders:");
        customer1.getOrderHistory().forEach(order -> {
            System.out.println("  " + order);
            System.out.println("  Items:");
            order.getItems().forEach(item -> System.out.println("    " + item));
        });

        System.out.println("\nCustomer 2: " + customer2);
        System.out.println("Orders:");
        customer2.getOrderHistory().forEach(order -> {
            System.out.println("  " + order);
            System.out.println("  Items:");
            order.getItems().forEach(item -> System.out.println("    " + item));
        });

        // Print product inventory after orders
        System.out.println("\nCurrent Product Inventory:");
        System.out.println("  " + product1);
        System.out.println("  " + product2);
        System.out.println("  " + product3);
    }
}
