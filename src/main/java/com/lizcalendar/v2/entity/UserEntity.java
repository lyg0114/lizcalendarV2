package com.lizcalendar.v2.entity;


import com.lizcalendar.v2.entity.metaData.AuthLevel;
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
    private long id;

    @Column(name="name", nullable = false, length = 50)
    private String name;

    @Column(name="nic_name", nullable = false, length = 100, unique = true)
    private String nicName;

    @Column(name="password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name="auth_level")
    private AuthLevel authLevel;

    @OneToMany(mappedBy = "user")
    private List<ScheduleEntity> scheduleList = new ArrayList<>();

    public UserEntity() {

    }
}
