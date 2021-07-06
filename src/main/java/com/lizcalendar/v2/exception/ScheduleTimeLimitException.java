package com.lizcalendar.v2.exception;

import org.springframework.validation.Errors;

public class ScheduleTimeLimitException extends ScheduleException {

    private static final long serialVersionUID = 1L;

    public ScheduleTimeLimitException() {
        super("1시간 이하로 예약 가능 합니다.");
    }

}
