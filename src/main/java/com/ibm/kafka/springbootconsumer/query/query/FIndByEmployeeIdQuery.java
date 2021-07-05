package com.ibm.kafka.springbootconsumer.query.query;


import lombok.Data;

@Data
public class FIndByEmployeeIdQuery {
    private String id;

    public FIndByEmployeeIdQuery(String id){
        this.id=id;
    }
}
