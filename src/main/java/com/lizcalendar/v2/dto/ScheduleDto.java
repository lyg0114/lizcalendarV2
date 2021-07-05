package com.lizcalendar.v2.dto;


import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@Builder
@NoArgsConstructor
public class ScheduleDto {

    private long userId;

    private String name;

    private String nicName;

    private String scheduleType;

    private LocalDateTime lessonStartDt;

    private LocalDateTime lessonEndDt;

    @Builder
    public ScheduleDto(long userId, String name, String nicName, String scheduleType, LocalDateTime lessonStartDt, LocalDateTime lessonEndDt) {
        this.userId = userId;
        this.name = name;
        this.nicName = nicName;
        this.scheduleType = scheduleType;
        this.lessonStartDt = lessonStartDt;
        this.lessonEndDt = lessonEndDt;
    }
}
