package com.ibm.kafka.springbootconsumer.common.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.model.AggregateIdentifier;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteEmployeeByIdConsume {

    @AggregateIdentifier
    private String email;


}
