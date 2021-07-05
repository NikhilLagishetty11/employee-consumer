package com.ibm.kafka.springbootconsumer.query.service;


import com.ibm.kafka.springbootconsumer.query.entity.Employee;
import com.ibm.kafka.springbootconsumer.query.query.FIndByEmployeeIdQuery;
import com.ibm.kafka.springbootconsumer.query.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    @QueryHandler
    public Optional<Employee> handle(FIndByEmployeeIdQuery query){

        Optional<Employee> employee = employeeRepository.findById(query.getId());

        return employee;
    }

}
