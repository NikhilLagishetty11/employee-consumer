package com.ibm.kafka.springbootconsumer.command.aggregate;



import com.ibm.kafka.springbootconsumer.command.command.AddUserCommand;

import com.ibm.kafka.springbootconsumer.command.event.UserAddedEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Aggregate
public class UserAggregate {

    @AggregateIdentifier
    private String empId;
    private String firstName;
    private String lastName;
    private String email;
    private String address;

    @CommandHandler
    public UserAggregate(AddUserCommand command){

        log.info("Entered the AddUserCommand handler..2");
        AggregateLifecycle.apply(new UserAddedEvent(
                command.getEmpId(),
                command.getFirstName(),
                command.getLastName(),command.getEmail(),command.getAddress()));
    }


    @EventSourcingHandler
    public void on(UserAddedEvent event) {
        log.info("Entered the UserAddedEvent handler..3");
        this.empId = event.getEmpId();
        this.firstName = event.getFirstName();
        this.lastName = event.getLastName();
        this.email= event.getEmail();
        this.address= event.getAddress();
    }
}
