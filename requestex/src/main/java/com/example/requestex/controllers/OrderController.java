package com.example.requestex.controllers;

import com.example.requestex.models.OrderModel;
import com.example.requestex.services.OrderServiceSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderServiceSpecification orderServiceSpecification;

    @GetMapping
    public List<OrderModel> getOrders(
            @RequestParam(value = "ordernumber", required = false) Long orderNumber,
            @RequestParam(value = "customername", required = false) String customerName,
            @RequestParam(value = "status", required = false) Boolean status,
            @RequestParam(value = "mintotalamount", required = false) Long minTotalAmount,
            @RequestParam(value = "maxtotalamount", required = false) Long maxTotalAmount,
            @RequestParam(value = "startdate", required = false) LocalDate startDate,
            @RequestParam(value = "enddate", required = false) LocalDate endDate
    ){
            return orderServiceSpecification.getAllOrders(orderNumber, customerName, status, minTotalAmount, maxTotalAmount, startDate, endDate);
    };
}
