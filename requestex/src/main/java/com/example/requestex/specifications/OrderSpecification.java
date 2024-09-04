package com.example.requestex.specifications;

import com.example.requestex.models.OrderModel;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class OrderSpecification {
    public static Specification<OrderModel> hasOrderNumber(Long orderNumber) {
        return ((root, query, criteriaBuilder) ->
                orderNumber == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("orderNumber"), orderNumber));
    }

    public static Specification<OrderModel> hasCustomerName(String customerName){
        return((root, query, criteriaBuilder) ->
                customerName == null ? criteriaBuilder.conjunction() : criteriaBuilder.like(criteriaBuilder.lower(root.get("customerName")),
                        "%" + customerName.toLowerCase() + "%"));
    }

    public static Specification<OrderModel> hasStatus(Boolean status) {
        return (root, query, criteriaBuilder) ->
                status == null ? criteriaBuilder.conjunction()
                        : criteriaBuilder.equal(root.get("status"), status);
    }

    public static Specification<OrderModel> hasTotalAmountRange(Long minTotalAmount, Long maxTotalAmount) {
        return ((root, query, criteriaBuilder) -> {
            if (minTotalAmount != null && maxTotalAmount != null) return criteriaBuilder.between(root.get("totalAmount"), minTotalAmount, maxTotalAmount);
            else if (minTotalAmount != null) return criteriaBuilder.greaterThanOrEqualTo(root.get("totalAmount"), minTotalAmount);
            else if (maxTotalAmount != null) return criteriaBuilder.lessThanOrEqualTo(root.get("totalAmount"), maxTotalAmount);
            else return criteriaBuilder.conjunction();
        });
    }

    public static Specification<OrderModel> hasOrderDateRange(LocalDate startDate, LocalDate endDate) {
        return ((root, query, criteriaBuilder) -> {
            if (startDate != null && endDate != null) return criteriaBuilder.between(root.get("orderDate"), startDate, endDate);
            else if (startDate != null) return criteriaBuilder.greaterThanOrEqualTo(root.get("orderDate"), startDate);
            else if (endDate != null) return criteriaBuilder.lessThanOrEqualTo(root.get("orderDate"), endDate);
            else return criteriaBuilder.conjunction();
        });
    }
}
