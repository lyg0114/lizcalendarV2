package com.lizcalendar.v2.domain;


import com.lizcalendar.v2.domain.schedule.impl.ScheduleRepository;
import com.lizcalendar.v2.domain.user.impl.UserRepository;
import com.lizcalendar.v2.entity.ScheduleEntity;
import com.lizcalendar.v2.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ScheduleDomainTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Test
    public void 신규일정을_등록하라(){

        UserEntity userEntity = new UserEntity().builder()
                .nicName("yglee")
                .name("이영교")
                .password("1234")
                .scheduleList(new ArrayList<>())
                    .build();

        UserEntity savedUser = userRepository.save(userEntity);

       ScheduleEntity schedule = new ScheduleEntity().builder()
               .lessonStartDt(LocalDateTime.now())
               .lessonEndDt(LocalDateTime.now().plusMinutes(30))
               .scheduleType("LESSON1")
                    .build();
       schedule.setUser(userEntity);

        ScheduleEntity schedule2 = new ScheduleEntity().builder()
                .lessonStartDt(LocalDateTime.now().plusMinutes(40))
                .lessonEndDt(LocalDateTime.now().plusMinutes(70))
                .scheduleType("LESSON2")
                .build();
        schedule2.setUser(userEntity);

        ScheduleEntity schedule3 = new ScheduleEntity().builder()
                .lessonStartDt(LocalDateTime.now().plusMinutes(80))
                .lessonEndDt(LocalDateTime.now().plusMinutes(110))
                .scheduleType("LESSON3")
                .build();
        schedule3.setUser(userEntity);

        List<ScheduleEntity> ScheduleList = new ArrayList<>();
        ScheduleList.add(schedule);
        ScheduleList.add(schedule2);
        ScheduleList.add(schedule3);

        List<ScheduleEntity> saveScheduleList =  scheduleRepository.saveAll(ScheduleList);

        UserEntity findUser = userRepository.findById(savedUser.getUserId()).get();

        findUser.getScheduleList().stream().forEach(i->{
            System.out.println(i.getScheduleType());
            assertThat(i.getUser().getUserId()).isEqualTo(findUser.getUserId());
        });

    }

    @Test
    @Transactional
    public void 기존일정을_수정하라(){
        String originalNicName = "yglee";
        String originalName = "이영교";
        String originalPassword = "1234";
        String originalClassName = "LESSON1";

        String changedNicName = "c_yglee";
        String changedName = "c_이영교";
        String changedPassword = "c_1234";
        String changedClassName = "c_LESSON1";

        UserEntity userEntity = new UserEntity().builder()
                .nicName(originalNicName)
                .name(originalName)
                .password(originalPassword)
                .scheduleList(new ArrayList<>())
                .build();

        ScheduleEntity schedule = new ScheduleEntity().builder()
                .lessonStartDt(LocalDateTime.now())
                .lessonEndDt(LocalDateTime.now().plusMinutes(30))
                .scheduleType("LESSON1")
                .build();
        schedule.setUser(userEntity);

        UserEntity savedUser = userRepository.save(userEntity);
        scheduleRepository.save(schedule);


        UserEntity findUser = userRepository.findByNicName(originalNicName);
        System.out.println("findUser = " + findUser.getName());
        System.out.println("findUser.getScheduleList() = " + userRepository.findByNicName(originalNicName).getScheduleList().get(0).getScheduleType());

        ScheduleEntity findSchedule = scheduleRepository.findById(findUser.getScheduleList().get(0).getScheduleId()).get();
        System.out.println("findSchedule = " + findSchedule.getUser().getName());



    }

    @Test
    public void 중복시간을_확인하라(){

    }


}
