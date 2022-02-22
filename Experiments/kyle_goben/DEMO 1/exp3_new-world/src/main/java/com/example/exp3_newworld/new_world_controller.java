package com.example.exp3_newworld;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class new_world_controller {
    TestData td;

    @GetMapping("/getTest")
    public String getTest(@RequestParam(value = "username", defaultValue = "World") String message) {
        return String.format("Hello, %s! You sent a get request with a parameter!", td.getName());
    }

    @PostMapping("/postTest1")
    public String postTest1(@RequestParam(value = "username", defaultValue = "World") String message) {
        td = new TestData();
        return String.format("Hello, %s! You sent a post request with a parameter!", td.getName());
    }



    @PostMapping("/postTest2")
    public String postTest2(@RequestBody TestData testData) {
        return String.format("Hello, %s! Your favorite color is %s. Your password is %s. Your phone number is %s.", testData.getName(),
                testData.getFaveColor(), testData.getPassword(), testData.getPhoneNum());
    }

    @DeleteMapping("/deleteTest")
    public void deleteTest() {
        //TODO
    }

    @PutMapping("/putTest")
    public void putTest() {
        //TODO
    }

}
