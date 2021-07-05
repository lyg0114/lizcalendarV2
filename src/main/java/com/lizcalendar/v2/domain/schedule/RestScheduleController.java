package com.lizcalendar.v2.domain.schedule;

import com.lizcalendar.v2.domain.user.UserService;
import com.lizcalendar.v2.dto.ScheduleDto;
import com.lizcalendar.v2.exception.*;
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
        HashMap map = new HashMap();
        try{
            map.put("data",scheduleService.createSchedule(scheduleDto));
            map.put("status", HttpStatus.CREATED);
            map.put("ment","일정이 등록 되었습니다.");
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(map);

        }
        catch (ScheduleTimeMisMatchException e){
            e.printStackTrace();
            map.put("ment", e.getValue());
            map.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(map);

        } catch (SchedulePastDateException e){
            e.printStackTrace();
            map.put("ment",e.getValue());
            map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(map);

        } catch (ScheduleOverTimeException e){
            e.printStackTrace();
            map.put("ment", e.getValue());
            map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(map);

        } catch (ScheduleTimeLimitException e){
            e.printStackTrace();
            map.put("ment",e.getValue());
            map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(map);

        } catch (ScheduleOverlapException e){
            e.printStackTrace();
            map.put("ment", e.getValue());
            map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(map);
        }
        catch (Exception e){
            e.printStackTrace();
            map.put("ment", "오류가 발생하였습니다.");
            map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(map);
        }


    }

}
