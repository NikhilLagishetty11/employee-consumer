package com.ibm.kafka.springbootconsumer.query.dto;

import com.ibm.kafka.springbootconsumer.common.BaseResponse;
import com.ibm.kafka.springbootconsumer.common.model.Employee;

import java.util.ArrayList;
import java.util.List;


public class UserLookupResponse extends BaseResponse {

    private List<Employee> employee;

    public UserLookupResponse(String message){
        super(message);
    }


    public UserLookupResponse(List<Employee> employee){

        super(null);
        this.employee = employee;
    }


    public UserLookupResponse(String message, Employee employee){
        super(message);
        this.employee = new ArrayList<>();
        this.employee.add(employee);
    }

    public UserLookupResponse(Employee employee){
        super(null);
        this.employee = new ArrayList<>();
        this.employee.add(employee);
    }

    public List<Employee> getUsers(){
        return this.employee;
    }

    public void setUsers(List<Employee> employee){
        this.employee=employee;
    }


}
