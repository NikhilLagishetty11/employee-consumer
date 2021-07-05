package com.ibm.kafka.springbootconsumer.query.api;


import com.ibm.kafka.springbootconsumer.query.query.FIndByEmployeeIdQuery;
import com.ibm.kafka.springbootconsumer.query.query.GetEmployeePrjResponse;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@RequestMapping(value = "/employee")
public class EmployeeRestApi {

    private final QueryGateway queryGateway;

    public EmployeeRestApi(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping(value = "/employeedetails/{id}")
    CompletableFuture<GetEmployeePrjResponse> getEmployeeDetails(@PathVariable String id) {
        log.info("Get worker by id request received. Email: {}", id);
        return queryGateway.query(new FIndByEmployeeIdQuery(id), GetEmployeePrjResponse.class );
    }


}
