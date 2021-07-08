package com.lizcalendar.v2.domain.user.impl;

import com.lizcalendar.v2.domain.schedule.impl.ScheduleRepository;
import com.lizcalendar.v2.domain.user.UserService;
import com.lizcalendar.v2.dto.ScheduleDto;
import com.lizcalendar.v2.dto.UserDto;
import com.lizcalendar.v2.entity.ScheduleEntity;
import com.lizcalendar.v2.entity.UserEntity;
import com.lizcalendar.v2.error.ErrorCode;
import com.lizcalendar.v2.exception.DataNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ScheduleRepository scheduleRepository;
    private ModelMapper modelMapper;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, ScheduleRepository scheduleRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.scheduleRepository = scheduleRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<UserDto> findUsers(UserDto userDto) {

        return userRepository.findAll()
                .stream().map(userEntity -> modelMapper.map(userEntity, userDto.getClass()))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findUser(long userId) {

        UserEntity findUserEntity = userRepository.findById(userId).orElseThrow(() -> new DataNotFoundException());
        UserDto findUserDto = findUserEntity.converToDto();

        List<ScheduleEntity> scheduleEntityList = scheduleRepository.findScheduleEntitiesByUserAndLessonStartDtBetween(findUserEntity, LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(1));
        List<ScheduleDto> scheduleDtoList = scheduleEntityList.stream().map(i -> i.convertToDto()).collect(Collectors.toList());
        findUserDto.setScheduleList(scheduleDtoList);

        return findUserDto;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
        return modelMapper.map(userRepository.save(userEntity), UserDto.class);
    }

    @Override
    public UserDto updateUser(long userId, UserDto userDto) {

        UserEntity beforeUserEntity = userRepository.findById(userId)
                .orElseThrow(()->new DataNotFoundException());

        if(userDto.getName() != null){
            beforeUserEntity.setName(userDto.getName());
        }
        if(userDto.getNicName() != null){
            beforeUserEntity.setNicName(userDto.getNicName());
        }

        UserEntity afterUserEntity = userRepository.save(beforeUserEntity);
        return modelMapper.map(afterUserEntity, UserDto.class);
    }

    @Override
    public void deleteUser(long userId) {
        userRepository.deleteById(userId);
    }
}
