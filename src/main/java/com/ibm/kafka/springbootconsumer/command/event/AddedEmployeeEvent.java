package com.ibm.kafka.springbootconsumer.command.event;


import lombok.Data;

@Data
public class AddedEmployeeEvent {

    private String empId;
    private String firstName;
    private String lastName;
    private String email;
    private String address;


    public AddedEmployeeEvent(String empId, String firstName, String lastName, String email, String address) {
    }
}
