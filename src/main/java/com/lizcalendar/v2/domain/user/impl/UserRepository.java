package com.lizcalendar.v2.domain.user.impl;

import com.lizcalendar.v2.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

        UserEntity findByNicName(String nicName);

}
