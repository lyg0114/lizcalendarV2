package com.lizcalendar.v2.domain.user.impl;

import com.lizcalendar.v2.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

        UserEntity findByNicName(String nicName);

        List<UserEntity> findAllByNicNameAndNameOrderByNameAsc(String nicName, String name);

}
