package com.lizcalendar.v2.entity;


import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name="USERS")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 100, unique = true)
    private String userId;

    @Column(nullable = false, unique = true)
    private String encryptedPwd;




}
