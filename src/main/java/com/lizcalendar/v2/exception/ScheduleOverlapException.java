package com.lizcalendar.v2.exception;

import org.springframework.validation.Errors;

public class ScheduleOverlapException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private final String value;

    private Errors errors;

    public ScheduleOverlapException() {
        this.value = "시간이 중복되었습니다.";
    }

    public Errors getErrors(){
        return errors;
    }

    public String getValue(){
        return value;
    }
}
