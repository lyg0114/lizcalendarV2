package com.lizcalendar.v2.domain.schedule.impl;

import com.lizcalendar.v2.entity.ScheduleEntity;
import com.lizcalendar.v2.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long> {

        @Query(value = "select count(m) from ScheduleEntity m where m.lessonStartDt < :lessonEndDt and m.lessonEndDt > :lessonStartDt and m.scheduleId <> :scheduleId" )
        int checkSuitableTime(@Param("lessonStartDt") LocalDateTime lessonStartDt,
                                       @Param("lessonEndDt") LocalDateTime lessonEndDt, @Param("scheduleId") long scheduleId);




}
