package com.example.requestex.specifications;


import com.example.requestex.models.EmployeeModel;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class EmployeeSpecification {
    public static Specification<EmployeeModel> hasFirstName(String firstName){
        return((root, query, criteriaBuilder) ->
                firstName == null ? null : criteriaBuilder.like(criteriaBuilder.lower(root.get("firstName")),
                        "%" + firstName.toLowerCase() + "%"));
    }

    public static Specification<EmployeeModel> hasDepartment(String department){
        return((root, query, criteriaBuilder) ->
                department == null ? null : criteriaBuilder.like(criteriaBuilder.lower(root.get("department")),
                        "%" + department.toLowerCase() + "%"));
    }

    public static Specification<EmployeeModel> hasMinSalary(Double salary) {
        return ((root, query, criteriaBuilder) ->
                salary == null ? null : criteriaBuilder.lessThanOrEqualTo(root.get("salary"), salary));
    }

    public static Specification<EmployeeModel> hasHiredRange(LocalDate hiredAfter, LocalDate hiredBefore) {
        return ((root, query, criteriaBuilder) -> {
            if (hiredAfter != null && hiredBefore != null) return criteriaBuilder.between(root.get("hiredDate"), hiredAfter, hiredBefore);
            else if (hiredAfter != null) return criteriaBuilder.greaterThanOrEqualTo(root.get("hiredDate"), hiredAfter);
            else if (hiredBefore != null) return criteriaBuilder.lessThanOrEqualTo(root.get("hiredDate"), hiredBefore);
            else return null;
        });
    }

    public static Specification<EmployeeModel> hasStatus(Boolean active){
        return((root, query, criteriaBuilder) ->
                active == null ? null: criteriaBuilder.like(criteriaBuilder.lower(root.get("active")),
                        "%" + active + "%"));
    }
}
