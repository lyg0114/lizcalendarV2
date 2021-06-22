package com.lizcalendar.v2.domain;


import com.lizcalendar.v2.domain.user.UserRepository;
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
    public void 신규회원을_등록하라(){

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


    @Test
    public void 회원정보를_수정하라(){
        String originalNicName = "yglee";
        String originalName = "이영교";
        String originalPassword = "1234";

        String changedNicName = "c_yglee";
        String changedName = "c_이영교";
        String changedPassword = "c_1234";

        UserEntity user = new UserEntity().builder()
                .nicName(originalNicName)
                .name(originalName)
                .password(originalPassword)
                .build();
        UserEntity savedUser = userRepository.save(user);


        UserEntity findUser = userRepository.findById(savedUser.getId()).get();
        findUser.setNicName(changedNicName);
        findUser.setName(changedName);
        findUser.setPassword(changedPassword);

        UserEntity updatedUser = userRepository.save(findUser);
        assertThat(updatedUser.getNicName()).isEqualTo(changedNicName);
        assertThat(updatedUser.getName()).isEqualTo(changedName);
        assertThat(updatedUser.getPassword()).isEqualTo(changedPassword);

    }




}
