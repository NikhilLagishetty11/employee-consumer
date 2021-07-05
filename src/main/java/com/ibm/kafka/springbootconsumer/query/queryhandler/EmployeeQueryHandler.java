package com.ibm.kafka.springbootconsumer.query.queryhandler;


import com.ibm.kafka.springbootconsumer.query.entity.Employee;
import com.ibm.kafka.springbootconsumer.query.query.FIndByEmployeeIdQuery;
import com.ibm.kafka.springbootconsumer.query.query.GetEmployeePrjResponse;
import com.ibm.kafka.springbootconsumer.query.service.EmployeeQryService;
import com.ibm.kafka.springbootconsumer.query.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Slf4j
@Component
public class EmployeeQueryHandler {

    final
    EmployeeQryService service;

    final EmployeeService Employeeservice;

    public EmployeeQueryHandler(EmployeeQryService service, EmployeeService employeeService){
        this.service=service;
        this.Employeeservice=employeeService;
    }


    @QueryHandler
    public GetEmployeePrjResponse getEmployeeById(FIndByEmployeeIdQuery employeeIdQuery){
        log.info("entered get EmployeeById query handler ");
        Optional<Employee> employeePrj = service.getEmployeeById(employeeIdQuery);
        GetEmployeePrjResponse response = new GetEmployeePrjResponse();
        response.setEmployeePrj(employeePrj);
        return response;
    }

}
