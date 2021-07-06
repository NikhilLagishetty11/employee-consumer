package com.ibm.kafka.springbootconsumer.query.queryhandler;

import com.ibm.kafka.springbootconsumer.query.dto.UserLookupResponse;
import com.ibm.kafka.springbootconsumer.query.query.FindAllUsersQuery;
import com.ibm.kafka.springbootconsumer.query.query.FindUserByIdQuery;
import com.ibm.kafka.springbootconsumer.query.query.SearchUsersQuery;

public interface UserQueryHandler {

    UserLookupResponse getUserById(FindUserByIdQuery query);

    UserLookupResponse searchUsers(SearchUsersQuery query);

    UserLookupResponse getAllUsers(FindAllUsersQuery query);



}
