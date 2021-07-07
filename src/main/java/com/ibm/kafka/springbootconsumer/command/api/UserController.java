package com.ibm.kafka.springbootconsumer.command.api;


import com.ibm.kafka.springbootconsumer.command.dto.AddUserRequest;
import com.ibm.kafka.springbootconsumer.command.service.AddUserCommandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


import java.util.UUID;



@Component
@Slf4j
public class UserController {

    private final AddUserCommandService addUserCommandService;


    public UserController(AddUserCommandService addUserCommandService) {
        this.addUserCommandService = addUserCommandService;
    }


    public void saveUser(AddUserRequest addUserRequest){
        addUserRequest.setEmpId(UUID.randomUUID().toString());
        log.info("Entered the addUserRequest Controller..1");
        addUserCommandService.addUser(addUserRequest);
    }
}
