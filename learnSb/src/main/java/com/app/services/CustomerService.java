package com.app.services;

import com.app.entity.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    public List<Customer> findAllCustomers();
    public Customer findCustomer(UUID uuid);
    public Customer addCustomer(Customer newCustomer);
    public void deleteCustomer(UUID uuid);
    public Customer updateCustomer(UUID uuid, Customer customerUpdateRequest);
}
