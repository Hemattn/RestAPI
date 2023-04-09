package com.rest.api2.demoRestApi2.internationalisation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Question2 {
    @GetMapping("/hello/{name}")
    public String get(@PathVariable String name){
        return "Hello"+" "+name;
    }
}
