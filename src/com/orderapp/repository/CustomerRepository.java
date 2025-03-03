package com.orderapp.repository;

import com.orderapp.model.Customer;
import java.util.HashMap;
import java.util.Map;

public class CustomerRepository {
    private final Map<Integer, Customer> customers = new HashMap<>();
    private int idCounter = 1;

    public int getNextCustomerId() {
        return idCounter++;
    }

    public void saveCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    public Customer findCustomerById(int id) {
        return customers.get(id);
    }

    public Map<Integer, Customer> getAllCustomers() {
        return new HashMap<>(customers);
    }

    public boolean deleteCustomer(int id) {
        return customers.remove(id) != null;
    }
}
