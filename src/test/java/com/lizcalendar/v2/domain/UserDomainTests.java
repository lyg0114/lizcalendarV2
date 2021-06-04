package com.lizcalendar.v2.domain;


import com.lizcalendar.v2.domain.domain.UserRepository;
import com.lizcalendar.v2.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class UserDomainTests {

    @Autowired
    private UserRepository userRepository;




    @Test
    public void 신규회원_등록(){
        UserEntity user = new UserEntity().builder()
                .nicName("yglee")
                .name("이영교")
                .password("1234")
                .build();

        UserEntity savedUser = userRepository.save(user);
        UserEntity findUser = userRepository.findById(savedUser.getId()).get();

        assertThat(findUser.getId()).isEqualTo(user.getId());
        assertThat(findUser.getNicName()).isEqualTo(user.getNicName());

    }





}
