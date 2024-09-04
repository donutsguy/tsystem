package com.example.requestex.repositories;

import com.example.requestex.models.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long>, JpaSpecificationExecutor<EmployeeModel> {

    List<EmployeeModel> findByFirstName (String firstName);
    List<EmployeeModel> findByDepartment (String department);


}
