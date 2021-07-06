package com.lizcalendar.v2.exception;

import org.springframework.validation.Errors;

public class ScheduleOverTimeException extends ScheduleException {

    private static final long serialVersionUID = 1L;

    public ScheduleOverTimeException(){
        super("일주일 이내만 예약 가능 합니다.");
    }

}
