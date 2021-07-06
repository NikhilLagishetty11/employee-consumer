package com.ibm.kafka.springbootconsumer.query.queryhandler;

import com.ibm.kafka.springbootconsumer.query.dto.UserLookupResponse;
import com.ibm.kafka.springbootconsumer.query.query.FindAllUsersQuery;
import com.ibm.kafka.springbootconsumer.query.query.FindUserByIdQuery;
import com.ibm.kafka.springbootconsumer.query.query.SearchUsersQuery;
import com.ibm.kafka.springbootconsumer.query.repository.UserRepository;
import lombok.var;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class UserQueryHandlerImpl implements UserQueryHandler {

    private final UserRepository userRepository;

    @Autowired
    public UserQueryHandlerImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @QueryHandler
    @Override
    public UserLookupResponse getUserById(FindUserByIdQuery query){
        var employee= userRepository.findById(query.getEmpId());
        return employee.isPresent() ? new UserLookupResponse(employee.get()): null;
    }

    @QueryHandler
    @Override
    public UserLookupResponse searchUsers(SearchUsersQuery query){
      var employees = new ArrayList<>(userRepository.findByFilterRegex(query.getFilter()));
        return new UserLookupResponse(employees);
    }

    @QueryHandler
    @Override
    public UserLookupResponse getAllUsers(FindAllUsersQuery query){

        var employees = new ArrayList<>(userRepository.findAll());
        return new UserLookupResponse(employees) ;

    }


}
