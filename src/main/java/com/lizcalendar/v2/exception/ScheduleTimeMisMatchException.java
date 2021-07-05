package com.lizcalendar.v2.exception;

import org.springframework.validation.Errors;

public class ScheduleTimeMisMatchException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private final String value;

    private Errors errors;

    public ScheduleTimeMisMatchException() {
        this.value = "종료시간이 시작시간보다 앞설 수 없습니다.";
    }

    public Errors getErrors(){
        return errors;
    }

    public String getValue(){
        return value;
    }
}
