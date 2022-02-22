package com.example.exp2_sbinit;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class welcome_controller {

    @GetMapping("/Welcome")
    public String welcome(){
        return "Welcome Everyone";
    }

    @GetMapping("/new")
    public String newndmethod(){
        return "This is my second freaking page lets goooooo";
    }

}
