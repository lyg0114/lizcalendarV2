package com.lizcalendar.v2.domain;


import com.lizcalendar.v2.domain.schedule.ScheduleRepository;
import com.lizcalendar.v2.domain.user.UserRepository;
import com.lizcalendar.v2.entity.ScheduleEntity;
import com.lizcalendar.v2.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

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
               .scheduleType("LESSON")
                    .build();

       schedule.setUser(userEntity);

        System.out.println("userEntity = " + userEntity);
        System.out.println("schedule = " + schedule);

        ScheduleEntity saveSchedule = scheduleRepository.save(schedule);
        ScheduleEntity findSchedule = scheduleRepository.findById(saveSchedule.getId()).get();

        System.out.println("findSchedule.toString() = " + findSchedule.toString());


//        assertThat(findSchedule.getId()).isEqualTo(schedule.getId());
//        assertThat(findSchedule.getUser().getNicName()).isEqualTo(schedule.getUser().getNicName());

    }


}
