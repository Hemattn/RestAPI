package com.rest.api2.demoRestApi2.hateous;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
@RestController
public class HateousAPI{
    List<Student> list=new ArrayList<>();
    @PostMapping("/student")
    public String addStudent(@RequestBody Student s){
        list.add(s);
        return "Student added";
    }
    @GetMapping("/student")
    public List<Student>allStudent(){
        return list;
    }
    @GetMapping("/student/{id}")
    public EntityModel<Student> getSpecific(@PathVariable int id){
        Student stdnt=list.stream().filter(e->e.getId()==id).findFirst().orElse(null);
        if(stdnt==null){
            throw new StudentException("no element"+id);
        }
        EntityModel<Student>ent =EntityModel.of(stdnt);
        WebMvcLinkBuilder wbc= linkTo(methodOn(this.getClass()).allStudent());
        ent.add(wbc.withRel("all-student"));

        return ent;
    }
}
