package com.tsys.aula.specifications;

import com.tsys.aula.models.EmployeeModel;
import com.tsys.aula.models.OrderModel;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class OrderSpecification {
    public static Specification<OrderModel> hasOrderNumber(Long orderNumber) {
        return ((root, query, criteriaBuilder) ->
                orderNumber == null ? null : criteriaBuilder.equal(root.get("orderNumber"), orderNumber));
    }

    public static Specification<OrderModel> hasCustomerName(String customerName){
        return((root, query, criteriaBuilder) ->
                customerName == null ? null : criteriaBuilder.like(criteriaBuilder.lower(root.get("customerName")),
                        "%" + customerName.toLowerCase() + "%"));
    }

    public static Specification<OrderModel> hasStatus(Boolean status){
        return((root, query, criteriaBuilder) ->
                status == null ? null: criteriaBuilder.like(criteriaBuilder.lower(root.get("status")),
                        "%" + status + "%"));
    }

    public static Specification<OrderModel> hasAmountRange(Double minAmount, Double maxAmount) {
        return ((root, query, criteriaBuilder) -> {
            if (minAmount != null && maxAmount != null) return criteriaBuilder.between(root.get("amount"), minAmount, maxAmount);
            else if (minAmount != null) return criteriaBuilder.greaterThanOrEqualTo(root.get("amount"), minAmount);
            else if (maxAmount != null) return criteriaBuilder.lessThanOrEqualTo(root.get("amount"), maxAmount);
            else return null;
        });
    }

    public static Specification<OrderModel> hasOrderDateRange(LocalDate startDate, LocalDate endDate) {
        return ((root, query, criteriaBuilder) -> {
            if (startDate != null && endDate != null) return criteriaBuilder.between(root.get("orderDate"), startDate, endDate);
            else if (startDate != null) return criteriaBuilder.greaterThanOrEqualTo(root.get("orderDate"), startDate);
            else if (endDate != null) return criteriaBuilder.lessThanOrEqualTo(root.get("orderDate"), endDate);
            else return null;
        });
    }
}
