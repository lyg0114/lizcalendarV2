package com.lizcalendar.v2.dto;

import com.lizcalendar.v2.entity.metaData.AuthLevel;
import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String name;

    private String nicName;

    private AuthLevel authLevel;

    private String password;
}
