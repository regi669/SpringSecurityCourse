package com.regi.SpringSecurityCourse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cards")
public class CardsController {

    @GetMapping
    public String getCards () {
        return "Cards";
    }
}
