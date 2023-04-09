package com.rest.api2.demoRestApi2.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
public class UserController {
    List<UserOne> l1=new ArrayList<>();
    List<UserTwo>l2=new ArrayList<>();
    @GetMapping("/v1/user")
    public List<UserOne>getUser1(){
        return l1;
    }
    @PostMapping("/v1/user")
    public String addUser1(@RequestBody UserOne u){
        l1.add(u);
        return "user added";
    }


    @GetMapping("/v2/user")
    public List<UserTwo>getUser2(){
        return l2;
    }
    @PostMapping("/v2/user")
    public String addUser2(@RequestBody UserTwo u){
        l2.add(u);
        return "new user added";
    }
    @GetMapping(path="/v1/user",params = "version1")
    public List<UserOne>getVersion1Param(){
        return l1;
    }

    @GetMapping(path="/v2/user",params = "version2")
    public List<UserTwo>getAdvanceVersion1Param(){
        return l2;
    }

    @GetMapping(path="/user/header",headers = "API=1")
    public List<UserOne> getVersion1Header(){
        return l1;
    }

    @GetMapping(path="/user/header",headers = "API=2")
    public List<UserTwo> getAdvanceVersion1Header(){
        return l2;
    }
}
