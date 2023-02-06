package com.app.controllers;

import com.app.dto.NewCustomerRequest;
import com.app.entity.Customer;
import com.app.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Customer> getCustomers() {
        return customerService.findAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable UUID id) {
        return customerService.findCustomer(id);
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Customer addCustomer(@RequestBody NewCustomerRequest newCustomerRequest) {
        return customerService.addCustomer(new Customer(newCustomerRequest));
    }

    @PatchMapping("/update/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Customer updateCustomer(@PathVariable UUID id, @RequestBody Customer customerUpdateRequest) {
        return customerService.updateCustomer(id, customerUpdateRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable UUID id) {
        customerService.deleteCustomer(id);
    }
}
