package com.lizcalendar.v2.domain.schedule;

import com.lizcalendar.v2.domain.user.UserService;
import com.lizcalendar.v2.dto.ScheduleDto;
import com.lizcalendar.v2.exception.ScheduleOverlapException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedule")
public class RestScheduleController {

    private ScheduleService scheduleService;
    private ModelMapper modelMapper;

    @Autowired
    public RestScheduleController(ScheduleService scheduleService, ModelMapper modelMapper) {
        this.scheduleService = scheduleService;
        this.modelMapper = modelMapper;
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createSchedule(@RequestBody ScheduleDto scheduleDto){

        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(scheduleService.createSchedule(scheduleDto));
        }catch (ScheduleOverlapException e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Duplicate Schedule");
        }


    }

}
