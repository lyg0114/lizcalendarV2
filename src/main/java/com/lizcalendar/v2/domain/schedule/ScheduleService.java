package com.lizcalendar.v2.domain.schedule;

import com.lizcalendar.v2.dto.ScheduleDto;

public interface ScheduleService {

    ScheduleDto createSchedule(ScheduleDto scheduleDto);

    ScheduleDto updateSchedule(long scheduleId, ScheduleDto scheduleDto);


}
