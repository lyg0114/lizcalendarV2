package com.lizcalendar.v2.exception.Schedule;

public class SchedulePastDateException extends ScheduleException {


    private static final long serialVersionUID = 1L;

    public SchedulePastDateException() {
        super("지나간 날짜는 예약할 수 없습니다. ");

    }
}


