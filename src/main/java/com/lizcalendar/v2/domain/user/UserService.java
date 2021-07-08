package com.lizcalendar.v2.domain.user;

import com.lizcalendar.v2.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto updateUser(long userId, UserDto userDto);

    void deleteUser(long userId);

    List<UserDto> findUsers(UserDto search);

    UserDto findUser(long userId);

}
