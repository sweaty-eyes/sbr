package com.app.repository;

import com.app.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    @Query("select c from Customer c where c.email=?1 and c.password=?2")
    Customer fetchCustomerByEmailAndPassword(String email,String password);

}
