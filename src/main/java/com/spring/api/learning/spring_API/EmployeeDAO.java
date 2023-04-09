package com.spring.api.learning.spring_API;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
//Create an Employee Bean(id, name, age) and service to  perform different operations related to employee.

//@Component - It is used to create a bean.
@Component
public class EmployeeDAO {
    public static List<Employee> empList= new ArrayList<>();
    //data should be entered at the starting , therefore entering it in a static block.
    static{
        empList.add(new Employee(1,"Aayush", 22));
        empList.add(new Employee(2,"Aayushi", 24));
        empList.add(new Employee(3,"Tom", 26));
        empList.add(new Employee(4,"Zendaya", 24));
    }
    //Operations on the Employee.
    //Prints all the data in the list.
    public List<Employee> getEmpList(){
        return empList;
    }

    //Print one data at a time
    public Employee findOne(int id){
        Employee emp=null;
        for(Employee e :empList){
            if(id ==e.getId()){
                emp=e;
            }
        }
        return emp;
    }

    //Delete a single row from employee.
    public void deleteById(int id){
        for( Employee emp :empList){
            if(id==emp.getId()){
                empList.remove(id);
            }
        }
    }

    //Save one data in empList
    //This can be done in two ways
    //either add directly into the list or make another object say em and then add it to the list.
    public void saveEmp(Employee em) {
//        empList.setId(5);
//        empList.setName("Gigi");
//        empList.setAge(35);
        em.setId(5);
        em.setName("Gigi");
        em.setAge(35);
        empList.add(em);
    }

        //Update a record in list.
        public Employee updateEmp(Employee e){
            int index=0;
            for(Employee emp:empList){
                if(emp.getId()==e.getId()){
                    index=empList.indexOf(emp);
                    break;
                }
            }
            empList.set(index, e);
            return e;
        }
}

