package com.ibm.kafka.springbootconsumer.common.model;



import com.ibm.kafka.springbootconsumer.command.event.UserAddedEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeConsumeModel {

    private String empId;
    private String firstName;
    private String lastName;
    private String email;
    private String address;


    public EmployeeConsumeModel(UserAddedEvent event) {
    }
}
