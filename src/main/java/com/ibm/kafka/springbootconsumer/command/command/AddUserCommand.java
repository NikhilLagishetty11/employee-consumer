package com.ibm.kafka.springbootconsumer.command.command;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddUserCommand {


    private String empId;
    private String firstName;
    private String lastName;
    private String email;
    private String address;


}
