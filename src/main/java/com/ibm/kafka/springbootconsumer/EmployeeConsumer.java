package com.ibm.kafka.springbootconsumer;


import com.ibm.kafka.springbootconsumer.command.api.UserController;
import com.ibm.kafka.springbootconsumer.command.dto.AddUserRequest;
import com.ibm.kafka.springbootconsumer.command.dto.DeleteByIdRequest;
import com.ibm.kafka.springbootconsumer.command.dto.UpdateByIdRequest;
import com.ibm.kafka.springbootconsumer.common.model.AddEmployeeConsumeModel;
import com.ibm.kafka.springbootconsumer.common.model.DeleteEmployeeByIdConsume;
import com.ibm.kafka.springbootconsumer.common.model.UpdateEmployeeConsumeModel;
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
    public void add(AddEmployeeConsumeModel addEmployeeConsumeModel){
        AddUserRequest request = new AddUserRequest();
        BeanUtils.copyProperties(addEmployeeConsumeModel,request);
        userController.saveUser(request);
    }


    @KafkaListener(topics = "delete_employee_topic", groupId = "group_id", containerFactory = "kafkaListenerContainerFactory")
    public void consume(DeleteEmployeeByIdConsume deleteById){

        DeleteByIdRequest request = new DeleteByIdRequest();
        request.setEmail(deleteById.getEmail().replaceAll("^\"|\"$", ""));
        userController.deleteUser(request);
    }

    @KafkaListener(topics = "update_employee_topic", groupId = "group_json", containerFactory = "UpdateUserKafkaListenerFactory")
    public void add(UpdateEmployeeConsumeModel updateEmployeeConsumeModel){
        log.info(updateEmployeeConsumeModel.getAddress());

        UpdateByIdRequest request = new UpdateByIdRequest();
        BeanUtils.copyProperties(updateEmployeeConsumeModel,request);
        userController.updateUser(request);
    }


}
