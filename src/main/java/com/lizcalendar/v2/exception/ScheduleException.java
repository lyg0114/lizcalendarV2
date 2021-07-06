package com.lizcalendar.v2.exception;

import org.springframework.validation.Errors;

public class ScheduleException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private String value;
    private Errors errors;

    public ScheduleException(String value) {
        super(value);
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
