package com.lizcalendar.v2.domain.user.impl;

import com.lizcalendar.v2.domain.user.UserService;
import com.lizcalendar.v2.dto.UserDto;
import com.lizcalendar.v2.entity.UserEntity;
import com.lizcalendar.v2.error.ErrorCode;
import com.lizcalendar.v2.exception.DataNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
        userRepository.save(userEntity);
        return modelMapper.map(userRepository.save(userEntity), UserDto.class);
    }

    @Override
    public UserDto updateUser(long userId, UserDto userDto) {

        UserEntity beforeUserEntity = userRepository.findById(userId)
                .orElseThrow(()->new DataNotFoundException(ErrorCode.RESOURCE_NOT_FOUND.getMessage()));

        beforeUserEntity.setName(userDto.getName());
        beforeUserEntity.setNicName(userDto.getNicName());
        UserEntity afterUserEntity = userRepository.save(beforeUserEntity);
        return modelMapper.map(afterUserEntity, userDto.getClass());
    }
}
