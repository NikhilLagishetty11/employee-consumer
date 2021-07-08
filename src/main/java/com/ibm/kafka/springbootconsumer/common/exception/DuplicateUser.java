package com.ibm.kafka.springbootconsumer.common.exception;

public class DuplicateUser extends RuntimeException{

    public String expMessage;
    public  String id;
    public DuplicateUser(final String expMessage, final String id){
        super(expMessage);
        this.expMessage=expMessage;
        this.id=id;
    }

    public DuplicateUser(final String expMessage, Throwable e, String id){
        super(expMessage,e);
        this.expMessage=expMessage;
        this.id=id;
    }

    public DuplicateUser(Throwable cause){
        super(cause);
    }

    public String getExpMessage(){return expMessage;}
    public String getId(){return id;}

}
