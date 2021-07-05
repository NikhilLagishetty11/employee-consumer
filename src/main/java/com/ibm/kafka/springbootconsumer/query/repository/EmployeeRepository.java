package com.ibm.kafka.springbootconsumer.query.repository;


import com.ibm.kafka.springbootconsumer.query.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {


}
