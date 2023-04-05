package com.timeapi.timeapi.controller;

import com.timeapi.timeapi.model.RequestValidator;
import com.timeapi.timeapi.model.Timezone;
import com.timeapi.timeapi.service.TimeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class TimeController {
    private TimeService timeService;
    private RequestValidator requestValidator;

    public TimeController(TimeService timeService, RequestValidator requestValidator){
        this.timeService = timeService;
        this.requestValidator = requestValidator;
    }

    /**
     * {@code getTimeZones} retrieves the timezone details related to passed timezone
     * @param timezone
     * @return
     */
    @GetMapping("/time")
    public ResponseEntity getTimeZones(@RequestParam("timezone") String timezone) {
        if (StringUtils.isEmpty(timezone)) {
            return new ResponseEntity("Please pass a valid timezone in the request.", HttpStatus.BAD_REQUEST);
        }
        if(!requestValidator.isAmericaTimezone(timezone)) {
            return new ResponseEntity("Timezone doesn't belong to US", HttpStatus.BAD_REQUEST);
        }
        Timezone response = timeService.getTimeZoneDetails(timezone);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
