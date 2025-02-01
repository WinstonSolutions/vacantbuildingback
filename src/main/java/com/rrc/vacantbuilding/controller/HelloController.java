package com.rrc.vacantbuilding.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Annotate the class with @RestController to indicate it's a REST controller
@RestController
public class HelloController {

    // Map the /hello endpoint to this method
    @GetMapping("/hello")
    public String hello() {
        // Return a simple greeting message
        return "Hello, Spring Boot!";
    }
}