package com.ibm.kafka.springbootconsumer.query.service;

import com.ibm.kafka.springbootconsumer.query.entity.Employee;
import com.ibm.kafka.springbootconsumer.query.query.FIndByEmployeeIdQuery;

import java.util.Optional;

public interface EmployeeQryService {

    Optional<Employee> getEmployeeById(FIndByEmployeeIdQuery employeeIdQuery);
}
