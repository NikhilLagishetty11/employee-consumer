package com.ibm.kafka.springbootconsumer.query.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePrjDTO {


    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
}
