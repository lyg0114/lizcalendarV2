package com.lizcalendar.v2.domain.schedule;

import com.lizcalendar.v2.dto.ScheduleDto;
import com.lizcalendar.v2.exception.Schedule.ScheduleException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

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
        HashMap responseMap = new HashMap();

        try{
            responseMap.put("data",scheduleService.createSchedule(scheduleDto));
            responseMap.put("status", HttpStatus.CREATED.value());
            responseMap.put("ment","일정이 등록 되었습니다.");
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(responseMap);
        } catch (ScheduleException e){
            e.printStackTrace();
            responseMap.put("ment", e.getMessage());
            responseMap.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(responseMap);
        }

    }

    @PutMapping(value = "{scheduleId}/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity modifySchedule(@PathVariable long scheduleId, @RequestBody ScheduleDto scheduleDto){
        HashMap responseMap = new HashMap();
        try{
            responseMap.put("data",scheduleService.updateSchedule(scheduleId,scheduleDto));
            responseMap.put("status", HttpStatus.CREATED.value());
            responseMap.put("ment","일정이 수정 되었습니다.");
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(responseMap);
        } catch (ScheduleException e){
            e.printStackTrace();
            responseMap.put("ment", e.getMessage());
            responseMap.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(responseMap);
        }
    }



}
