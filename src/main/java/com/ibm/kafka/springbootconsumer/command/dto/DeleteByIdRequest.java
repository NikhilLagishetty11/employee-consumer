package com.ibm.kafka.springbootconsumer.command.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteByIdRequest {

    private String email;
}
