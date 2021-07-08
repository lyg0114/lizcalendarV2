package com.lizcalendar.v2.dto;

import com.lizcalendar.v2.entity.ScheduleEntity;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String name;

    private String nicName;

    private String password;

    private List<ScheduleDto> scheduleList = new ArrayList<>();

}
