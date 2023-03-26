package com.timeapi.timeapi.service;

import com.timeapi.timeapi.configuration.Bootstrap;
import com.timeapi.timeapi.model.Timezone;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TimeService {

    private Bootstrap bootstrap;

    @Value("${uri}")
    private String url;

    public TimeService(Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }
    public Timezone getTimeZoneDetails(String timezone) {
        RestTemplate template = bootstrap.getRestTemplate();
        ResponseEntity<Timezone> response = template.getForEntity(url+"/"+timezone, Timezone.class);
        return response.getBody();

    }
}
