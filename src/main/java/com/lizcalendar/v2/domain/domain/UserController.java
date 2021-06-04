package com.lizcalendar.v2.domain.domain;

import com.lizcalendar.v2.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {

    private UserService userService;
    private ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity createuser(@RequestBody UserDto userDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userDto));
    }



}
