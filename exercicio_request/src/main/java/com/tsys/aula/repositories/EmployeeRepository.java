package com.tsys.aula.repositories;

import com.tsys.aula.models.EmployeeModel;
import com.tsys.aula.models.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long>, JpaSpecificationExecutor<EmployeeModel> {

    List<EmployeeModel> findByFirstName (String firstName);
    List<EmployeeModel> findByDepartment (String department);


}
