package com.ibm.kafka.springbootconsumer;


import com.ibm.kafka.springbootconsumer.command.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class EmployeeConsumer {

    @KafkaListener(topics = "second_topic", groupId = "group_json", containerFactory = "userKafkaListenerFactory")
    public void consume(Employee employee){

        log.info(employee.getId());

        System.out.println("the date is consumed");
    }


}
