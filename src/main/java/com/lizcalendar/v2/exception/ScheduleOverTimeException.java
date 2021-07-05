package com.lizcalendar.v2.exception;

import org.springframework.validation.Errors;

public class ScheduleOverTimeException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private final String value;

    private Errors errors;

    public ScheduleOverTimeException() {
        this.value = "일주일 이내만 예약 가능 합니다.";
    }

    public Errors getErrors(){
        return errors;
    }

    public String getValue(){
        return value;
    }
}
