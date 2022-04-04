package com.regi.SpringSecurityCourse.controller;

import com.regi.SpringSecurityCourse.entity.CustomerEntity;
import com.regi.SpringSecurityCourse.security.CustomUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
@AllArgsConstructor
public class CustomerController {

    private CustomUserDetailsService customUserDetailsService;

    @GetMapping
    public String getUserInfo () {
        CustomerEntity currentCustomer =  customUserDetailsService.getUserFromCurrentSession();
        return currentCustomer.getId() + currentCustomer.getEmail() + currentCustomer.getRole();
    }
}
