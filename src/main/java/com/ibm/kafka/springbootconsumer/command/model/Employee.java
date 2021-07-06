package com.ibm.kafka.springbootconsumer.command.model;



import com.ibm.kafka.springbootconsumer.command.event.AddedEmployeeEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private String empId;
    private String firstName;
    private String lastName;
    private String email;
    private String address;


    public Employee(AddedEmployeeEvent event) {
    }
}
