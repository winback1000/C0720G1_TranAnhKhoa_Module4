package com.codegym.config;

import com.codegym.concern.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    public Logger createLog(){
        return new Logger();
    }
}
