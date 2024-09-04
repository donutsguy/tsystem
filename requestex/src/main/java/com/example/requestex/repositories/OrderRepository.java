package com.example.requestex.repositories;

import com.example.requestex.models.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<OrderModel, Long>, JpaSpecificationExecutor<OrderModel> {

    List<OrderModel> findByOrderNumber (long orderNumber);
    List<OrderModel> findByCustomerName (String customerName);
    List<OrderModel> findByStatus (boolean status);
    List<OrderModel> findByTotalAmountBetween(Long minTotalAmount, Long maxTotalAmount);
    List<OrderModel> findByOrderDateBetween (LocalDate startDate, LocalDate endDate);
}
