package com.lizcalendar.v2.entity;


import com.lizcalendar.v2.dto.ScheduleDto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter@Setter
@Entity
@Builder
@AllArgsConstructor
@Table(name="SCHEDULE")
public class ScheduleEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="schedule_id")
    private long scheduleId;

    @Column(name="schedule_type")
    private String scheduleType;

    @Column(name="lesson_start_dt")
    private LocalDateTime lessonStartDt;

    @Column(name="lesson_end_dt")
    private LocalDateTime lessonEndDt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public ScheduleEntity() {
    }

    public void setUser(UserEntity user){
        this.user = user;
        user.getScheduleList().add(this);
    }

    public ScheduleDto convertToDto() {
       return ScheduleDto.builder()
               .scheduleType(this.scheduleType)
               .lessonStartDt(this.lessonStartDt)
               .lessonEndDt(this.lessonEndDt)
               .userId(this.user.getUserId())
               .name(this.user.getName())
               .nicName(this.user.getNicName())
               .scheduleId(this.scheduleId)
               .build();
    }

}
