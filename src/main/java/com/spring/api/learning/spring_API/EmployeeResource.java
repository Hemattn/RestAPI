package com.spring.api.learning.spring_API;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeResource {
    private EmployeeDAO empDAO;
    public EmployeeResource(EmployeeDAO empDAO) {
        this.empDAO = empDAO;
    }
    //Question 3: Implement GET http request for Employee to get list of employees.
    @GetMapping("/employees")
    public List<Employee> getAll(){
        return empDAO.getEmpList();
    }
    //Question4 : Implement GET http request using path variable top get one employee
    //Question 6: Implement Exception Handling for resource not found
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
       Employee emp=empDAO.findOne(id);
       if(emp==null)
           throw new EmployeeNotFoundException("id :"+id);
       return emp;
    }
    //Question 5:Implement POST http request for Employee to create a new employee.
    //Question 9: Apply validation while create a new employee using POST http Request.
    @PostMapping("/employees")
    public void createNewUser(@Valid @RequestBody Employee emp){
        empDAO.saveEmp(emp);
    }
    //Question 7: Implement DELETE http request for Employee to delete employee
    @DeleteMapping("/employee/{id}")
    public void deleteAnEmployee(@PathVariable int id){
        empDAO.deleteById(id);
    }

    //Question 8:Implement PUT http request for Employee to update employee
    @PutMapping("/employees")
    public Employee updateEmp(@RequestBody Employee emp){
        return empDAO.updateEmp(emp);
    }
}
