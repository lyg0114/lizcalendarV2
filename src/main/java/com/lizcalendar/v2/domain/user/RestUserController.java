package com.lizcalendar.v2.domain.user;

import com.lizcalendar.v2.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class RestUserController {

    private UserService userService;
    private ModelMapper modelMapper;

    @Autowired
    public RestUserController(UserService userService, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @PostMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> getUsers(@RequestBody UserDto search){
        return userService.findUsers(search);
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createUser(@RequestBody UserDto userDto){
        return userService.createUser(userDto);
    }

    @PutMapping(value = "{userId}/update", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public UserDto updateUser(@PathVariable long userId, @RequestBody UserDto userDto){
        return userService.updateUser(userId, userDto);
    }

    @DeleteMapping(value = "{userId}/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable long userId){
        userService.deleteUser(userId);
    }






}
