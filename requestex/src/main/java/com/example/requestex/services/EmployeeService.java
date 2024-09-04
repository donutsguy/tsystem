package com.example.requestex.services;

import com.example.requestex.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


}
