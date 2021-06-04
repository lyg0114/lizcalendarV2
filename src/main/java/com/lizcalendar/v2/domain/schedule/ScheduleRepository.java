package com.lizcalendar.v2.domain.schedule;

import com.lizcalendar.v2.entity.ScheduleEntity;
import com.lizcalendar.v2.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long> {


}
