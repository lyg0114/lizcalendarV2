package com.lizcalendar.v2.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter@Setter
@Entity
@Table(name="SCHEDULE")
public class Schedule extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="schedule_id")
    private long id;

    @Column(name="schedule_type")
    private String scheduleType;

    @Column(name="lesson_time")
    private LocalDateTime lessonTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
