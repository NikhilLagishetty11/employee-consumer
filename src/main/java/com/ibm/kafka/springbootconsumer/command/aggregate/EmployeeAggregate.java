//package com.ibm.kafka.springbootconsumer.command.aggregate;
//
//
//import com.ibm.kafka.springbootconsumer.command.command.AddEmployeeCommand;
//import com.ibm.kafka.springbootconsumer.command.event.AddedEmployeeEvent;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import org.axonframework.commandhandling.CommandHandler;
//import org.axonframework.eventsourcing.EventSourcingHandler;
//import org.axonframework.modelling.command.AggregateIdentifier;
//import org.axonframework.modelling.command.AggregateLifecycle;
//import org.axonframework.spring.stereotype.Aggregate;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Aggregate
//public class EmployeeAggregate {
//
//    @AggregateIdentifier
//    private String empId;
//    private String firstName;
//    private String lastName;
//    private String email;
//    private String address;
//
//    @CommandHandler
//    public EmployeeAggregate(AddEmployeeCommand command){
//        AggregateLifecycle.apply(new AddedEmployeeEvent(command.getEmpId(),command.getFirstName(),command.getLastName(),command.getEmail(),command.getAddress()));
//    }
//
//
//    @EventSourcingHandler
//    public void on(AddedEmployeeEvent event) {
//        this.empId = event.getEmpId();
//        this.firstName = event.getFirstName();
//        this.lastName = event.getLastName();
//        this.email= event.getEmail();
//        this.address= event.getAddress();
//    }
//}
