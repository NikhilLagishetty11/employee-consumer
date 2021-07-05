package com.ibm.kafka.springbootconsumer.query.query;


import com.ibm.kafka.springbootconsumer.query.entity.Employee;
import com.ibm.kafka.springbootconsumer.query.entity.EmployeePrjDTO;
import lombok.Data;

import java.util.Optional;

@Data
public class GetEmployeePrjResponse {

    private String message;
    private EmployeePrjDTO employeePrj;


    public void setEmployeePrj(Optional<Employee> employeePrj) {
    }
}
