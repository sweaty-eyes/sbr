package com.app.services;

import com.app.entity.Customer;
import com.app.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findCustomer(UUID uuid) {
        return customerRepository.findById(uuid).orElse(null);
    }

    @Override
    public Customer addCustomer(Customer newCustomer) {
        return customerRepository.save(newCustomer);
    }

    @Override
    public void deleteCustomer(UUID uuid) {
        customerRepository.deleteById(uuid);
    }

    @Override
    public Customer updateCustomer(UUID uuid, Customer cur) {
//        if (customerRepository.existsById(uuid)){
        customerRepository.findById(uuid).ifPresent(customer -> {
            customer.setFirstName(cur.getFirstName());
            customer.setLastName(cur.getLastName());
            customer.setPassword(cur.getPassword());
            customer.setEmail(cur.getEmail());
            customer.setAge(cur.getAge());
        });
        return cur;
//        }
    }

}
