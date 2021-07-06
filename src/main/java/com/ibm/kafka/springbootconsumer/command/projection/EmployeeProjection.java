//package com.ibm.kafka.springbootconsumer.command.projection;
//
//
//import com.ibm.kafka.springbootconsumer.command.event.AddedEmployeeEvent;
//import com.ibm.kafka.springbootconsumer.command.model.Employee;
//import com.ibm.kafka.springbootconsumer.query.repository.EmployeeRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.axonframework.eventhandling.EventHandler;
//import org.axonframework.queryhandling.QueryUpdateEmitter;
//import org.springframework.stereotype.Component;
//
//@Slf4j
//@RequiredArgsConstructor
//@Component
//public class EmployeeProjection {
//
//    private final QueryUpdateEmitter updateEmitter;
//    private final EmployeeRepository repository;
//
//    @EventHandler
//    public void on(AddedEmployeeEvent event) {
//        Employee employee = new Employee();
//        employee.setEmpId(event.getEmpId());
//        employee.setFirstName(event.getFirstName());
//        employee.setLastName(event.getLastName());
//        employee.setEmail(event.getEmail());
//        employee.setAddress(event.getAddress());
////        this.repository.save(employee);
//    }
//}
