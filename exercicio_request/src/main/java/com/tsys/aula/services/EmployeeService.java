package com.tsys.aula.services;

import com.tsys.aula.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


}
