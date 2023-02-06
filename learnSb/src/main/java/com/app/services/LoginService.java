package com.app.services;

import com.app.dto.LoginCred;
import com.app.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface LoginService {
    public Customer loginCustomer(LoginCred cred);
}
