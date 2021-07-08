package com.ibm.kafka.springbootconsumer.command.service;


import com.ibm.kafka.springbootconsumer.command.command.AddUserCommand;
import com.ibm.kafka.springbootconsumer.command.command.DeleteUserCommand;
import com.ibm.kafka.springbootconsumer.command.command.UpdateUserCommand;
import com.ibm.kafka.springbootconsumer.command.dto.AddUserRequest;
import com.ibm.kafka.springbootconsumer.command.dto.DeleteByIdRequest;
import com.ibm.kafka.springbootconsumer.command.dto.UpdateByIdRequest;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class UserCommandService {

 private final CommandGateway commandGateway;

    public UserCommandService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public CompletableFuture<String> addUser(AddUserRequest addUserRequest){

        return commandGateway.send(new AddUserCommand(addUserRequest.getEmpId(), addUserRequest.getFirstName(), addUserRequest.getLastName(), addUserRequest.getEmail(), addUserRequest.getAddress()));
 }


 public CompletableFuture<String>  deleteUserById(DeleteByIdRequest deleteByIdRequest){

        return commandGateway.send(new DeleteUserCommand(deleteByIdRequest.getEmail()));
 }


 public CompletableFuture<String > updateUserById(UpdateByIdRequest updateByIdRequest){

        return commandGateway.send(new UpdateUserCommand(updateByIdRequest.getEmpId(),updateByIdRequest.getFirstName(),updateByIdRequest.getLastName(),updateByIdRequest.getEmail(),updateByIdRequest.getAddress()));
 }








}
