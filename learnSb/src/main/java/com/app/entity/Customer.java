package com.app.entity;

import com.app.dto.NewCustomerRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@Entity
public class Customer extends BaseClass {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private Integer age;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    public Customer(NewCustomerRequest newCustomerRequest){
        super();
        this.firstName= newCustomerRequest.getFirstName();
        this.lastName= newCustomerRequest.getLastName();
        this.email = newCustomerRequest.getEmail();
        this.age = newCustomerRequest.getAge();
        this.password = newCustomerRequest.getPassword();
    }

}
