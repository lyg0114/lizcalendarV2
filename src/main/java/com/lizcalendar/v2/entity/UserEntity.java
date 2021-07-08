package com.lizcalendar.v2.entity;

import com.lizcalendar.v2.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter@Setter
@Entity
@Builder
@AllArgsConstructor
@Table(name="USERS")
public class UserEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private long userId;

    @Column(name="name", nullable = false, length = 50)
    private String name;

    @Column(name="nic_name", nullable = false, length = 100, unique = true)
    private String nicName;

    @Column(name="password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<ScheduleEntity> scheduleList = new ArrayList<>();

    public UserEntity() {
    }

    public UserDto converToDto(){
          return UserDto.builder()
                .name(this.name)
                .nicName(this.nicName)
                .build();
    }

}
