package com.vcs.bankApplication.controller;

import com.vcs.bankApplication.model.Customer;
import com.vcs.bankApplication.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {

        Customer savedCustomer = null;
        ResponseEntity response = null;
        try {
            String hashString = passwordEncoder.encode(customer.getPassword());
            customer.setPassword(hashString);
            savedCustomer = customerRepository.save(customer);
            if ( savedCustomer.getId() > 0 )
                response = ResponseEntity.status(HttpStatus.CREATED)
                        .body("Given user details are successfully registered");
        }
        catch (Exception exception) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("an exception occured due to " + exception.getMessage());
        }
        return response;
    }
}
