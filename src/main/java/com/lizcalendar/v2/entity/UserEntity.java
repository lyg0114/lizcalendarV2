package com.lizcalendar.v2.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter@Setter
@Entity
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

    @Column(name="password", nullable = false, unique = true)
    private String password;

    @Column(name="is_admin")
    private boolean isAdmin;

    @OneToMany(mappedBy = "user")
    private List<Schedule> scheduleList = new ArrayList<>();

}
