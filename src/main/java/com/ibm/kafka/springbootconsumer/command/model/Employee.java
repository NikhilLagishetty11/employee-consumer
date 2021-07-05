package com.ibm.kafka.springbootconsumer.command.model;



import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;


    public Employee(){
    }

}
