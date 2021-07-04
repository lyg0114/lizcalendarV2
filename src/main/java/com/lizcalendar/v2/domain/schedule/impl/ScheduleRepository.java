package com.lizcalendar.v2.domain.schedule.impl;

import com.lizcalendar.v2.entity.ScheduleEntity;
import com.lizcalendar.v2.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long> {

        ScheduleEntity findByLessonStartDtBetween(LocalDateTime lessonStartDt, LocalDateTime lessonEndDt);

        ScheduleEntity findByLessonEndDtBetween(LocalDateTime lessonStartDt, LocalDateTime lessonEndDt);


}
