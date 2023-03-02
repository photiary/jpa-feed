package com.example.feed.controller;

import com.example.feed.dto.UserDto;
import com.example.feed.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @QueryMapping
    @GetMapping(path = "/users")
    public List<UserDto> findAllUser() {
        return userService.findAll()
                .stream().map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }
}
