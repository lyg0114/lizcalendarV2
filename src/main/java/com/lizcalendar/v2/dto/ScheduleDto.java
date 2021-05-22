package com.lizcalendar.v2.dto;


import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDto {

    private LocalDateTime lessonTime;

    private String name;

    private String nicName;

    private String scheduleType;

}
