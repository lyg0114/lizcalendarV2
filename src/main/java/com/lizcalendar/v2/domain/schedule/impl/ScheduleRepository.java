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

        @Query(value = "select count(*) from schedule where lesson_start_dt < :lessonEndDt and lesson_end_dt > :lessonStartDt", nativeQuery=true)
        int checkSuitableTime(@Param("lessonStartDt") LocalDateTime lessonStartDt, @Param("lessonEndDt") LocalDateTime lessonEndDt);

}
