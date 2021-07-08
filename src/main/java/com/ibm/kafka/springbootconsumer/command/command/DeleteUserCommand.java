package com.ibm.kafka.springbootconsumer.command.command;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteUserCommand {


    private String email;
}
