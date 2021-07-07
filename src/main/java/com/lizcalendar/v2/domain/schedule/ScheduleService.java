package com.lizcalendar.v2.domain.schedule;

import com.lizcalendar.v2.dto.ScheduleDto;
import com.lizcalendar.v2.dto.UserDto;

import java.util.List;

public interface ScheduleService {

    ScheduleDto createSchedule(ScheduleDto scheduleDto);

    ScheduleDto updateSchedule(long scheduleId, ScheduleDto scheduleDto);

    //List<ScheduleDto> findSchedules(long userId);
}
