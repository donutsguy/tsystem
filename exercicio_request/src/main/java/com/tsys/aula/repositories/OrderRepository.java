package com.tsys.aula.repositories;

import com.tsys.aula.models.EmployeeModel;
import com.tsys.aula.models.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<OrderModel, Long>, JpaSpecificationExecutor<OrderModel> {

    List<OrderModel> findByOrderNumber (long orderNumber);
    List<OrderModel> findByCustomerName (String customerName);
    List<OrderModel> findByStatus (boolean status);
    List<OrderModel> findByAmountBetween (Double minAmount, Double maxAmount);
    List<OrderModel> findByOrderDateBetween (LocalDate startDate, LocalDate endDate);
}
