package com.app.controllers;

import com.app.dto.ApiResponse;
import com.app.dto.LoginCred;
import com.app.entity.Customer;
import com.app.services.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<?> loginCustomer(@RequestBody LoginCred cred) {
        Customer customer = loginService.loginCustomer(cred);
        if (Objects.isNull(customer)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiResponse("user details incorrect"));
        }
        return ResponseEntity.ok(new ApiResponse(customer.getId()));
    }

}
