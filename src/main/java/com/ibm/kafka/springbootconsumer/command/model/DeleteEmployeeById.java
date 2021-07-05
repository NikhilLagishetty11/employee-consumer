package com.ibm.kafka.springbootconsumer.command.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteEmployeeById {

    private String empId;
}
