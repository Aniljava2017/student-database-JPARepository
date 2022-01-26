package com.example.controller;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;
    @RequestMapping("/add_emp")
    public String addEmployee(@RequestBody Employee employee){
        employeeRepository.save(employee);
        return "Added Successfull";
    }
    @RequestMapping("/get_emp")
    public List<Employee> getEmployeeList(){
        return employeeRepository.findAll();
    }
    @RequestMapping("/remove_emp")
    public String deletEmployee(@RequestParam Long id){
        employeeRepository.deleteById(id);
        return "Remove Succesfull";
    }
    @RequestMapping("/put_emp")
    public String putEmployee(@RequestParam String name,@RequestParam Long id){
        Employee employee=employeeRepository.getById(id);
        employee.setName(name);
        employeeRepository.save(employee);
        return "Update Successfull"+name;
    }
}
