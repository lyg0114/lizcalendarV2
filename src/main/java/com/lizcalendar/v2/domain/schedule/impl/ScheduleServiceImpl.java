package com.lizcalendar.v2.domain.schedule.impl;

import com.lizcalendar.v2.domain.schedule.ScheduleService;
import com.lizcalendar.v2.domain.user.impl.UserRepository;
import com.lizcalendar.v2.dto.ScheduleDto;
import com.lizcalendar.v2.entity.ScheduleEntity;
import com.lizcalendar.v2.entity.UserEntity;
import com.lizcalendar.v2.exception.ScheduleOverlapException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private ScheduleRepository scheduleRepository;
    private ModelMapper modelMapper;

    @Autowired
    public ScheduleServiceImpl(ScheduleRepository scheduleRepository, ModelMapper modelMapper) {
        this.scheduleRepository = scheduleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ScheduleDto createSchedule(ScheduleDto scheduleDto) {

        if(scheduleRepository.findByLessonStartDtBetween(scheduleDto.getLessonStartDt(), scheduleDto.getLessonEndDt()) != null){
            throw new ScheduleOverlapException("duplicate Schedule");
        }
        if(scheduleRepository.findByLessonEndDtBetween(scheduleDto.getLessonStartDt(), scheduleDto.getLessonEndDt()) != null){
            throw new ScheduleOverlapException("duplicate Schedule");
        }

        ScheduleEntity scheduleEntity = modelMapper.map(scheduleDto, ScheduleEntity.class);
        return modelMapper.map(scheduleRepository.save(scheduleEntity),ScheduleDto.class);
    }
}