package com.ibm.kafka.springbootconsumer.command.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateByIdRequest {

    private String empId;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
}
