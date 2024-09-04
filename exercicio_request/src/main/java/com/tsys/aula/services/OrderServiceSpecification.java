package com.tsys.aula.services;

import com.tsys.aula.models.EmployeeModel;
import com.tsys.aula.models.OrderModel;
import com.tsys.aula.repositories.EmployeeRepository;
import com.tsys.aula.repositories.OrderRepository;
import com.tsys.aula.specifications.EmployeeSpecification;
import com.tsys.aula.specifications.OrderSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.List;

public class OrderServiceSpecification {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderModel> getAllOrders(long orderNumber, String customerName, boolean status,
                                         double minAmount, double maxAmount, LocalDate startDate, LocalDate endDate){
        Specification<OrderModel> spec = Specification
                .where(OrderSpecification.hasOrderNumber(orderNumber))
                        .and(OrderSpecification.hasCustomerName(customerName))
                        .and(OrderSpecification.hasStatus(status))
                        .and(OrderSpecification.hasAmountRange(minAmount, maxAmount))
                        .and(OrderSpecification.hasOrderDateRange(startDate, endDate));

        return orderRepository.findAll(spec);
    }
}
