package com.orderapp.model;

public class OrderItem {
    private Product product;
    private int quantity;
    private double priceAtTimeOfOrder;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.priceAtTimeOfOrder = product.getPrice();
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPriceAtTimeOfOrder() {
        return priceAtTimeOfOrder;
    }

    public double getSubtotal() {
        return priceAtTimeOfOrder * quantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "product=" + product.getName() +
                ", quantity=" + quantity +
                ", priceAtTimeOfOrder=" + priceAtTimeOfOrder +
                ", subtotal=" + getSubtotal() +
                '}';
    }
}
