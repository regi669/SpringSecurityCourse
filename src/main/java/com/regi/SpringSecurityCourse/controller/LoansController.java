package com.regi.SpringSecurityCourse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/loans")
public class LoansController {

    @GetMapping
    public String getLoans () {
        return "Loans";
    }
}
