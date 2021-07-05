package com.ibm.kafka.springbootconsumer;



import com.ibm.kafka.springbootconsumer.command.model.DeleteEmployeeById;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DeleteEmployeeByIdConsumer {




    @KafkaListener(topics = "delete_employee_topic", groupId = "group_id", containerFactory = "kafkaListenerContainerFactory")
    public void consume(DeleteEmployeeById deleteById){

        log.info(deleteById.getEmpId());

        System.out.println("the date is consumed");
    }
}
