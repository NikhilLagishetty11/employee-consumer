package com.ibm.kafka.springbootconsumer.query.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {


    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
}
