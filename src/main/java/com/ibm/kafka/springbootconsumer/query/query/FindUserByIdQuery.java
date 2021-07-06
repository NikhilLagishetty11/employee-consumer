package com.ibm.kafka.springbootconsumer.query.query;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FindUserByIdQuery {

    private String empId;
}
