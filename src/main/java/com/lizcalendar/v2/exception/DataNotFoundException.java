package com.lizcalendar.v2.exception;

import org.springframework.validation.Errors;

public class DataNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String value;

    private Errors errors;

    public DataNotFoundException() {
        super("데이터를 찾을 수 없습니다.");
    }

    public Errors getErrors(){
        return errors;
    }

    public String getValue(){
        return value;
    }
}
