package com.ibm.kafka.springbootconsumer.command.aggregate;



import com.ibm.kafka.springbootconsumer.command.command.AddUserCommand;

import com.ibm.kafka.springbootconsumer.command.command.DeleteUserCommand;
import com.ibm.kafka.springbootconsumer.command.command.UpdateUserCommand;
import com.ibm.kafka.springbootconsumer.command.event.UserAddedEvent;
import com.ibm.kafka.springbootconsumer.command.event.UserDeletedEvent;
import com.ibm.kafka.springbootconsumer.command.event.UserUpdatedEvent;
import com.ibm.kafka.springbootconsumer.command.service.UserService;
import com.ibm.kafka.springbootconsumer.command.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Aggregate
public class UserAggregate  {




    @AggregateIdentifier
    private String empId;

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;


    @CommandHandler
    public UserAggregate(AddUserCommand command, @Autowired UserService service){

        log.info("Entered the AddUserCommand handler");
         service.addUser(command);
        AggregateLifecycle.apply(new UserAddedEvent(
                command.getEmpId(),
                command.getFirstName(),
                command.getLastName(),command.getEmail(),command.getAddress()));
    }


    @CommandHandler
    public UserAggregate(DeleteUserCommand command, @Autowired UserService service){
        log.info("Entered the deleteUserCommand handler");
        service.deleteUser(command);
        AggregateLifecycle.apply(new UserDeletedEvent(
                command.getEmail()));
    }


    @CommandHandler
    public UserAggregate(UpdateUserCommand command, @Autowired UserService service){
        log.info("Entered the updateUserCommand handler");
        service.updateUser(command);
        AggregateLifecycle.apply(new UserUpdatedEvent(command.getEmpId(),
                command.getFirstName(),
                command.getLastName(),command.getEmail(),command.getAddress()));
    }


    @EventSourcingHandler
    public void on(UserAddedEvent event) {
        log.info("Entered the UserAddedEvent handler");
        this.empId = event.getEmpId();
        this.firstName = event.getFirstName();
        this.lastName = event.getLastName();
        this.email= event.getEmail();
        this.address= event.getAddress();
    }


    @EventSourcingHandler
    public void on(UserDeletedEvent event){
        this.empId= UUID.randomUUID().toString();
        log.info("Entered the deleteUserEvent handler" +event.getEmail());
        this.email = event.getEmail();
    }

    @EventSourcingHandler
    public void on(UserUpdatedEvent event){
        log.info("Entered the UserUpdatedEvent handler");
        this.empId= UUID.randomUUID().toString();
        this.id = event.getEmpId();
        this.firstName = event.getFirstName();
        this.lastName = event.getLastName();
        this.email= event.getEmail();
        this.address= event.getAddress();
    }
}
