package com.ibm.kafka.springbootconsumer.command.event;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserDeletedEvent {



    private String email;
}
