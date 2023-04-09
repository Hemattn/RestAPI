package com.spring.api.learning.spring_API;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//Question 1 of printing the "welcome to springboot " with the restfull api implementation.

//RestController annotation sends the data to the url.
//Restcontroller is a combination of RequestBody and Controller
//Jaha bhi hum restController likh de, vaha API bann rahi hoti hai.
@RestController
public class WelcomeClass {
    @RequestMapping(path="/welcome")
    public String printWelcome(){
        return "Welcome to springboot.";
    }

}
