package com.ibm.kafka.springbootconsumer;


import com.ibm.kafka.springbootconsumer.command.model.DeleteEmployeeById;
import com.ibm.kafka.springbootconsumer.command.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class EmployeeConsumer {

//    private EmployeeCommandService employeeCommandService;
//
//    @Autowired
//    private EmployeeRepository repo;

    @KafkaListener(topics = "second_topic", groupId = "group_json", containerFactory = "userKafkaListenerFactory")
    public void add(Employee employee){
//    public CompletableFuture<Employee> addEmployee(Employee employee){

        log.info(employee.getEmpId());
        log.info(employee.getEmail());
//         repo.save(employee);
//        System.out.println("the date is consumed");
//        return this.employeeCommandService.addEmployee(employee);
    }


    @KafkaListener(topics = "delete_employee_topic", groupId = "group_id", containerFactory = "kafkaListenerContainerFactory")
    public void consume(DeleteEmployeeById deleteById){

        log.info(deleteById.getEmpId());

        System.out.println("the date is consumed");
    }


}
