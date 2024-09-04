package com.example.requestex.services;

import com.example.requestex.models.OrderModel;
import com.example.requestex.repositories.OrderRepository;
import com.example.requestex.specifications.OrderSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderServiceSpecification {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderModel> getAllOrders(Long orderNumber, String customerName, Boolean status,
                                         Long minTotalAmount, Long maxTotalAmount, LocalDate startDate, LocalDate endDate){
        Specification<OrderModel> spec = Specification
                .where(OrderSpecification.hasOrderNumber(orderNumber))
                        .and(OrderSpecification.hasCustomerName(customerName))
                        .and(OrderSpecification.hasStatus(status))
                        .and(OrderSpecification.hasTotalAmountRange(minTotalAmount, maxTotalAmount))
                        .and(OrderSpecification.hasOrderDateRange(startDate, endDate));

        return orderRepository.findAll(spec);
    }
}
