package com.hasan.trainingjdbc.controller;

import java.util.List;

import javax.validation.Valid;

import com.hasan.trainingjdbc.repository.EmployeeImp;
import com.hasan.trainingjdbc.entity.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    
    @Autowired
    @Qualifier("EmployeeRepository")
    private EmployeeImp employeeRepository;

    @GetMapping("/employee")
    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
        
    }

    @PostMapping("/employee")
    public int postEmployee(@Valid @RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @DeleteMapping("/employee")
    public int deleteEmployee(@RequestParam("id") Long id){
        return employeeRepository.deleteByID(id);

    }

    @PutMapping("/employee")
    public int updateEmployee(@Valid @RequestBody Employee employee){
        return employeeRepository.update(employee);
    }

}