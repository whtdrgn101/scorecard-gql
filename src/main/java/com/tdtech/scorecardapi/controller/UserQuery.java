package com.tdtech.scorecardapi.controller;

import com.tdtech.scorecardapi.entity.UserRequest;
import com.tdtech.scorecardapi.entity.UserResponse;
import com.tdtech.scorecardapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserQuery {

    @Autowired
    UserService userService;

    @QueryMapping
    public List<UserResponse> userList() {
        return userService.getAllUsers();
    }

    @MutationMapping
    public UserResponse createUser(@Argument UserRequest user) {
        return userService.createUser(user);
    }

    @MutationMapping
    public UserResponse updateUser(@Argument String id, @Argument UserRequest user) {
        return userService.updateUser(id, user);
    }
}
