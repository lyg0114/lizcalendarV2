package com.lizcalendar.v2.exception;

import org.springframework.validation.Errors;

public class ScheduleTimeLimitException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private final String value;

    private Errors errors;

    public ScheduleTimeLimitException() {
        this.value = "1시간 이하로 예약 가능 합니다.";
    }

    public Errors getErrors(){
        return errors;
    }

    public String getValue(){
        return value;
    }
}
