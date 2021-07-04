package com.lizcalendar.v2.exception;

import org.springframework.validation.Errors;

public class ScheduleOverlapException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private final String value;

    private Errors errors;

    public ScheduleOverlapException(String value) {
        this.value = value;
    }

    public Errors getErrors(){
        return errors;
    }

    public String getValue(){
        return value;
    }
}
