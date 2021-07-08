package com.ibm.kafka.springbootconsumer.command.projection;


import com.ibm.kafka.springbootconsumer.command.event.UserAddedEvent;
import com.ibm.kafka.springbootconsumer.command.event.UserDeletedEvent;
import com.ibm.kafka.springbootconsumer.command.event.UserUpdatedEvent;
import com.ibm.kafka.springbootconsumer.common.model.Employee;
import com.ibm.kafka.springbootconsumer.common.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;
import java.util.Optional;


@Slf4j
@Component
@RequiredArgsConstructor
public class UserProjection {

    private final UserRepository repository;

    @EventHandler
    public void on(UserAddedEvent event){

        log.info("Entered the userAddedEvent method");

        Employee employee = new Employee(event.getEmpId(),event.getFirstName(),event.getLastName(),event.getEmail(),event.getAddress());
        this.repository.save(employee);
    }


    @EventHandler
    public void on(UserDeletedEvent event){
        log.info("Entered the userDeletedEvent method");
        this.repository.deleteByEmail(event.getEmail());
    }


    @EventHandler
    public void on(UserUpdatedEvent event){
        log.info("Entered the userUpdatedEvent method");

        Optional<Employee> optionalEntity = repository.findById(event.getEmpId());
        Employee employee = optionalEntity.get();

        if(!(employee.getFirstName().equals(event.getFirstName()))){
            employee.setFirstName(event.getFirstName());
        }
        if(!(employee.getLastName().equals(event.getLastName()))){
            employee.setLastName(event.getLastName());
        }
        if(!(employee.getEmail().equals(event.getEmail()))){
            employee.setEmail(event.getEmail());
        }
        if(!(employee.getAddress().equals(event.getAddress()))){
            employee.setAddress(event.getAddress());
        }
        repository.save(employee);
    }

}
