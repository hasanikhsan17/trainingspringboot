package com.hasan.trainingjdbc.repository;

import java.util.List;
import java.util.Optional;

import com.hasan.trainingjdbc.entity.Employee;

public interface EmployeeRepository {
    int count();
    int save(Employee employee);
    int update(Employee employee);
    int deleteByID(Long id);

    List<Employee> findAll();

    List<Employee> findByLastName(String lastName);

    Optional<Employee> findById(Long id);

}