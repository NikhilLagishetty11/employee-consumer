package com.ibm.kafka.springbootconsumer.command.service;


import com.ibm.kafka.springbootconsumer.command.command.AddUserCommand;
import com.ibm.kafka.springbootconsumer.command.dto.AddUserRequest;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class AddUserCommandService {

 private final CommandGateway commandGateway;

    public AddUserCommandService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public CompletableFuture<String> addUser(AddUserRequest addUserRequest){

        return commandGateway.send(new AddUserCommand(addUserRequest.getEmpId(), addUserRequest.getFirstName(), addUserRequest.getLastName(), addUserRequest.getEmail(), addUserRequest.getAddress()));

 }
}
