package com.app.services;

import com.app.dto.LoginCred;
import com.app.entity.Customer;
import com.app.exception.RequestNotFound;
import com.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
    private final CustomerRepository customerRepository;

    public LoginServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer loginCustomer(LoginCred cred) {

       return customerRepository.fetchCustomerByEmailAndPassword(cred.getEmail(), cred.getPassword());

    }
}
