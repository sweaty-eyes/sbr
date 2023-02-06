package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class NewCustomerRequest {
    String firstName;
    String lastName;
    String email;
    Integer age;
    String password;
}
