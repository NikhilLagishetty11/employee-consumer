package com.ibm.kafka.springbootconsumer.common.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_cmd")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeCmd {

    @Id
    private String empId;
    private String firstName;
    private String lastName;
    private String email;
    private String address;

    public EmployeeCmd(String empId) {
    }
}
