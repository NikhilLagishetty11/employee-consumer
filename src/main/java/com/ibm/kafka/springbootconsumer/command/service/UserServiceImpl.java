package com.ibm.kafka.springbootconsumer.command.service;

import com.ibm.kafka.springbootconsumer.command.command.AddUserCommand;
import com.ibm.kafka.springbootconsumer.command.command.DeleteUserCommand;
import com.ibm.kafka.springbootconsumer.command.command.UpdateUserCommand;
import com.ibm.kafka.springbootconsumer.common.exception.DuplicateUser;
import com.ibm.kafka.springbootconsumer.common.model.EmployeeCmd;
import com.ibm.kafka.springbootconsumer.common.repository.UserPrjRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserPrjRepository repository;

    public UserServiceImpl(UserPrjRepository repository) {
        this.repository = repository;
    }


    @Override
    public void addUser(AddUserCommand command) throws RuntimeException {
        log.info("entered the add user  service ");


        if(validateUser(command.getEmail())) {
            EmployeeCmd employeeCmd = new EmployeeCmd(command.getEmpId(), command.getFirstName(), command.getLastName(), command.getEmail(), command.getAddress());
            repository.save(employeeCmd);
        } else {
            throw new DuplicateUser("User already exists with same email ",command.getEmail());
        }
    }

    @Override
    public void updateUser(UpdateUserCommand command){
        log.info("entered the update user  service ");

        Optional<EmployeeCmd> optionalEmployeeCmd = repository.findById(command.getEmpId());

        EmployeeCmd employee = optionalEmployeeCmd.get();
        if(!employee.getFirstName().equals(command.getFirstName())){
            employee.setFirstName(command.getFirstName());
        }
        if(!employee.getLastName().equals(command.getLastName())){
            employee.setLastName(command.getLastName());
        }
        if(!employee.getEmail().equals(command.getEmail())){
            employee.setEmail(command.getEmail());
        }
        if(!employee.getAddress().equals(command.getAddress())){
            employee.setAddress(command.getAddress());
        }
        repository.save(employee);

    }

    @Override
    public void deleteUser(DeleteUserCommand command){
        log.info("entered the delete user  service ");
        repository.deleteByEmail(command.getEmail());
    }


    public boolean validateUser(String id){
        List<EmployeeCmd> emails = repository.findByEmail(id);
       emails.forEach(e->log.info("User already Exists with email "));
       log.debug("Duplicate Email");
        return emails.isEmpty();
    }
}
