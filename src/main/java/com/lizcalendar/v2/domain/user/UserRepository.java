package com.lizcalendar.v2.domain.user;

import com.lizcalendar.v2.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {


}
