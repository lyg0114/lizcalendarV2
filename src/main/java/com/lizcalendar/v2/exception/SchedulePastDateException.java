package com.lizcalendar.v2.exception;

import org.springframework.validation.Errors;

public class SchedulePastDateException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private final String value;

    private Errors errors;

    public SchedulePastDateException() {
        this.value = "지나간 날짜는 예약할 수 없습니다. ";
    }

    public Errors getErrors(){
        return errors;
    }

    public String getValue(){
        return value;
    }
}
