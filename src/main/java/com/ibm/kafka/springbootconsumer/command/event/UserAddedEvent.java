package com.ibm.kafka.springbootconsumer.command.event;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAddedEvent {

    private String empId;
    private String firstName;
    private String lastName;
    private String email;
    private String address;



}
