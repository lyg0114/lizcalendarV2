package com.lizcalendar.v2.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter@Setter
@Entity
@Table(name="SCHEDULE")
public class ScheduleEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="schedule_id")
    private long id;

    @Column(name="schedule_type")
    private String scheduleType;

    @Column(name="lesson_start_dt")
    private LocalDateTime lessonStartDt;

    @Column(name="lesson_end_dt")
    private LocalDateTime lessonEndDt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
