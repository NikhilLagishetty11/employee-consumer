package com.ibm.kafka.springbootconsumer.common.repository;



import com.ibm.kafka.springbootconsumer.common.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<Employee, String> {

    @Query("{'$or': [{'firstName' : {$regex : ?0, $options: '1'}}, {'lastName' : {$regex : ?0, $options: '1'}},{'email' : {$regex : ?0, $options: '1'}},{'address' : {$regex : ?0, $options: '1'}}]}")
    List<Employee> findByFilterRegex(String filter);


    void deleteByEmail(String email);
}
