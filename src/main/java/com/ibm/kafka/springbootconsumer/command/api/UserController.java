package com.ibm.kafka.springbootconsumer.command.api;


import com.ibm.kafka.springbootconsumer.command.dto.AddUserRequest;
import com.ibm.kafka.springbootconsumer.command.dto.DeleteByIdRequest;
import com.ibm.kafka.springbootconsumer.command.dto.UpdateByIdRequest;
import com.ibm.kafka.springbootconsumer.command.service.UserCommandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


import java.util.UUID;



@Component
@Slf4j
public class UserController {

    private final UserCommandService userCommandService;


    public UserController(UserCommandService addUserCommandService) {
        this.userCommandService = addUserCommandService;
    }


    public void saveUser(AddUserRequest addUserRequest){
        addUserRequest.setEmpId(UUID.randomUUID().toString());
        log.info("Entered the addUserRequest Controller");
        userCommandService.addUser(addUserRequest);
    }


    public void deleteUser(DeleteByIdRequest deleteByIdRequest){
        log.info("Entered the deleteByIdRequest");
        userCommandService.deleteUserById(deleteByIdRequest);
    }

    public void updateUser(UpdateByIdRequest updateByIdRequest){
        log.info("Entered the updateByIdRequest");
        userCommandService.updateUserById(updateByIdRequest);

    }


}
