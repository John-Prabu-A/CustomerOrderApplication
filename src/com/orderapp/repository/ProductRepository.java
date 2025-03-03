package com.orderapp.repository;

import com.orderapp.model.Product;
import java.util.HashMap;
import java.util.Map;

public class ProductRepository {
    private final Map<Integer, Product> products = new HashMap<>();
    private int idCounter = 1;

    public int getNextProductId() {
        return idCounter++;
    }

    public void saveProduct(Product product) {
        products.put(product.getId(), product);
    }

    public Product findProductById(int id) {
        return products.get(id);
    }

    public Map<Integer, Product> getAllProducts() {
        return new HashMap<>(products);
    }

    public boolean deleteProduct(int id) {
        return products.remove(id) != null;
    }
}
