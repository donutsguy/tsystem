package com.example.requestex.services;

import com.example.requestex.models.EmployeeModel;
import com.example.requestex.repositories.EmployeeRepository;
import com.example.requestex.specifications.EmployeeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.List;

public class EmployeeServiceSpecification {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeModel> getAllEmployees(String firstName, String department, Double minSalary,
                                               LocalDate hiredAfter, LocalDate hiredBefore, Boolean active){
        Specification<EmployeeModel> spec = Specification
                .where(EmployeeSpecification.hasFirstName(firstName))
                .and(EmployeeSpecification.hasDepartment(department))
                .and(EmployeeSpecification.hasMinSalary(minSalary))
                .and(EmployeeSpecification.hasHiredRange(hiredAfter, hiredBefore))
                .and(EmployeeSpecification.hasStatus(active));

        return employeeRepository.findAll(spec);
    }
}
