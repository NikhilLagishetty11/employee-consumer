package com.ibm.kafka.springbootconsumer.query.repository;


import com.ibm.kafka.springbootconsumer.query.entity.Employee;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepoForQuery extends MongoRepository<Employee, String> {

    @NotNull
    Optional<Employee> findById(String id);


}
