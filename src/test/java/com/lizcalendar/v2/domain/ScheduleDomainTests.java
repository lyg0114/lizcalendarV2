package com.lizcalendar.v2.domain;


import com.lizcalendar.v2.domain.schedule.ScheduleRepository;
import com.lizcalendar.v2.domain.user.UserRepository;
import com.lizcalendar.v2.entity.ScheduleEntity;
import com.lizcalendar.v2.entity.UserEntity;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import java.time.LocalDate;
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
    public void 신규일정_등록(){

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

        UserEntity findUser = userRepository.findById(savedUser.getId()).get();

        findUser.getScheduleList().stream().forEach(i->{
            System.out.println(i.getScheduleType());
            assertThat(i.getUser().getId()).isEqualTo(findUser.getId());
        });

    }


}
