package com.ibm.kafka.springbootconsumer.common.repository;

import com.ibm.kafka.springbootconsumer.common.model.EmployeeCmd;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserPrjRepository extends MongoRepository<EmployeeCmd, String> {


    void deleteByEmail(String email);

    List<EmployeeCmd> findByEmail(String id);

}
