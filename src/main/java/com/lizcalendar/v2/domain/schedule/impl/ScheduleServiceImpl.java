package com.lizcalendar.v2.domain.schedule.impl;

import com.lizcalendar.v2.domain.schedule.ScheduleService;
import com.lizcalendar.v2.domain.user.impl.UserRepository;
import com.lizcalendar.v2.dto.ScheduleDto;
import com.lizcalendar.v2.entity.ScheduleEntity;
import com.lizcalendar.v2.entity.UserEntity;
import com.lizcalendar.v2.exception.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

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

        addConditionCheck(scheduleDto);

        ScheduleEntity scheduleEntity = modelMapper.map(scheduleDto, ScheduleEntity.class);
        UserEntity userEntity = modelMapper.map(scheduleDto, UserEntity.class);
        scheduleEntity.setUser(userEntity);

        ScheduleEntity savedSchedule = scheduleRepository.save(scheduleEntity);

        return savedSchedule.convertToDto();
    }

    private void addConditionCheck(ScheduleDto scheduleDto) {

        LocalDateTime today = LocalDateTime.now();
        Duration duration = Duration.between(scheduleDto.getLessonStartDt(), scheduleDto.getLessonEndDt());
        int duplicateCount = scheduleRepository.checkSuitableTime(scheduleDto.getLessonStartDt(), scheduleDto.getLessonEndDt());

        /*종료일이 시작일보다 앞설수 없음*/
        if(!scheduleDto.getLessonStartDt().isBefore(scheduleDto.getLessonEndDt())){
            throw new ScheduleTimeMisMatchException();
        }

        /*지난날은 등록하지 못함 */
        if(today.isAfter(scheduleDto.getLessonStartDt()) || today.isAfter(scheduleDto.getLessonEndDt())){
            throw new SchedulePastDateException();
        }

        /*일주일 이내만 예약 가능 */
        if(ChronoUnit.DAYS.between(today, scheduleDto.getLessonStartDt()) > 7){
            throw new ScheduleOverTimeException();
        }

        /*1시간 이하로 예약 가능*/
        if(duration.getSeconds() > 3600){
            throw new ScheduleTimeLimitException();
        }

        /* 중복 시간 체크 */
        if(duplicateCount > 0){
            throw new ScheduleOverlapException();
        }




    }


}
