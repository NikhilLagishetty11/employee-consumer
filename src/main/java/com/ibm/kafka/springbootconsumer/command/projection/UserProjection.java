package com.ibm.kafka.springbootconsumer.command.projection;


import com.ibm.kafka.springbootconsumer.command.event.UserAddedEvent;
import com.ibm.kafka.springbootconsumer.common.model.Employee;
import com.ibm.kafka.springbootconsumer.common.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserProjection {

    private final UserRepository repository;

    @EventHandler
    public void on(UserAddedEvent event){

        log.info("Entered the userAddedevent method..4");

        Employee employee = new Employee(event.getEmpId(),event.getFirstName(),event.getLastName(),event.getEmail(),event.getAddress());
        this.repository.save(employee);
    }


}
