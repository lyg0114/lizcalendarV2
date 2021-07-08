package com.lizcalendar.v2.dto;


import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
public class ScheduleDto {

    private long userId;

    private long scheduleId;

    private String name;

    private String nicName;

    private String scheduleType;

    private LocalDateTime lessonStartDt;

    private LocalDateTime lessonEndDt;

    @Builder
    public ScheduleDto(long userId, long scheduleId, String name, String nicName, String scheduleType,
                       LocalDateTime lessonStartDt, LocalDateTime lessonEndDt) {
        this.userId = userId;
        this.scheduleId = scheduleId;
        this.name = name;
        this.nicName = nicName;
        this.scheduleType = scheduleType;
        this.lessonStartDt = lessonStartDt;
        this.lessonEndDt = lessonEndDt;
    }
}
