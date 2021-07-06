package com.lizcalendar.v2.exception;

import org.springframework.validation.Errors;

public class ScheduleOverlapException extends ScheduleException {

    private static final long serialVersionUID = 1L;

    public ScheduleOverlapException(){

        super("시간이 중복 되었습니다.");
    }





}
