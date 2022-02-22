package com.example.round2_exp1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class WelcomeController {
    @GetMapping("/")
    public String landingPage() {
        return "You have reached this website successfully. Please try and go to /controls for more information";
    }

    @GetMapping("/controls")
    public String controls(@RequestParam(value = "username", defaultValue = "User") String message) {
        return "Welcome " + message + ", you have reached the controls page.";
    }

}
