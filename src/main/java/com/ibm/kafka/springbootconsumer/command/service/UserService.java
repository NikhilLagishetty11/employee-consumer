package com.ibm.kafka.springbootconsumer.command.service;


import com.ibm.kafka.springbootconsumer.command.command.AddUserCommand;
import com.ibm.kafka.springbootconsumer.command.command.DeleteUserCommand;
import com.ibm.kafka.springbootconsumer.command.command.UpdateUserCommand;
import org.springframework.stereotype.Service;

@Service
public interface UserService {


    void addUser(AddUserCommand command);

    void updateUser(UpdateUserCommand command);

    void deleteUser(DeleteUserCommand command);
}
