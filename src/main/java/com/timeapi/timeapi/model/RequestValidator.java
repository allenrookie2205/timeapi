package com.timeapi.timeapi.model;

import com.timeapi.timeapi.configuration.Bootstrap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Objects;

@Service
public class RequestValidator {

    private Bootstrap bootstrap;

    @Value("${uri}")
    private String url;

    @Value("${content}")
    private String content;

    public RequestValidator(Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }
    public boolean isAmericaTimezone(String timezone) {
        RestTemplate restTemplate = bootstrap.getRestTemplate();
        ResponseEntity<String[]> resString = restTemplate.getForEntity(url, String[].class);
        String[] timeZones = resString.getBody();
        return Arrays.stream(timeZones).filter(Objects::nonNull)
                .anyMatch(str -> str.startsWith(timezone) && str.contains(content));
    }
}
