//package com.ibm.kafka.springbootconsumer.query.service;
//
//
//import com.ibm.kafka.springbootconsumer.query.model.Employee;
//import com.ibm.kafka.springbootconsumer.query.query.FIndByEmployeeIdQuery;
//import com.ibm.kafka.springbootconsumer.query.repository.EmployeeRepoForQuery;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//@Slf4j
//public class EmployeeQryServiceImpl implements EmployeeQryService {
//
//    final
//    EmployeeRepoForQuery repoForQuery;
//
//    public EmployeeQryServiceImpl(EmployeeRepoForQuery repoForQuery){
//        this.repoForQuery=repoForQuery;
//    }
//
//
//    @Override
//    public Optional<Employee> getEmployeeById(FIndByEmployeeIdQuery employeeIdQuery){
//        log.info("entered the service implementation-------------------");
//
//        Optional<Employee> employee = repoForQuery.findEmployeeByEmpId(employeeIdQuery.getId());
//
//         return employee;
//    }
//
//
//}
