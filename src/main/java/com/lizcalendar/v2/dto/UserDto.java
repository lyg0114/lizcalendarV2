package com.lizcalendar.v2.dto;

import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String name;

    private String nicName;

    private boolean isAdmin;

}
