package com.lizcalendar.v2.exception.Schedule;

public class ScheduleTimeMisMatchException extends ScheduleException {

    private static final long serialVersionUID = 1L;

    public ScheduleTimeMisMatchException() {
        super("종료시간이 시작시간보다 앞설 수 없습니다.");
    }

}
