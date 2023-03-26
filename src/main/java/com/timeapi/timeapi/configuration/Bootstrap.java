package com.timeapi.timeapi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Bootstrap {

    @Bean
    @Scope(value="prototype")
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
