package com.orderapp.service;

import com.orderapp.model.Customer;
import com.orderapp.model.Order;
import com.orderapp.model.OrderItem;
import com.orderapp.model.Product;
import com.orderapp.repository.CustomerRepository;
import com.orderapp.repository.ProductRepository;

public class CustomerOrderService {
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public CustomerOrderService(CustomerRepository customerRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    public Customer createCustomer(String name, String email, String phone) {
        int customerId = customerRepository.getNextCustomerId();
        Customer customer = new Customer(customerId, name, email, phone);
        customerRepository.saveCustomer(customer);
        return customer;
    }

    public Product createProduct(String name, double price, int stockQuantity) {
        int productId = productRepository.getNextProductId();
        Product product = new Product(productId, name, price, stockQuantity);
        productRepository.saveProduct(product);
        return product;
    }

    public Order createOrder(int customerId) {
        Customer customer = customerRepository.findCustomerById(customerId);
        if (customer == null) {
            throw new IllegalArgumentException("Customer not found with ID: " + customerId);
        }

        Order order = new Order(customerId);
        customer.addOrder(order);
        return order;
    }

    public boolean addItemToOrder(Order order, int productId, int quantity) {
        Product product = productRepository.findProductById(productId);
        if (product == null) {
            return false;
        }

        if (product.getStockQuantity() < quantity) {
            return false;
        }

        OrderItem orderItem = new OrderItem(product, quantity);
        order.addItem(orderItem);
        product.removeFromStock(quantity);
        return true;
    }

    public boolean confirmOrder(Order order) {
        if (order.getItems().isEmpty()) {
            return false;
        }

        order.setStatus(Order.OrderStatus.CONFIRMED);
        return true;
    }

    public void updateOrderStatus(Order order, Order.OrderStatus status) {
        order.setStatus(status);
    }

    public Order findOrderById(int customerId, String orderId) {
        Customer customer = customerRepository.findCustomerById(customerId);
        if (customer == null) {
            return null;
        }

        return customer.getOrderHistory().stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .findFirst()
                .orElse(null);
    }
}
