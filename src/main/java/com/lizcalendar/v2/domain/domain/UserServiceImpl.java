package com.lizcalendar.v2.domain.domain;

import com.lizcalendar.v2.dto.UserDto;
import com.lizcalendar.v2.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

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
}
