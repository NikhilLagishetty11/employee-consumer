package com.ibm.kafka.springbootconsumer;


import com.ibm.kafka.springbootconsumer.command.api.UserController;
import com.ibm.kafka.springbootconsumer.command.dto.AddUserRequest;
import com.ibm.kafka.springbootconsumer.common.model.DeleteEmployeeById;
import com.ibm.kafka.springbootconsumer.common.model.EmployeeConsumeModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class EmployeeConsumer {


    @Autowired
    UserController userController;

    @KafkaListener(topics = "second_topic", groupId = "group_json", containerFactory = "userKafkaListenerFactory")
    public void add(EmployeeConsumeModel employeeConsumeModel){
        AddUserRequest command = new AddUserRequest();
        BeanUtils.copyProperties(employeeConsumeModel,command);
        userController.saveUser(command);
    }


    @KafkaListener(topics = "delete_employee_topic", groupId = "group_id", containerFactory = "kafkaListenerContainerFactory")
    public void consume(DeleteEmployeeById deleteById){

        log.info(deleteById.getEmpId());

        System.out.println("the date is consumed");
    }


}
